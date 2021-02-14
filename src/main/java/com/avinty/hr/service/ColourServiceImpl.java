package com.avinty.hr.service;

import com.avinty.hr.model.Colour;
import com.avinty.hr.payload.NameRequest;
import com.avinty.hr.repository.ColourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ColourServiceImpl implements ColourService {

    private final ColourRepository colourRepository;

    @Override
    public List<Colour> getAllColours() {
        return colourRepository.findAll();
    }


    @Override
    @Transactional
    public Colour createColour(NameRequest request) {
        Colour colour = new Colour(request.getName());

        return colourRepository.save(colour);
    }

    @Override
    public void deleteColourById(Long id) {
        colourRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("NULL " + id.toString()));

        colourRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Colour updateColour(Colour colour) {
        if(colour.getId() == null || !colourRepository.existsById(colour.getId())) {
            throw new ResourceNotFoundException(colour.getId() == null ? "NULL" : colour.getId().toString());
        }

        return colourRepository.save(colour);
    }
}
