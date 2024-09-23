package com.ecommerce.catalog.domain.model.product.port;

import java.util.List;
import java.util.Optional;
import com.ecommerce.catalog.domain.model.price.Price;
import com.ecommerce.catalog.domain.model.product.Product;

public interface IProductRepository {
  Product save(Product product, Price price);

  Optional<Product> findById(String id);

  List<Product> findAll();
}
