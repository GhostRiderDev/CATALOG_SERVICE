package com.ecommerce.catalog.domain.model.category.port.out;

import java.util.List;
import java.util.Optional;

import com.ecommerce.catalog.domain.model.category.Category;

public interface ICategoryRepository {
    List<Category> findAll();
    Optional<Category> findById(String id);
    Category save(Category category);
    Category updateById(String id, Category category);
    Category deleteById(String id);
}