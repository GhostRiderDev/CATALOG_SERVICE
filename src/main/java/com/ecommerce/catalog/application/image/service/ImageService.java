package com.ecommerce.catalog.application.image.service;

import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Service;
import com.ecommerce.catalog.application.image.dto.CreateImageDto;
import com.ecommerce.catalog.application.image.dto.ImageDetailsDto;
import com.ecommerce.catalog.application.image.mapper.IImageDtoModelMapper;
import com.ecommerce.catalog.domain.constant.Constant;
import com.ecommerce.catalog.domain.exception.NotFoundException;
import com.ecommerce.catalog.domain.model.image.Image;
import com.ecommerce.catalog.domain.model.image.port.out.IImageRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ImageService implements IImageService {

    private IImageRepository imageRepository;
    private IImageDtoModelMapper imageDtoModelMapper;
    private IAwsService awsService;

    public ImageService(IImageRepository imageRepository, IImageDtoModelMapper imageDtoModelMapper,
            IAwsService awsService) {
        this.imageRepository = imageRepository;
        this.imageDtoModelMapper = imageDtoModelMapper;
        this.awsService = awsService;
    }

    @Override
    public ImageDetailsDto uploadImage(CreateImageDto image) {
        Image imageToSave = imageDtoModelMapper.toModel(image);
        String fileName =  System.currentTimeMillis() + "_" + image.getFile().getOriginalFilename();
        imageToSave.setName(fileName);
        Image savedImage = imageRepository.save(imageToSave, fileName);
        String urlWithExpiration = awsService.uploadFile(image.getFile(), fileName);
        ImageDetailsDto imgToReturn = imageDtoModelMapper.toDto(savedImage, urlWithExpiration);
        imgToReturn.setUrl(urlWithExpiration);
        return imgToReturn;
    }

    @Override
    public List<ImageDetailsDto> findAllImages() {
        List<Image> images = imageRepository.findAll();

        return images.stream().map((img) -> {
            String urlWithExpiration = "Not found";
            try {
                urlWithExpiration = awsService.findUrlBlob(img.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return imageDtoModelMapper.toDto(img, urlWithExpiration);
        }).toList();
    }

    @Override
    public ImageDetailsDto findImageById(String id) throws IOException {
        Image image = imageRepository.findById(id);
        String urlWithExpiration = awsService.findUrlBlob(image.getName());
        ImageDetailsDto imageDto = imageDtoModelMapper.toDto(image, urlWithExpiration);
        imageDto.setUrl(awsService.findUrlBlob(image.getName()));
        return imageDto;
    }

    @Override
    public void imageExists(String id) {
        Image image = imageRepository.findById(id);
        if (image == null) {
            throw new NotFoundException(Constant.IMAGE_NOT_FOUND);
        }
    }

    @Override
    public Image findImgByIdInternal(String id) {
        return imageRepository.findById(id);
    }

}
