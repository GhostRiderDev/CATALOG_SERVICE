package com.ecommerce.catalog.domain.model.category.port.in;

import java.util.List;

import com.ecommerce.catalog.domain.model.category.Category;

public interface ICategoryService {
    Category saveCategory(Category category);
    List<Category> findAllProducts();
    Category findProductById(String id);
}
