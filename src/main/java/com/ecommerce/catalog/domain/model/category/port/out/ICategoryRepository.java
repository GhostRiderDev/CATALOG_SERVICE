package com.ecommerce.catalog.domain.model.category.port.out;

import java.util.List;
import com.ecommerce.catalog.domain.model.category.Category;

public interface ICategoryRepository {
    List<Category> findAll();

    Category findById(String id);

    Category save(Category category);
}
