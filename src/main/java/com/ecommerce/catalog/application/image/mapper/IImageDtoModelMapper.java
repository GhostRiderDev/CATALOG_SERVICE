package com.ecommerce.catalog.application.image.mapper;

import com.ecommerce.catalog.application.image.dto.CreateImageDto;
import com.ecommerce.catalog.application.image.dto.ImageDetailsDto;
import com.ecommerce.catalog.domain.model.image.Image;

public interface IImageDtoModelMapper {
  Image toModel(CreateImageDto createImageDto);
  ImageDetailsDto toDto(Image image, String url);
}
