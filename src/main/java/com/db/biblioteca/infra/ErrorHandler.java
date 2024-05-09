package com.db.biblioteca.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handlerErrorIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handlerErrorNoSuchElementException(NoSuchElementException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
