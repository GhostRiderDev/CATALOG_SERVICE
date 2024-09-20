package com.ecommerce.catalog.application.product.service;

import java.util.List;
import com.ecommerce.catalog.application.product.dto.CreateProductDto;
import com.ecommerce.catalog.application.product.dto.ProductDetailsDto;
import com.ecommerce.catalog.application.product.mapper.IProductMapper;
import com.ecommerce.catalog.application.product.port.IProductService;
import com.ecommerce.catalog.domain.constant.Constant;
import com.ecommerce.catalog.domain.exception.NotFoundException;

import com.ecommerce.catalog.domain.model.product.Product;
import com.ecommerce.catalog.domain.model.product.port.IProductRepository;

public class ProductService implements IProductService {

  private final IProductRepository productRepository;
  private final IProductMapper productMapper;

  public ProductService(IProductRepository productRepository, IProductMapper productMapper) {
    this.productRepository = productRepository;
    this.productMapper = productMapper;
  }

  @Override
  public ProductDetailsDto saveProduct(CreateProductDto productDto) {
    Product product = productMapper.toModel(productDto, null);
    Product productSaved = productRepository.save(product);
    ProductDetailsDto productDetailsDto = productMapper.toDetailsDto(productSaved);
    return productDetailsDto;
  }

  @Override
  public ProductDetailsDto findProductById(String id) {
    Product productDB = productRepository.findById(id)
        .orElseThrow(() -> new NotFoundException(Constant.PRODUCT_NOT_FOUND));
    return productMapper.toDetailsDto(productDB);
  }

  @Override
  public List<ProductDetailsDto> findAllProducts() {
    return productRepository.findAll().stream().map(productMapper::toDetailsDto).toList();
  }
}
