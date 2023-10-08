package com.airy.ecom.productservice.exception;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException() {
    }
}
