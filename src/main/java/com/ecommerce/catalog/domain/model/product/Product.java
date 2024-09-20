package com.ecommerce.catalog.domain.model.product;

import java.time.LocalDateTime;
import java.util.List;

import com.ecommerce.catalog.domain.model.brand.Brand;
import com.ecommerce.catalog.domain.model.category.Category;
import com.ecommerce.catalog.domain.model.image.Image;
import com.ecommerce.catalog.domain.model.price.Price;

public class Product {
  private String id;
  private String name;
  private String description;
  private Price price;
  private List<Category> categories;
  private Brand brand;
  private List<Image> images;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;


  // Intentar no colocar logica en el modelo
  public Product() {}

  public Product(String id, String name, String description, Price price, List<Category> categories,
      Brand brand, List<Image> images, LocalDateTime createdAt, LocalDateTime updatedAt) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
    this.categories = categories;
    this.brand = brand;
    this.images = images;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Price getPrice() {
    return price;
  }

  public void setPrice(Price price) {
    this.price = price;
  }

  public List<Category> getCategories() {
    return categories;
  }

  public void setCategories(List<Category> categories) {
    this.categories = categories;
  }



  public Brand getBrand() {
    return brand;
  }

  public void setBrand(Brand brand) {
    this.brand = brand;
  }

  public List<Image> getImages() {
    return images;
  }

  public void setImages(List<Image> images) {
    this.images = images;
  }



  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }



  @Override
  public String toString() {
    return "Product{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", description='"
        + description + '\'' + ", price=" + price + ", categories=" + categories + ", brand="
        + brand + ", images=" + images + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
        + '}';
  }

  public static ProductBuilder builder() {
    return new ProductBuilder();
  }

  public static class ProductBuilder {
    private String id;
    private String name;
    private String description;
    private Price price;
    private List<Category> categories;
    private Brand brand;
    private List<Image> images;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProductBuilder id(String id) {
      this.id = id;
      return this;
    }

    public ProductBuilder name(String name) {
      this.name = name;
      return this;
    }

    public ProductBuilder description(String description) {
      this.description = description;
      return this;
    }

    public ProductBuilder price(Price price) {
      this.price = price;
      return this;
    }

    public ProductBuilder categories(List<Category> categories) {
      this.categories = categories;
      return this;
    }

    public ProductBuilder brand(Brand brand) {
      this.brand = brand;
      return this;
    }

    public ProductBuilder images(List<Image> images) {
      this.images = images;
      return this;
    }


    public ProductBuilder createdAt(LocalDateTime createdAt) {
      this.createdAt = createdAt;
      return this;
    }

    public ProductBuilder updatedAt(LocalDateTime updatedAt) {
      this.updatedAt = updatedAt;
      return this;
    }

    public Product build() {
      return new Product(id, name, description, price, categories, brand, images, tags, createdAt,
          updatedAt);
    }
  }

}
