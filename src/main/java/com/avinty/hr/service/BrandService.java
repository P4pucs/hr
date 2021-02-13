package com.avinty.hr.service;

import com.avinty.hr.model.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> getAllBrands();

    Brand createBrand(Brand brand);

    void deleteBrandById(Long id);

    Brand updateBrand(Brand brand);
}
