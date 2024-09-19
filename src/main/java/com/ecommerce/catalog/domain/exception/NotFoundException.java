package com.ecommerce.catalog.domain.exception;

import com.ecommerce.catalog.domain.constant.Constant;

public class NotFoundException extends RuntimeException {

  public NotFoundException(String message) {
    super(message);
  }

  public NotFoundException() {
    super(Constant.RESOURCE_NOT_FOUND);
  }

}
