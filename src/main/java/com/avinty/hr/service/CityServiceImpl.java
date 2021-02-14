package com.avinty.hr.service;

import com.avinty.hr.model.City;
import com.avinty.hr.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    @Transactional
    public City createCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public void deleteCityById(Long id) {
        boolean exists = cityRepository.findById(id).isPresent();

        if (!exists) {
            throw new ResourceNotFoundException("NULL " + id.toString());
        }

        cityRepository.deleteById(id);
    }

    @Override
    @Transactional
    public City updateCity(City city) {
        if(city.getId() == null || !cityRepository.existsById(city.getId())) {
            throw new ResourceNotFoundException(city.getId() == null ? "NULL" : city.getId().toString());
        }

        return cityRepository.save(city);
    }
}
