package com.avinty.hr.service;

import com.avinty.hr.model.Car;
import com.avinty.hr.payload.CarRequest;
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
        return carRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("NULL " + id.toString()) );
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
    public Car createCar(CarRequest request) {
        Car car = new Car(request.getLicencePlate(),
                request.getBrand(),
                request.getColour(),
                request.getCategory());

        return carRepository.save(car);
    }

    @Override
    public void deleteCarById(Long id) {
        carRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("NULL " + id.toString()));

        carRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Car updateCarById(Long id, Car updatedCar) {
        carRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("NULL " + id.toString()));

        return carRepository.save(updatedCar);
    }
}
