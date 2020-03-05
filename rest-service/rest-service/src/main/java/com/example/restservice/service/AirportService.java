package com.example.restservice.service;

import com.example.restservice.entity.Airport;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface AirportService {
    Collection<Airport> findAll();
    Airport create(Airport airport);
    Airport save(Airport airport);
    Airport delete(Airport airport);
    Collection<Airport> filtering(Airport airport);
}
