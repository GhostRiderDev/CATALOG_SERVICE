package com.ecommerce.catalog.application.category.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import com.amazonaws.services.kms.model.NotFoundException;
import com.ecommerce.catalog.application.category.dto.CategoryDetailsDto;
import com.ecommerce.catalog.application.category.dto.CreateCategoryDto;
import com.ecommerce.catalog.application.category.mapper.IMapperModelDtoCategory;
import com.ecommerce.catalog.application.image.dto.ImageDetailsDto;
import com.ecommerce.catalog.application.image.service.IImageService;
import com.ecommerce.catalog.application.image.service.ImageService;
import com.ecommerce.catalog.domain.model.category.Category;
import com.ecommerce.catalog.domain.model.category.port.out.ICategoryRepository;
import com.ecommerce.catalog.domain.model.image.Image;

@Service
public class CategoryService implements ICategoryService {

  private final ICategoryRepository categoryRepository;
  private final IImageService imageService;
  private final IMapperModelDtoCategory mapper;

  public CategoryService(ICategoryRepository categoryRepository, ImageService imageService,
      IMapperModelDtoCategory mapper) {
    this.categoryRepository = categoryRepository;
    this.imageService = imageService;
    this.mapper = mapper;
  }

  @Override
  public CategoryDetailsDto saveCategory(CreateCategoryDto createCategoryDto) throws IOException {
    imageService.imageExists(createCategoryDto.getImageId());
    Image image = imageService.findImgByIdInternal(createCategoryDto.getImageId());
    Category category = mapper.toModel(createCategoryDto, image);
    category.setCreatedAt(LocalDateTime.now());
    category.setUpdatedAt(LocalDateTime.now());
    Category savedCategory = categoryRepository.save(category);
    ImageDetailsDto imageDto = imageService.findImageById(createCategoryDto.getImageId());
    return mapper.toDto(savedCategory, imageDto);
  }

  @Override
  public List<CategoryDetailsDto> findAllProducts() {
    List<Category> categories = categoryRepository.findAll();
    return categories.stream().map(category -> this.findProductById(category.getId())).toList();
  }

  @Override
  public CategoryDetailsDto findProductById(String id) {
    Category category = categoryRepository.findById(id);
    if (category == null) {
      throw new NotFoundException("Category not found");
    }

    ImageDetailsDto imageDto = null;

    try {
      imageDto = imageService.findImageById(category.getImage().getId());
    } catch (IOException e) {
      e.printStackTrace();
    }

    return mapper.toDto(category, imageDto);
  }



}
