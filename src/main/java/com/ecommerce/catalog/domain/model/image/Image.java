package com.ecommerce.catalog.domain.model.image;

import java.time.LocalDateTime;

import com.ecommerce.catalog.domain.model.image.enumerate.ExtensionEnum;

public class Image {
  private String id;
  private String name;
  private String alt;
  private ExtensionEnum extension;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  // Intentar no colocar logica en el modelo
  public Image() {}

  public Image(String id, String name, String alt, ExtensionEnum extension, LocalDateTime createdAt,
      LocalDateTime updatedAt) {
    this.id = id;
    this.name = name;
    this.alt = alt;
    this.extension = extension;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }


  public String getAlt() {
    return alt;
  }

  public void setAlt(String alt) {
    this.alt = alt;
  }

  public ExtensionEnum getExtension() {
    return extension;
  }

  public void setExtension(ExtensionEnum extension) {
    this.extension = extension;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }


  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }



  @Override
  public String toString() {
    return "Image{" + "id='" + id + '\'' + "url='" + name + '\'' + ", alt='" + alt + '\''
        + ", extension=" + extension + '}';
  }

  public static ImageBuilder builder() {
    return new ImageBuilder();
  }

  public static class ImageBuilder {
    private String id;
    private String name;
    private String alt;
    private ExtensionEnum extension;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ImageBuilder id(String id) {
      this.id = id;
      return this;
    }

    public ImageBuilder name(String name) {
      this.name = name;
      return this;
    }

    public ImageBuilder alt(String alt) {
      this.alt = alt;
      return this;
    }

    public ImageBuilder extension(ExtensionEnum extension) {
      this.extension = extension;
      return this;
    }

    public ImageBuilder createdAt(LocalDateTime createdAt) {
      this.createdAt = createdAt;
      return this;
    }

    public ImageBuilder updatedAt(LocalDateTime updatedAt) {
      this.updatedAt = updatedAt;
      return this;
    }

    public Image build() {
      return new Image(id, name, alt, extension, createdAt, updatedAt);
    }
  }
}
