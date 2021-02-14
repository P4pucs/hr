package com.avinty.hr.controller;

import com.avinty.hr.model.Colour;
import com.avinty.hr.payload.NameRequest;
import com.avinty.hr.service.ColourService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "colours")
public class ColourController {

    private final ColourService colourService;

    @GetMapping()
    public ResponseEntity<List<Colour>> getAllColours() {
        return ResponseEntity.status(HttpStatus.OK).body(colourService.getAllColours());
    }

    @PostMapping
    public ResponseEntity<Colour> createColour(@RequestBody NameRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(colourService.createColour(request));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> deleteColourById(@PathVariable Long id) {
        colourService.deleteColourById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Colour> updateColour(@PathVariable Long id, @RequestBody NameRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(colourService.updateColour(id, request));
    }
}
