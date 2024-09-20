package com.ecommerce.catalog.infrastructure.product.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

  @GetMapping
  public ResponseEntity<String> getProducts() {
    return ResponseEntity.ok("Products");
  }

}
