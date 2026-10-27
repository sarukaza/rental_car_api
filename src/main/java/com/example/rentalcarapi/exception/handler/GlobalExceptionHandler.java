package com.example.rentalcarapi.exception.handler;

import com.example.rentalcarapi.exception.CarArgumentNotValidException;
import com.example.rentalcarapi.exception.CarNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CarNotFoundException.class)
    public ResponseEntity<String> handleCarNotFoundException(CarNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(CarArgumentNotValidException.class)
    public ResponseEntity<String> handleCarArgumentNotValidException(CarArgumentNotValidException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}