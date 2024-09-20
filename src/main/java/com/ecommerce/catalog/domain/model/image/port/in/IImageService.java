package com.ecommerce.catalog.domain.model.image.port.in;

import java.util.List;

import com.ecommerce.catalog.domain.model.image.Image;

public interface IImageService {
    Image saveImage(Image image);
    List<Image> findAllImages();
    Image findImageById(String id);
}
