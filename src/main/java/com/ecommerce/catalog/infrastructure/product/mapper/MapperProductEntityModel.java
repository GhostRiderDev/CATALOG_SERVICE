package com.ecommerce.catalog.infrastructure.product.mapper;

import java.util.List;
import org.springframework.stereotype.Component;
import com.ecommerce.catalog.domain.model.price.Price;
import com.ecommerce.catalog.domain.model.product.Product;
import com.ecommerce.catalog.infrastructure.brand.mapper.IBrandModelEntityMapper;
import com.ecommerce.catalog.infrastructure.brand.persistence.BrandEntity;
import com.ecommerce.catalog.infrastructure.category.mapper.IMapperEntityModelCategory;
import com.ecommerce.catalog.infrastructure.category.persistence.CategoryEntity;
import com.ecommerce.catalog.infrastructure.image.mapper.IMapperEntityModelImage;
import com.ecommerce.catalog.infrastructure.image.persistence.ImageEntity;
import com.ecommerce.catalog.infrastructure.price.PriceEmbbed;
import com.ecommerce.catalog.infrastructure.product.persistence.ProductEntity;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MapperProductEntityModel implements IMapperProductEntityModel {
  private final IBrandModelEntityMapper brandMapper;
  private final IMapperEntityModelImage imageMapper;
  private final IMapperEntityModelCategory categoryMapper;

  public MapperProductEntityModel(IBrandModelEntityMapper brandMapper,
      IMapperEntityModelImage imageMapper, IMapperEntityModelCategory categoryMapper) {
    this.brandMapper = brandMapper;
    this.imageMapper = imageMapper;
    this.categoryMapper = categoryMapper;
  }

  @Override
  public ProductEntity toEntity(Product product, Price price) {
    PriceEmbbed priceEmbbed = PriceEmbbed
        .builder()
        .value(price.getValue())
        .currency(price.getCurrency())
        .build();
    BrandEntity brandEntity = brandMapper.toEntity(product.getBrand());
    
    List<CategoryEntity> categories = product.getCategories().stream().map((category) -> {
      CategoryEntity categoryEntity = categoryMapper.toEntity(category);
      return categoryEntity;
    }).toList();

    List<ImageEntity> images = product.getImages()
        .stream()
        .map(imageMapper::toEntity)
        .toList();
    
    return ProductEntity.builder()
        .id(product.getId())
        .name(product.getName())
        .description(product.getDescription())
        .price(priceEmbbed)
        .brand(brandEntity)
        .categories(categories)
        .images(images).build();
  }

  @Override
  public Product toModel(ProductEntity productEntity) {
    log.info("ProductEntity: {} ********", productEntity);
    return Product.builder().id(productEntity.getId()).name(productEntity.getName())
        .description(productEntity.getDescription())
        .brand(brandMapper.toModel(productEntity.getBrand()))
        .categories(productEntity.getCategories().stream().map(categoryMapper::toModel).toList())
        .price(Price.builder().value(productEntity.getPrice().getValue())
            .currency(productEntity.getPrice().getCurrency()).build())
        .images(productEntity.getImages().stream().map(imageMapper::toModel).toList()).build();
  }

}
