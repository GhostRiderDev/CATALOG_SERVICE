package com.ecommerce.catalog.application.product.port;

import java.util.List;
import com.ecommerce.catalog.application.product.dto.CreateProductDto;
import com.ecommerce.catalog.application.product.dto.ProductDetailsDto;


public interface IProductService {
  ProductDetailsDto saveProduct(CreateProductDto createProductDto);

  ProductDetailsDto findProductById(String id);

  List<ProductDetailsDto> findAllProducts();

}
