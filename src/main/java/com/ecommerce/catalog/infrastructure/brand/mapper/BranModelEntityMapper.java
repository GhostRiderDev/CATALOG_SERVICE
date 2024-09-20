package com.ecommerce.catalog.infrastructure.brand.mapper;

import org.springframework.stereotype.Component;
import com.ecommerce.catalog.domain.model.brand.Brand;
import com.ecommerce.catalog.infrastructure.brand.persistence.BrandEntity;

@Component
public class BranModelEntityMapper implements IBrandModelEntityMapper {

  @Override
  public Brand toModel(BrandEntity entity) {
    Brand brand = Brand.builder()
        .id(entity.getId())
        .name(entity.getName())
        .country(entity.getCountry())
        .createdAt(entity.getCreatedAt())
        .updatedAt(entity.getUpdatedAt())
        .build();
    return brand;
  }

  @Override
  public BrandEntity toEntity(Brand model) {
    BrandEntity entity = BrandEntity.builder()
        .id(model.getId())
        .name(model.getName())
        .country(model.getCountry())
        .createdAt(model.getCreatedAt())
        .updatedAt(model.getUpdatedAt())
        .build();
    return entity;
  }
  
}
