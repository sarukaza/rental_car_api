package com.example.rentalcarapi.controller;

import com.example.rentalcarapi.dto.Car;
import com.example.rentalcarapi.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<List<Car>> findAllCars() {
        List<Car> cars = carService.findAll();
//        return new ResponseEntity<>(cars, HttpStatus.OK);
        return ResponseEntity.ok(cars);
    }

    @PostMapping
    public ResponseEntity<Car> saveCar(
            @RequestBody Car car,
            UriComponentsBuilder uriBuilder
    ) {
        Car createdCar = carService.saveCar(car);

        URI location = uriBuilder
                .path("/api/cars/{id}")
                .buildAndExpand(createdCar.getId())
                .toUri();

//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(location);
//
//        return new ResponseEntity<>(createdCar, headers, HttpStatus.CREATED);

        return ResponseEntity.created(location).body(createdCar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> findCarById(@PathVariable Long id) {
        Car car = carService.findById(id);

        return ResponseEntity.ok(car);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        carService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> update(@PathVariable Long id, @RequestBody Car car) {
        Car updatedCar = carService.updateCar(car, id);
        return ResponseEntity.ok(updatedCar);
    }
}