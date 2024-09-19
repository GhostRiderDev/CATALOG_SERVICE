package com.ecommerce.catalog.domain.port.in.service;

import java.util.List;
import com.ecommerce.catalog.domain.model.Product;

public interface IProductService {
  Product saveProduct(Product product);

  Product findProductById(String id);

  List<Product> findAllProducts();

  Product deleteProduct(String id);

  Product updateProduct(Product product);
}
