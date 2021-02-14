package com.avinty.hr.service;

import com.avinty.hr.model.Car;
import com.avinty.hr.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Override
    public Car getCarById(Long id) {
        boolean exits = carRepository.findById(id).isPresent();

        if (!exits) {
            throw new ResourceNotFoundException("NULL " + id.toString());
        }

        return carRepository.findById(id).get();
    }

    @Override
    public List<Car> findCarsByLicencePlate(String licensp) {
        return carRepository.findCarsByLicencePlate(licensp);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAllCars();
    }

    @Override
    @Transactional
    public Car createCar(Car newCar) {
        return carRepository.save(newCar);
    }

    @Override
    public void deleteCarById(Long id) {
        boolean exits = carRepository.findById(id).isPresent();

        if (!exits) {
            throw new ResourceNotFoundException("NULL " + id.toString());
        }

        carRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Car updateCarById(Long id, Car updatedCar) {
        boolean exits = carRepository.findById(id).isPresent();

        if (!exits) {
            throw new ResourceNotFoundException("NULL " + id.toString());
        }

        updatedCar.setId(id); // I know the request body contains the id, but the path variable id would be unused

        return carRepository.save(updatedCar);
    }
}
