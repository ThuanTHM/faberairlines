package com.example.restservice.service;

import com.example.restservice.entity.Flight;

import java.util.Collection;

public interface FlightService {
    Collection<Flight> findAll();
    Flight create(Flight flight);
    Flight save(Flight flight);
    Flight delete(Flight flight);
    Collection<Flight> filtering(Flight flight);
}
