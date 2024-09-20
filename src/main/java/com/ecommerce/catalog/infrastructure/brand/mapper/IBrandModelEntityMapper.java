package com.ecommerce.catalog.infrastructure.brand.mapper;

import com.ecommerce.catalog.domain.model.brand.Brand;
import com.ecommerce.catalog.infrastructure.brand.persistence.BrandEntity;

public interface IBrandModelEntityMapper {
  Brand toModel(BrandEntity entity);

  BrandEntity toEntity(Brand model);
}
