package com.ecommerce.catalog.domain.model.image.port.useCase;

import java.util.List;

import com.ecommerce.catalog.domain.constant.Constant;
import com.ecommerce.catalog.domain.exception.NotFoundException;
import com.ecommerce.catalog.domain.model.image.Image;
import com.ecommerce.catalog.domain.model.image.port.in.IImageService;
import com.ecommerce.catalog.domain.model.image.port.out.IImageRepository;

public class ImageService implements IImageService {

    private IImageRepository imageRepository;

    public ImageService(IImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Image saveImage(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public List<Image> findAllImages() {
        return imageRepository.findAll();
    }

    @Override
    public Image findImageById(String id) {
        return imageRepository.findById(id).orElseThrow(() -> new NotFoundException(Constant.RESOURCE_NOT_FOUND));
    }

}
