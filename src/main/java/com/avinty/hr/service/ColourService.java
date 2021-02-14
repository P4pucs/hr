package com.avinty.hr.service;

import com.avinty.hr.model.Colour;
import com.avinty.hr.payload.NameRequest;

import java.util.List;

public interface ColourService {
    List<Colour> getAllColours();

    Colour createColour(NameRequest request);

    void deleteColourById(Long id);

    Colour updateColour(Long id, NameRequest request);
}
