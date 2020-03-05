package com.example.restservice.service;

import com.example.restservice.entity.Airport;
import com.example.restservice.jpa.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.logging.Logger;

@Service("airportService")
public class AirportServiceImpl implements AirportService{
    static Logger logger = Logger.getLogger(AirportServiceImpl.class.getName());

    @Autowired
    private AirportRepository airportRepository;

    public Airport save(Airport airport){
        return airportRepository.save(airport);
    }

    @Override
    public Airport delete(Airport airport) {
        return null;
    }

    @Override
    public Collection<Airport> filtering(Airport airport) {
        return null;
    }

    public Collection<Airport> findAll(){
        return airportRepository.findAll();
    }

    @Override
    public Airport create(Airport airport) {
        return null;
    }

    public Airport findByName(String name){
        return airportRepository.findByName(name);
    }

}
