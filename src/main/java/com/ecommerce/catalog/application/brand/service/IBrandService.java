package com.ecommerce.catalog.application.brand.service;

import java.util.List;
import com.ecommerce.catalog.application.brand.dto.BrandDetailsDto;
import com.ecommerce.catalog.application.brand.dto.CreateBrandDto;

public interface IBrandService {
    BrandDetailsDto createBrand(CreateBrandDto brandDto);
    BrandDetailsDto findBrandById(String id);
    List<BrandDetailsDto> findAllBrands();
}
