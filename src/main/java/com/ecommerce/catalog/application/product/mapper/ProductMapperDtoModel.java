package com.ecommerce.catalog.application.product.mapper;

import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Component;
import com.ecommerce.catalog.domain.model.category.Category;
import com.ecommerce.catalog.application.brand.mapper.IBrandModelDtoMapper;
import com.ecommerce.catalog.application.category.mapper.IMapperModelDtoCategory;
import com.ecommerce.catalog.application.image.mapper.IImageDtoModelMapper;
import com.ecommerce.catalog.application.image.service.IImageService;
import com.ecommerce.catalog.application.price.dto.PriceDto;
import com.ecommerce.catalog.application.product.dto.CreateProductDto;
import com.ecommerce.catalog.application.product.dto.ProductDetailsDto;
import com.ecommerce.catalog.domain.model.brand.Brand;
import com.ecommerce.catalog.domain.model.image.Image;
import com.ecommerce.catalog.domain.model.price.Price;
import com.ecommerce.catalog.domain.model.product.Product;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ProductMapperDtoModel implements IProductMapperDtoModel {
  private final IImageDtoModelMapper imageMapper;
  private final IMapperModelDtoCategory categoryMapper;
  private final IBrandModelDtoMapper brandMapper;
  private final IImageService imageService;

  public ProductMapperDtoModel(IImageDtoModelMapper imageMapper, IMapperModelDtoCategory categoryMapper,
      IBrandModelDtoMapper brandMapper, IImageService imageService) {
    this.imageMapper = imageMapper;
    this.categoryMapper = categoryMapper;
    this.brandMapper = brandMapper;
    this.imageService = imageService;
  }

  @Override
  public Product toModel(CreateProductDto productDto, List<Image> images, List<Category> categories, Brand brand) {
   

    PriceDto priceDto = productDto.getPrice();
    Price price = new Price();
    price.setCurrency(priceDto.getCurrency());
    price.setValue(priceDto.getValue());


    Product product = new Product();
    product.setName(productDto.getName());
    product.setDescription(productDto.getDescription());
    product.setImages(images);
    product.setCategories(categories);
    product.setBrand(brand);
    product.setPrice(price);

    return product;
  }

  @Override
  public ProductDetailsDto toDetailsDto(Product product, List<Category> categories, List<Image> images, Brand brand) {
   return ProductDetailsDto.builder()
        .id(product.getId())
        .name(product.getName())
        .description(product.getDescription())
        .price(product.getPrice())
        .categories(product.getCategories().stream().map((category) -> {
          try {
            return categoryMapper.toDto(category, imageService.findImageById(category.getImage().getId()));
          } catch (IOException e) {
            e.printStackTrace();
          }
          return null;
        }).toList())
        .brand(brandMapper.toDto(product.getBrand()))
        .images(product.getImages().stream().map((image) -> {
          try {
            return imageService.findImageById(image.getId());
          } catch (IOException e) {
            e.printStackTrace();
          }
          return null;
        }).toList())
        .build();
  }

}
