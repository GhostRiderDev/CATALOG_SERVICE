package com.ecommerce.catalog.infrastructure.brand.controller;

import java.util.List;
import org.hibernate.validator.constraints.UUID;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.catalog.application.brand.dto.BrandDetailsDto;
import com.ecommerce.catalog.application.brand.dto.CreateBrandDto;
import com.ecommerce.catalog.application.brand.service.IBrandService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/brands")
@Validated
public class BrandController {
  private final IBrandService brandService;

  public BrandController(IBrandService brandService) {
    this.brandService = brandService;
  }

  @PostMapping("/create")
  public BrandDetailsDto createBrand(@Valid @RequestBody CreateBrandDto createBrandDto) {
    return brandService.createBrand(createBrandDto);
  }

  @GetMapping
  public List<BrandDetailsDto> getAllBrands() {
    return brandService.findAllBrands();
  }

  @GetMapping("/{id}")
  public BrandDetailsDto getBrandById(@PathVariable("id") @UUID String id) {
    return brandService.findBrandById(id);
  }
}
