package com.avinty.hr.service;

import com.avinty.hr.model.Brand;
import com.avinty.hr.payload.NameRequest;
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

    @Override
    @Transactional
    public Brand createBrand(NameRequest request) {
        Brand brand = new Brand(request.getName());

        return brandRepository.save(brand);
    }

    @Override
    public void deleteBrandById(Long id) {
        brandRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("NULL " + id.toString()));

        brandRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Brand updateBrand(Long id, NameRequest request) {
        return brandRepository.findById(id).map(brand -> {

            brand.setName(request.getName());

            return brandRepository.save(brand);
        }).orElseThrow( () -> new ResourceNotFoundException("NULL " + id.toString()));
    }

}
