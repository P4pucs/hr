package com.avinty.hr.controller;

import com.avinty.hr.model.City;
import com.avinty.hr.payload.NameRequest;
import com.avinty.hr.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "cities")
public class CityController {

    private final CityService cityService;

    @GetMapping()
    public ResponseEntity<List<City>> getAllCities() {
        return ResponseEntity.status(HttpStatus.OK).body(cityService.getAllCities());
    }

    @PostMapping
    public ResponseEntity<City> createCity(@RequestBody NameRequest city) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cityService.createCity(city));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> deleteCityById(@PathVariable Long id) {
        cityService.deleteCityById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping()
    public ResponseEntity<City> updateCity(@RequestBody City city) {
        return ResponseEntity.status(HttpStatus.OK).body(cityService.updateCity(city));
    }
}
