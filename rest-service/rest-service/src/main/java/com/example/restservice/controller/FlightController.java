package com.example.restservice.controller;

import com.example.restservice.entity.Flight;
import com.example.restservice.jpa.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "flight")
public class FlightController {
    @Autowired
    private FlightRepository flightRepository;

}
