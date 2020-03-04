package com.example.restservice.service;

import com.example.restservice.jpa.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service("airportService")
public class AirportServiceImpl {
    static Logger logger = Logger.getLogger(AirportServiceImpl.class.getName());

    @Autowired
    private AirportRepository airportRepository;


}
