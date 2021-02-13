package com.avinty.hr.service;

import com.avinty.hr.model.Colour;

import java.util.List;

public interface ColourService {
    List<Colour> getAllColours();

    Colour createColour(Colour colour);

    void deleteColourById(Long id);

    Colour updateColour(Colour colour);
}
