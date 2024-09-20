package com.ecommerce.catalog.domain.model.category.port.useCase;

import java.util.List;

import com.ecommerce.catalog.domain.constant.Constant;
import com.ecommerce.catalog.domain.exception.NotFoundException;
import com.ecommerce.catalog.domain.model.category.Category;
import com.ecommerce.catalog.domain.model.category.port.in.ICategoryService;


import com.ecommerce.catalog.domain.model.category.port.out.ICategoryRepository;

public class CategoryService implements ICategoryService {
    private final ICategoryRepository categoryRepository;

    public CategoryService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findAllProducts() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findProductById(String id) {
        return categoryRepository.findById(id)
                                 .orElseThrow(() -> new NotFoundException(Constant.CATEGORY_NOT_FOUND));
    }

 
}
