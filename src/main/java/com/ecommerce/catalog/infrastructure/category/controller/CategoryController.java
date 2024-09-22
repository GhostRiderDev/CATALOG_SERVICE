package com.ecommerce.catalog.infrastructure.category.controller;

import java.io.IOException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.catalog.application.category.dto.CategoryDetailsDto;
import com.ecommerce.catalog.application.category.dto.CreateCategoryDto;
import com.ecommerce.catalog.application.category.service.ICategoryService;
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
  public CategoryDetailsDto createCategory(@RequestBody CreateCategoryDto createCategory)
      throws IOException {
    log.info("Creating category: {}", createCategory);
    return categoryService.saveCategory(createCategory);
  }

}
