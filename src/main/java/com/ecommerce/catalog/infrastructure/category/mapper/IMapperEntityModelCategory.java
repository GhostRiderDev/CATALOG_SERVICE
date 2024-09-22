package com.ecommerce.catalog.infrastructure.category.mapper;

import com.ecommerce.catalog.domain.model.category.Category;
import com.ecommerce.catalog.infrastructure.category.persistence.CategoryEntity;

public interface IMapperEntityModelCategory {
  CategoryEntity toEntity(Category category);
  Category toModel(CategoryEntity categoryEntity);
}
