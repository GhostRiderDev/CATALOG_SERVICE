package com.ecommerce.catalog.domain.model.product.port.in;

import java.util.List;

import com.ecommerce.catalog.domain.model.product.Product;

public interface IProductService {
  Product saveProduct(Product product);

  Product findProductById(String id);

  List<Product> findAllProducts();

}
