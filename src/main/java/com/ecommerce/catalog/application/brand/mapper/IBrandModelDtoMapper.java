package com.ecommerce.catalog.application.brand.mapper;

import com.ecommerce.catalog.application.brand.dto.BrandDetailsDto;
import com.ecommerce.catalog.application.brand.dto.CreateBrandDto;
import com.ecommerce.catalog.domain.model.brand.Brand;

public interface IBrandModelDtoMapper {
  BrandDetailsDto toDto(Brand brand);

  Brand toModel(CreateBrandDto createBrandDto);
}
