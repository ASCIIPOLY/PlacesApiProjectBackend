package com.example.PlacesApiProject.service;

import com.example.PlacesApiProject.model.Places;
import com.fasterxml.jackson.core.JsonProcessingException;


public interface PlacesService {
    Places getPlaces(double longitude, double latitude, int radius) throws JsonProcessingException;
}
