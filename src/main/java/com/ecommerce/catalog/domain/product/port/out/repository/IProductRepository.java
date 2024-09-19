package com.ecommerce.catalog.domain.port.out.repository;

import java.util.List;
import java.util.Optional;
import com.ecommerce.catalog.domain.model.Product;

public interface IProductRepository {
  Product save(Product product);

  Optional<Product> findById(String id);

  List<Product> findAll();

  Product deleteById(String id);

  Product updateById(String id, Product product);

}
