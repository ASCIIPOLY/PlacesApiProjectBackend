package com.example.PlacesApiProject.service;

import com.example.PlacesApiProject.converter.PlacesConverter;
import com.example.PlacesApiProject.model.Places;
import com.example.PlacesApiProject.repository.PlacesRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;

@Service
@Transactional
public class PlacesServiceImpl implements PlacesService {

    private final PlacesConverter placesConverter;
    private final PlacesRepository placesRepository;
    private RestTemplate restTemplate;

    public PlacesServiceImpl(PlacesConverter placesConverter, PlacesRepository placesRepository, RestTemplate restTemplate) {
        this.placesConverter = placesConverter;
        this.placesRepository = placesRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public Places getPlaces(double longitude, double latitude, int radius) throws JsonProcessingException {
        String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + latitude + ","
                + longitude + "&radius=" + radius + "&key=<API_KEY>" ;
        String urlForService = "http://localhost:8070/?longitude=" + longitude + "&latitude="
                + latitude + "&radius=" + radius;
        Places placesFromDb = placesRepository.getByUrl(urlForService);
        if(placesFromDb == null) {
            JsonNode json = restTemplate.getForObject(url, JsonNode.class);
            Places places = placesConverter.jsonToPlaces(json, urlForService);
            placesRepository.save(places);
            return places;
        } else {
            return  placesFromDb;
        }
    }
}
