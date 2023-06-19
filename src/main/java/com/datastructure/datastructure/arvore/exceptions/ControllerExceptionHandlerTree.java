package com.datastructure.datastructure.arvore.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.datastructure.datastructure.arvore.controllers")
public class ControllerExceptionHandlerTree {

    @ExceptionHandler(value = {ValueNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> ValueNotFoundException() {
      return ResponseEntity.notFound().build();
    }

}
