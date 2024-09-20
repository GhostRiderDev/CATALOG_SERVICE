package com.ecommerce.catalog.domain.model.brand.port.out;

import java.util.List;
import java.util.Optional;

import com.ecommerce.catalog.domain.model.brand.Brand;



public interface IBrandRepository {
    List<Brand> findAll();
    Optional<Brand> findById(String id);
    Brand save(Brand brand);
    Brand updateById(String id, Brand brand);
    Brand deleteById(String id);
}