package com.ecommerce.catalog.domain.model.category.port.out;

interface ICategoryRepository {
    List<Category> findAll();
    Optional<Category> findById(String id);
    Category save(Category category);
    Category updateById(String id, Category category);
    Category deleteById(String id);
}