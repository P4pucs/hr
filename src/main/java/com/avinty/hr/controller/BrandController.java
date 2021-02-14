package com.avinty.hr.controller;

import com.avinty.hr.model.Brand;
import com.avinty.hr.payload.NameRequest;
import com.avinty.hr.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "brands")
public class BrandController {

    private final BrandService brandService;

    @GetMapping()
    public ResponseEntity<List<Brand>> getAllBrands() {
        return ResponseEntity.status(HttpStatus.OK).body(brandService.getAllBrands());
    }

    @PostMapping
    public ResponseEntity<Brand> createBrand(@RequestBody NameRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(brandService.createBrand(request));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> deleteBrandById(@PathVariable Long id) {
        brandService.deleteBrandById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping
    public ResponseEntity<Brand> updateBrand(@RequestBody Brand brand) {
        return ResponseEntity.status(HttpStatus.OK).body(brandService.updateBrand(brand));
    }

}
