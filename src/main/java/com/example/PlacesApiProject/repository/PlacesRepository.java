package com.example.PlacesApiProject.repository;

import com.example.PlacesApiProject.model.Places;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PlacesRepository extends JpaRepository<Places, Long> {
    Places getByUrl(String url);
}
