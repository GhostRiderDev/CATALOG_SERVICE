package com.ecommerce.catalog.infrastructure.category.controller;

import java.io.IOException;
import java.util.List;
import org.hibernate.validator.constraints.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.catalog.application.category.dto.CategoryDetailsDto;
import com.ecommerce.catalog.application.category.dto.CreateCategoryDto;
import com.ecommerce.catalog.application.category.service.ICategoryService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/categories")
@Slf4j
public class CategoryController {
  private final ICategoryService categoryService;

  public CategoryController(ICategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @PostMapping("/create")
  public ResponseEntity<CategoryDetailsDto> createCategory(@Valid @RequestBody CreateCategoryDto createCategory)
      throws IOException {
    return new ResponseEntity<>(categoryService.saveCategory(createCategory), HttpStatus.CREATED);
  }

  @GetMapping("/all")
  public ResponseEntity<List<CategoryDetailsDto>> getAllCategories() {
    return ResponseEntity.ok(categoryService.findAllProducts());
  }

  @GetMapping("/find/{id}")
  public ResponseEntity<CategoryDetailsDto> getCategoryById(@PathVariable("id") @UUID String id) {
    return ResponseEntity.ok(categoryService.findCategoryById(id));
  }

}
