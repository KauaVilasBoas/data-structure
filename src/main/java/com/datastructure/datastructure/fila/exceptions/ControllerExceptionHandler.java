package com.datastructure.datastructure.fila.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "package com.datastructure.datastructure.fila.controllers")
public class ControllerExceptionHandler {
    
    @ExceptionHandler(value = {FullSizeException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> FullSizeException() {
      return ResponseEntity.badRequest().body("Fila Cheia");
    }

    @ExceptionHandler(value = {EmptyQueueException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> EmptyQueueException() {
      return ResponseEntity.badRequest().body("Fila Vazia");
    }

    @ExceptionHandler(value = {NullPointerException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> NullPointerException() {
      return ResponseEntity.badRequest().body("Fila Vazia");
    }
}
