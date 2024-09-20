package com.ecommerce.catalog.domain.model.product.port.useCase;

import java.util.List;

import com.ecommerce.catalog.domain.constant.Constant;
import com.ecommerce.catalog.domain.exception.NotFoundException;

import com.ecommerce.catalog.domain.model.product.Product;
import com.ecommerce.catalog.domain.model.product.port.in.IProductService;
import com.ecommerce.catalog.domain.model.product.port.out.IProductRepository;

public class ProductService implements IProductService {

  private final IProductRepository productRepository;

  public ProductService(IProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public Product saveProduct(Product product) {
    return productRepository.save(product);
  }

  @Override
  public Product findProductById(String id) {
    return productRepository.findById(id)
        .orElseThrow(() -> new NotFoundException(Constant.PRODUCT_NOT_FOUND));
  }

  @Override
  public List<Product> findAllProducts() {
    return productRepository.findAll();
  }



}
