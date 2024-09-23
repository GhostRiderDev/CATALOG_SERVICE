package com.ecommerce.catalog.infrastructure.product.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.catalog.application.product.dto.CreateProductDto;
import com.ecommerce.catalog.application.product.dto.ProductDetailsDto;
import com.ecommerce.catalog.application.product.service.IProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
  private final IProductService productService;

  public ProductController(IProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/all")
  public ResponseEntity<List<ProductDetailsDto>> getProducts() {
    return ResponseEntity.ok(productService.findAllProducts());
  }

  @PostMapping
  public ResponseEntity<ProductDetailsDto> saveProduct(@RequestBody CreateProductDto productDto) {
    return ResponseEntity.ok(productService.saveProduct(productDto));
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductDetailsDto> getProduct(@PathVariable("id") String id) {
    return ResponseEntity.ok(productService.findProductById(id));
  }

}
