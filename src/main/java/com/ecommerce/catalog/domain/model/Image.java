package com.ecommerce.catalog.domain.model;

import java.time.LocalDateTime;
import com.ecommerce.catalog.domain.enumerate.ExtensionEnum;

public class Image {
  private String id;
  private String url;
  private String alt;
  private ExtensionEnum extension;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  //Intentar no colocar logica en el modelo
  public Image() {}

  public Image(String id, String url, String alt, ExtensionEnum extension, LocalDateTime createdAt,
      LocalDateTime updatedAt) {
    this.id = id;
    this.url = url;
    this.alt = alt;
    this.extension = extension;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public String getId() {
    return id;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
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
    return "Image{" + "id='" + id + '\'' + "url='" + url + '\'' + ", alt='" + alt + '\''
        + ", extension=" + extension + '}';
  }

  public static ImageBuilder builder() {
    return new ImageBuilder();
  }

  public static class ImageBuilder {
    private String id;
    private String url;
    private String alt;
    private ExtensionEnum extension;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ImageBuilder id(String id) {
      this.id = id;
      return this;
    }

    public ImageBuilder url(String url) {
      this.url = url;
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
      return new Image(id, url, alt, extension, createdAt, updatedAt);
    }
  }
}
