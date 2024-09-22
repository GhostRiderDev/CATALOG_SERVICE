package com.ecommerce.catalog.domain.model.image;

import java.net.URL;

public class Asset {
  private String name;
  private URL url;
  private String key;

  public Asset(String name, URL url, String key) {
    this.name = name;
    this.url = url;
    this.key = key;
  }

  public String getName() {
    return name;
  }

  public URL getUrl() {
    return url;
  }

  public String getKey() {
    return key;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setUrl(URL url) {
    this.url = url;
  }

  public void setKey(String key) {
    this.key = key;
  }


  public static class Builder {
    private String name;
    private URL url;
    private String key;

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder url(URL url) {
      this.url = url;
      return this;
    }

    public Builder key(String key) {
      this.key = key;
      return this;
    }

    public Asset build() {
      return new Asset(name, url, key);
    }
  }

  public static Builder builder() {
    return new Builder();
  }

}
