package com.ecommerce.catalog.application.category.service;

import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Service;
import com.ecommerce.catalog.application.category.dto.CategoryDetailsDto;
import com.ecommerce.catalog.application.category.dto.CreateCategoryDto;
import com.ecommerce.catalog.domain.model.category.Category;

@Service
public interface ICategoryService {
    CategoryDetailsDto saveCategory(CreateCategoryDto createCategoryDto) throws IOException;
    List<CategoryDetailsDto> findAllProducts();
    CategoryDetailsDto findCategoryById(String id);
    Category findCategoryByIdInternal(String id);
}
