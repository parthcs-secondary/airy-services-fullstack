package com.airy.ecom.productservice.controller;


import com.airy.ecom.productservice.exception.ProductNotFoundException;
import com.airy.ecom.productservice.model.dto.CustomErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
public class ProductsExceptionHandler {

    @ExceptionHandler(value = ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<CustomErrorResponse> notFoundException(ProductNotFoundException e) {
        CustomErrorResponse error = new CustomErrorResponse(HttpStatus.NOT_FOUND.toString(), e.getMessage());
        error.setStatus((HttpStatus.NOT_FOUND.value()));
        error.setTimestamp(LocalDateTime.now());
        ResponseEntity<CustomErrorResponse> responseEntity = new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        return responseEntity;
    }
}
