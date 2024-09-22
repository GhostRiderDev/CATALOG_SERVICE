package com.ecommerce.catalog.infrastructure.image.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.ecommerce.catalog.application.image.dto.CreateImageDto;
import com.ecommerce.catalog.application.image.dto.ImageDetailsDto;
import com.ecommerce.catalog.application.image.service.IImageService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/images")
@Slf4j
public class ImageController {
  private final IImageService imageService;

  public ImageController(IImageService imageService) {
    this.imageService = imageService;
  }

  @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public ImageDetailsDto uploadImage(@ModelAttribute CreateImageDto imageDto) {
    return imageService.uploadImage(imageDto);
  }

  @GetMapping("/all")
  public List<ImageDetailsDto> findAllImages() {
    return imageService.findAllImages();
  }

  @GetMapping("/{id}")
  public ImageDetailsDto findImageById(String id) throws IOException {
    return imageService.findImageById(id);
  }

}
