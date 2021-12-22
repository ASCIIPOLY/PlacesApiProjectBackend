package com.example.PlacesApiProject.converter;

import com.example.PlacesApiProject.model.Places;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;

@Component
public class PlacesConverter {

    public Places jsonToPlaces(JsonNode json, String url) throws JsonProcessingException {
        Places places = new Places();
        places.setHtml_attributions(json.findValue("html_attributions").toString());
        places.setResults(json.findValue("results").toString());
        places.setStatus(json.findValue("status").toString());
        places.setUrl(url);
        return places;
    }

}
