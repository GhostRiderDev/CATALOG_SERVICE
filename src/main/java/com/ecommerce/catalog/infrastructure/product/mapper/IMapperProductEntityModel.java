package com.ecommerce.catalog.infrastructure.product.mapper;

import com.ecommerce.catalog.domain.model.price.Price;
import com.ecommerce.catalog.domain.model.product.Product;
import com.ecommerce.catalog.infrastructure.product.persistence.ProductEntity;

public interface IMapperProductEntityModel {
  public ProductEntity toEntity(Product product, Price price);
  public Product toModel(ProductEntity productEntity);
}
