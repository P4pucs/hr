package com.avinty.hr.controller;

import com.avinty.hr.model.Car;
import com.avinty.hr.payload.CarRequest;
import com.avinty.hr.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping(path = "cars")
public class CarController {

    private final CarService carService;

    @GetMapping(path = "{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(carService.getCarById(id));
    }

    @GetMapping
    public ResponseEntity<List<Car>> getCars(@RequestParam(value = "licensp", required = false) String licensp) {
        if (licensp != null) {
            return ResponseEntity.status(HttpStatus.OK).body(carService.findCarsByLicencePlate(licensp));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(carService.getAllCars());
        }
    }

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody CarRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(carService.createCar(request));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> deleteCarById(@PathVariable Long id) {
        carService.deleteCarById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Car> updateCarById(@PathVariable Long id, @RequestBody CarRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(carService.updateCarById(id, request));
    }
}
