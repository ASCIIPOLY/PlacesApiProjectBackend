package com.example.PlacesApiProject.controller;

import com.example.PlacesApiProject.model.Places;
import com.example.PlacesApiProject.service.PlacesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins = "http://localhost:3000/")
@Controller
@RequestMapping("/")
public class PlacesController {

    private final PlacesService placesService;

    public PlacesController(PlacesService placesService) {
        this.placesService = placesService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Places> getAll(@RequestParam double longitude, @RequestParam double latitude,
                                         @RequestParam int radius) throws JsonProcessingException {

        return new ResponseEntity<>(placesService.getPlaces(longitude, latitude, radius), HttpStatus.OK);
    }
}
