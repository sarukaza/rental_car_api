package com.example.rentalcarapi.service;

import com.example.rentalcarapi.dto.Car;
import com.example.rentalcarapi.exception.CarArgumentNotValidException;
import com.example.rentalcarapi.exception.CarNotFoundException;
import com.example.rentalcarapi.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Car saveCar(Car car) {
        if (car.getId() != null) {
            throw new CarArgumentNotValidException("新しい車を保存する際にはIDを指定しないでください。");
        }

        validateCarFields(car);

        carRepository.insertCar(car);
        return car;
    }

    public Car findById(Long id) {
        Car car = carRepository.findById(id);

        if (car == null) {
            throw new CarNotFoundException(id);
        }

        return car;
    }

    public boolean delete(Long id) {
        if (!carRepository.delete(id)) {
            throw new CarNotFoundException(id);
        }

        return true;
    }

    public Car updateCar(Car car, Long id) {
        if (id == null) {
            throw new CarArgumentNotValidException("車の更新にはIDが必要です。");
        }

        validateCarFields(car);

        car.setId(id);

        return carRepository.updateCar(car);
    }

    private void validateCarFields(Car car) {
        if (car == null || car.getCarName() == null || car.getCarName().isBlank() || car.getMaker() == null || car.getMaker().isBlank() || car.getNumberPlate() == null || car.getNumberPlate().isBlank() || car.getDailyPrice() == null || car.getCapacity() == null
                || car.getStatus() == null || car.getStatus().isBlank()) {
            throw new CarArgumentNotValidException("車の情報が不完全です。すべてのフィールドを入力してください。");
        }
    }
}