package com.example.rentalcarapi.exception;

public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException(Long id) {
        super("指定されたIDの車が見つかりません： " + id);
    }
}