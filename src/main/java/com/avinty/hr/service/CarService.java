package com.avinty.hr.service;

import com.avinty.hr.model.Car;
import com.avinty.hr.payload.CarRequest;

import java.util.List;

public interface CarService {
    Car getCarById(Long id);

    List<Car> findCarsByLicencePlate(String licensp);

    List<Car> getAllCars();

    Car createCar(CarRequest request);

    void deleteCarById(Long id);

    Car updateCarById(Long id, CarRequest request);
}
