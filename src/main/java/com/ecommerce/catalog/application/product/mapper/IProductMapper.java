package com.ecommerce.catalog.application.product.mapper;

import com.ecommerce.catalog.application.product.dto.CreateProductDto;
import com.ecommerce.catalog.domain.model.product.Product;

public interface IProductMapper {
  Product toModel(CreateProductDto createProductDto, String id);

  CreateProductDto toDto(Product product);
}
