package com.ecommerce.catalog.domain.model.brand.port.in;

import java.util.List;

import com.ecommerce.catalog.domain.model.brand.Brand;

public interface IBrandService {
    Brand saveBrand(Brand brand);
    Brand findBrandById(String id);
    List<Brand> findAllBrands();
}
