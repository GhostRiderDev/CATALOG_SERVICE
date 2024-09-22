package com.ecommerce.catalog.application.image.dto;

import java.io.Serializable;
import org.hibernate.validator.constraints.URL;
import org.springframework.web.multipart.MultipartFile;
import com.ecommerce.catalog.domain.model.image.enumerate.ExtensionEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateImageDto implements Serializable {

  @NotBlank
  @URL
  private String name;

  @NotNull
  private MultipartFile file;

  @NotBlank
  @Size(min = 3, max = 100)
  private String alt;

  @NotBlank
  @Size(min = 3, max = 6, message = " minimo 3 maximo 6")
  private String extension;
}
