package com.datastructure.datastructure.pilha.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.datastructure.datastructure.pilha.controllers")
public class PilhaControllerExceptionHandler {
    
    @ExceptionHandler(value = {FullStackException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> FullStackException() {
      return ResponseEntity.badRequest().body("Pilha Cheia");
    }

    @ExceptionHandler(value = {EmptyStackException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> EmptyStackException() {
      return ResponseEntity.badRequest().body("Pilha Vazia");
    }

    @ExceptionHandler(value = {NullPointerException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> NullPointerException() {
      return ResponseEntity.badRequest().body("Pilha Vazia");
    }
}
