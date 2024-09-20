package com.ecommerce.catalog.domain.model.brand.port.useCase;

import java.util.List;

import com.ecommerce.catalog.domain.constant.Constant;
import com.ecommerce.catalog.domain.exception.NotFoundException;
import com.ecommerce.catalog.domain.model.brand.Brand;
import com.ecommerce.catalog.domain.model.brand.port.in.IBrandService;
import com.ecommerce.catalog.domain.model.brand.port.out.IBrandRepository;

public class BrandService implements IBrandService {
    private final IBrandRepository brandRepository;

    public BrandService(IBrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Brand saveBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand findBrandById(String id) {
        return brandRepository.findById(id)
        .orElseThrow(() -> new NotFoundException(Constant.BRAND_NOT_FOUND));
    }

    @Override
    public List<Brand> findAllBrands() {
        return brandRepository.findAll();
    }
    
}
