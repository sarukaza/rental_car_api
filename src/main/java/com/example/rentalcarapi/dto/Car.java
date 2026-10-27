package com.example.rentalcarapi.dto;

import lombok.Data;

@Data
public class Car {
    private Long id;
    private String carName;
    private String maker;
    private String numberPlate;
    private Integer dailyPrice;
    private Integer capacity;
    private String status;
}