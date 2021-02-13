package com.avinty.hr.service;

import com.avinty.hr.model.City;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CityService {
    List<City> getAllCities();

    City createCity(City city);

    void deleteCityById(Long id);

    City updateCity(City city);
}
