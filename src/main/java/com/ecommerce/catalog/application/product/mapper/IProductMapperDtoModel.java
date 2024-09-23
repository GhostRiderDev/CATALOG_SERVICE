package com.ecommerce.catalog.application.product.mapper;

import java.util.List;
import com.ecommerce.catalog.application.product.dto.CreateProductDto;
import com.ecommerce.catalog.application.product.dto.ProductDetailsDto;
import com.ecommerce.catalog.domain.model.brand.Brand;
import com.ecommerce.catalog.domain.model.category.Category;
import com.ecommerce.catalog.domain.model.image.Image;
import com.ecommerce.catalog.domain.model.product.Product;

public interface IProductMapperDtoModel {
  Product toModel(CreateProductDto productDto, List<Image> images, List<Category> categories, Brand brand);

  ProductDetailsDto toDetailsDto(Product product, List<Category> categories, List<Image> images, Brand brand);
}
