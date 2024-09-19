package com.ecommerce.catalog.domain.port.Service;

import java.util.List;
import com.ecommerce.catalog.domain.exception.NotFoundException;
import com.ecommerce.catalog.domain.model.Product;
import com.ecommerce.catalog.domain.port.in.service.IProductService;
import com.ecommerce.catalog.domain.port.out.repository.IProductRepository;

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
        .orElseThrow(() -> new NotFoundException("Product not found"));
  }

  @Override
  public List<Product> findAllProducts() {
    return productRepository.findAll();
  }

  @Override
  public Product deleteProduct(String id) {
    Product product = productRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Product not found"));
    return productRepository.deleteById(product.getId());
  }

  @Override
  public Product updateProduct(Product product) {
    Product existingProduct = productRepository.findById(product.getId())
        .orElseThrow(() -> new NotFoundException("Product not found"));
    return productRepository.updateById(existingProduct.getId(), product);
  }

}
