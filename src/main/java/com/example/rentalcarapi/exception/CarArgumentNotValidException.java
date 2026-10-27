package com.example.rentalcarapi.exception;

public class CarArgumentNotValidException extends RuntimeException {
    public CarArgumentNotValidException(String message) {
        super(message);
    }
}