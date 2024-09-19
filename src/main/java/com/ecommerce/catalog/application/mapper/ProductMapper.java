package com.ecommerce.catalog.application.mapper;

import java.util.List;
import com.ecommerce.catalog.application.dto.CreateProductDto;
import com.ecommerce.catalog.domain.enumerate.ExtensionEnum;
import com.ecommerce.catalog.domain.model.Image;
import com.ecommerce.catalog.domain.model.Price;
import com.ecommerce.catalog.domain.model.Product;

public class ProductMapper implements IProductMapper {

  @Override
  public Product toModel(CreateProductDto createProductDto, String id) {
    Price price = Price.builder().value(createProductDto.getPrice().getValue())
        .currency(createProductDto.getPrice().getCurrency()).build();

    List<Image> images = createProductDto
        .getImages().stream().<Image>map(image -> Image.builder().url(image.getUrl())
            .alt(image.getAlt()).extension(ExtensionEnum.valueOf(image.getExtension())).build())
        .toList();

    return Product.builder().id(id).name(createProductDto.getName())
        .description(createProductDto.getDescription()).price(price).images(images).build();
  }

  @Override
  public CreateProductDto toDto(Product product) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'toDto'");
  }

}
