package com.ecommerce.catalog.infrastructure.brand.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.catalog.application.brand.dto.CreateBrandDto;
import com.ecommerce.catalog.application.brand.service.IBrandService;

@RestController
@RequestMapping("/brands")
public class BrandController {
  private final IBrandService brandService;

  public BrandController(IBrandService brandService) {
    this.brandService = brandService;
  }

  @PostMapping("/create")
  public void createBrand(@RequestBody CreateBrandDto createBrandDto) {
    brandService.createBrand(createBrandDto);
  }
}
