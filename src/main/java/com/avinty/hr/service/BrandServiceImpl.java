package com.avinty.hr.service;

import com.avinty.hr.model.Brand;
import com.avinty.hr.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @Transactional
    @Override
    public Brand createBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public void deleteBrandById(Long id) {
        boolean exists = brandRepository.findById(id).isPresent();

        if (!exists) {
            throw new ResourceNotFoundException("NULL " + id.toString());
        }

        brandRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Brand updateBrand(Brand brand) {
        if(brand.getId() == null || !brandRepository.existsById(brand.getId())) {
            throw new ResourceNotFoundException(brand.getId() == null ? "NULL" : brand.getId().toString());
        }

        return brandRepository.save(brand);
    }

}
