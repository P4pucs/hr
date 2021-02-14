package com.avinty.hr.service;

import com.avinty.hr.model.Brand;
import com.avinty.hr.payload.NameRequest;

import java.util.List;

public interface BrandService {
    List<Brand> getAllBrands();

    Brand createBrand(NameRequest request);

    void deleteBrandById(Long id);

    Brand updateBrand(Long id, NameRequest request);
}
