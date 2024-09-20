package com.ecommerce.catalog.application.brand.mapper;

import org.springframework.stereotype.Component;
import com.ecommerce.catalog.application.brand.dto.BrandDetailsDto;
import com.ecommerce.catalog.application.brand.dto.CreateBrandDto;
import com.ecommerce.catalog.domain.model.brand.Brand;


@Component
public class BrandModelDtoMapper implements IBrandModelDtoMapper {

    @Override
    public BrandDetailsDto toDto(Brand brand) {
        return BrandDetailsDto.builder()
                .id(brand.getId())
                .name(brand.getName())
                .country(brand.getCountry())
                .build();
    }

    @Override
    public Brand toModel(CreateBrandDto createBrandDto) {
        return Brand.builder()
                .name(createBrandDto.getName())
                .country(createBrandDto.getCountry())
                .build();
    }
  
}
