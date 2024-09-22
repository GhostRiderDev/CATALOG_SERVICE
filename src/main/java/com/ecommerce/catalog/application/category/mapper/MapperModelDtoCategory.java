package com.ecommerce.catalog.application.category.mapper;

import org.springframework.stereotype.Component;
import com.ecommerce.catalog.application.category.dto.CategoryDetailsDto;
import com.ecommerce.catalog.application.category.dto.CreateCategoryDto;
import com.ecommerce.catalog.application.image.dto.ImageDetailsDto;
import com.ecommerce.catalog.domain.model.category.Category;
import com.ecommerce.catalog.domain.model.image.Image;

@Component
public class MapperModelDtoCategory implements IMapperModelDtoCategory {

  @Override
  public CategoryDetailsDto toDto(Category category, ImageDetailsDto imageDto) {
    return CategoryDetailsDto.builder()
      .id(category.getId())
      .name(category.getName())
      .image(imageDto)
      .build();
  }

  @Override
  public Category toModel(CreateCategoryDto createCategoryDto, Image image) {
    return Category.builder()
      .name(createCategoryDto.getName())
      .image(image)
      .build();
  }
  
}
