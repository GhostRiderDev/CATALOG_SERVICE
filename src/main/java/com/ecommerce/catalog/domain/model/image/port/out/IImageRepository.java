package com.ecommerce.catalog.domain.model.image.port.out;

import java.util.List;

/**
 * IImageRepository
 */
public interface IImageRepository {
    List<Image> findAll();
    Optional<Image> findById(String id);
    Image save(Image image);
    Image updateById(String id, Image image);
    Image deleteById(String id);
}