package com.ecommerce.catalog.domain.model;

import java.time.LocalDateTime;
import java.util.List;
import io.swagger.v3.oas.models.tags.Tag;

public class Product {
  private String id;
  private String name;
  private String description;
  private Price price;
  private List<Category> categories;
  private Brand brand;
  private List<Image> images;
  private List<Tag> tags;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  public Product() {}

  public Product(String id, String name, String description, Price price, List<Category> categories,
      Brand brand, List<Image> images, List<Tag> tags, LocalDateTime createdAt,
      LocalDateTime updatedAt) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
    this.categories = categories;
    this.brand = brand;
    this.images = images;
    this.tags = tags;
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

  public List<Tag> getTags() {
    return tags;
  }

  public void setTags(List<Tag> tags) {
    this.tags = tags;
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
        + brand + ", images=" + images + ", tags=" + tags + ", createdAt=" + createdAt
        + ", updatedAt=" + updatedAt + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    Product product = (Product) o;

    if (id != null ? !id.equals(product.id) : product.id != null)
      return false;
    if (name != null ? !name.equals(product.name) : product.name != null)
      return false;
    if (description != null ? !description.equals(product.description)
        : product.description != null)
      return false;
    if (price != null ? !price.equals(product.price) : product.price != null)
      return false;
    if (categories != null ? !categories.equals(product.categories) : product.categories != null)
      return false;
    if (brand != null ? !brand.equals(product.brand) : product.brand != null)
      return false;
    if (images != null ? !images.equals(product.images) : product.images != null)
      return false;
    if (tags != null ? tags.equals(product.tags) : product.tags == null)
      return false;
    if (createdAt != null ? !createdAt.equals(product.createdAt) : product.createdAt != null)
      return false;
    return updatedAt != null ? updatedAt.equals(product.updatedAt) : product.updatedAt == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (description != null ? description.hashCode() : 0);
    result = 31 * result + (price != null ? price.hashCode() : 0);
    result = 31 * result + (categories != null ? categories.hashCode() : 0);
    result = 31 * result + (brand != null ? brand.hashCode() : 0);
    result = 31 * result + (images != null ? images.hashCode() : 0);
    result = 31 * result + (tags != null ? tags.hashCode() : 0);
    result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
    result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
    return result;
  }


}
