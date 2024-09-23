package com.ecommerce.catalog.infrastructure.brand.controller;

import java.util.List;
import org.hibernate.validator.constraints.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<BrandDetailsDto> createBrand(@Valid @RequestBody CreateBrandDto createBrandDto) {
    return new ResponseEntity<>(brandService.createBrand(createBrandDto), HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<BrandDetailsDto>> getAllBrands() {
    return ResponseEntity.ok(brandService.findAllBrands());
  }

  @GetMapping("/{id}")
  public ResponseEntity<BrandDetailsDto> getBrandById(@PathVariable("id") @UUID String id) {
    return ResponseEntity.ok(brandService.findBrandById(id));
  }
}
