package com.ecommerce.catalog.application.category.mapper;

import com.ecommerce.catalog.application.category.dto.CategoryDetailsDto;
import com.ecommerce.catalog.application.category.dto.CreateCategoryDto;
import com.ecommerce.catalog.application.image.dto.ImageDetailsDto;
import com.ecommerce.catalog.domain.model.category.Category;
import com.ecommerce.catalog.domain.model.image.Image;

public interface IMapperModelDtoCategory {
  public CategoryDetailsDto toDto(Category category, ImageDetailsDto image);
  public Category toModel(CreateCategoryDto createCategoryDto, Image image);
}
