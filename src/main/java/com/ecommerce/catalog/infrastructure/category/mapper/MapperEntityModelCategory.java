package com.ecommerce.catalog.infrastructure.category.mapper;

import org.springframework.stereotype.Component;
import com.ecommerce.catalog.domain.model.category.Category;
import com.ecommerce.catalog.domain.model.image.Image;
import com.ecommerce.catalog.infrastructure.category.persistence.CategoryEntity;
import com.ecommerce.catalog.infrastructure.image.persistence.ImageEntity;

@Component
public class MapperEntityModelCategory implements IMapperEntityModelCategory {
  public CategoryEntity toEntity(Category category) {
    return CategoryEntity.builder()
        .name(category.getName())
        .image(ImageEntity.builder()
            .id(category.getImage().getId())
            .build()
          )
        .build();
  }

  public Category toModel(CategoryEntity categoryEntity) {
    return Category.builder()
        .id(categoryEntity.getId())
        .name(categoryEntity.getName())
        .image(Image.builder()
            .id(categoryEntity.getImage().getId())
            .build()
          )
        .build();
  }
}