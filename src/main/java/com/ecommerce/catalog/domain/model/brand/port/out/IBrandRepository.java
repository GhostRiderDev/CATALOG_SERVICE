package com.ecommerce.catalog.domain.model.brand.port.out;

import java.util.List;

import com.ecommerce.catalog.domain.model.brand.Brand;



public interface IBrandRepository {
    List<Brand> findAll();
    Brand findById(String id);
    Brand save(Brand brand);
    Brand updateById(String id, Brand brand);
    Brand deleteById(String id);
}