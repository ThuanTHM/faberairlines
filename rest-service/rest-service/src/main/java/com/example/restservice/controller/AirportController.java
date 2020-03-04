package com.example.restservice.controller;

import com.example.restservice.jpa.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/airport")
public class AirportController {
    @Autowired
    private AirportRepository airportRepository;

}
