package com.avinty.hr.service;

import com.avinty.hr.model.Car;

import java.util.List;

public interface CarService {
    Car getCarById(Long id);

    List<Car> findCarsByLicencePlate(String licensp);

    List<Car> getAllCars();

    Car createCar(Car newCar);

    void deleteCarById(Long id);

    Car updateCarById(Long id, Car updatedCar);
}
