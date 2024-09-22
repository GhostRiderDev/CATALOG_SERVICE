package com.ecommerce.catalog.application.image.service;

import java.io.IOException;
import java.util.List;
import com.ecommerce.catalog.application.image.dto.CreateImageDto;
import com.ecommerce.catalog.application.image.dto.ImageDetailsDto;
import com.ecommerce.catalog.domain.model.image.Image;

public interface IImageService {
    ImageDetailsDto uploadImage(CreateImageDto image);
    List<ImageDetailsDto> findAllImages();
    ImageDetailsDto findImageById(String id) throws IOException;
    void imageExists(String id);
    Image findImgByIdInternal(String id);
}
