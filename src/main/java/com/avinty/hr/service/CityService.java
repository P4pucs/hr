package com.avinty.hr.service;

import com.avinty.hr.model.City;
import com.avinty.hr.payload.NameRequest;

import java.util.List;

public interface CityService {
    List<City> getAllCities();

    City createCity(NameRequest city);

    void deleteCityById(Long id);

    City updateCity(City city);
}
