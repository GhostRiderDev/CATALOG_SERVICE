package com.ecommerce.catalog.domain.model.image.port.out;

import java.util.List;
import com.ecommerce.catalog.domain.model.image.Image;

/**
 * IImageRepository
 */
public interface IImageRepository {
    List<Image> findAll();
    Image findById(String id);
    Image save(Image image, String fileName);
}