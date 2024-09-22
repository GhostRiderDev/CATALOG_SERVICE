package com.ecommerce.catalog.application.image.mapper;

import org.springframework.stereotype.Component;
import com.ecommerce.catalog.application.image.dto.CreateImageDto;
import com.ecommerce.catalog.application.image.dto.ImageDetailsDto;
import com.ecommerce.catalog.domain.model.image.Image;
import com.ecommerce.catalog.domain.model.image.enumerate.ExtensionEnum;

@Component
public class ImageDtoModelMapper implements IImageDtoModelMapper {

  @Override
  public Image toModel(CreateImageDto createImageDto) {
    return Image.builder()
        .name(createImageDto.getName())
        .alt(createImageDto.getAlt())
        .extension(ExtensionEnum.getExtension(createImageDto.getExtension())).build();
  }

  @Override
  public ImageDetailsDto toDto(Image image, String url) {
    return ImageDetailsDto.builder()
      .id(image.getId())
      .url(url)
      .alt(image.getAlt())
      .extension(image.getExtension())
      .build();
  }

}
