package com.ecommerce.catalog.application.brand.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.ecommerce.catalog.application.brand.dto.BrandDetailsDto;
import com.ecommerce.catalog.application.brand.dto.CreateBrandDto;
import com.ecommerce.catalog.application.brand.mapper.IBrandModelDtoMapper;
import com.ecommerce.catalog.domain.model.brand.Brand;
import com.ecommerce.catalog.domain.model.brand.port.out.IBrandRepository;

@Service
public class BrandService implements IBrandService {
    private final IBrandRepository brandRepository;
    private final IBrandModelDtoMapper brandModelDtoMapper;

    public BrandService(IBrandRepository brandRepository, IBrandModelDtoMapper brandModelDtoMapper) {
        this.brandRepository = brandRepository;
        this.brandModelDtoMapper = brandModelDtoMapper;
    }

    @Override
    public BrandDetailsDto createBrand(CreateBrandDto brandDto) {
        Brand brand = brandModelDtoMapper.toModel(brandDto);
        Brand savedBrand = brandRepository.save(brand);
        return brandModelDtoMapper.toDto(savedBrand);
    }

    @Override
    public BrandDetailsDto findBrandById(String id) {
        Brand brand = brandRepository.findById(id);
        return brandModelDtoMapper.toDto(brand);
    }

    @Override
    public List<BrandDetailsDto> findAllBrands() {
        return brandRepository.findAll()
                .stream()
                .map(brandModelDtoMapper::toDto)
                .toList();
    }
    
}
