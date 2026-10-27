package com.example.rentalcarapi.repository;

import com.example.rentalcarapi.dto.Car;
import com.example.rentalcarapi.exception.CarNotFoundException;
import com.example.rentalcarapi.mapper.CarMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepository {
    private final CarMapper carMapper;

    public CarRepository(CarMapper carMapper) {
        this.carMapper = carMapper;
    }

    public List<Car> findAll() {
        return carMapper.findAll();
    }

    public int insertCar(Car car) {
        return carMapper.insert(car);
    }

    public Car findById(Long id) {
        return carMapper.findById(id);
    }

    public boolean delete(Long id) {
        return carMapper.delete(id) == 1;
    }

    public Car updateCar(Car car) {
        if (carMapper.update(car) == 0) {
            throw new CarNotFoundException(car.getId());
        }
        return car;
    }
}