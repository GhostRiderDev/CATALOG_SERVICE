package com.ecommerce.catalog.domain.exception;

public class AlreadyExistException extends RuntimeException {
    public AlreadyExistException(String message) {
        super(message);
    }

    public AlreadyExistException() {
       super("Already exist"); 
    }
  
}
