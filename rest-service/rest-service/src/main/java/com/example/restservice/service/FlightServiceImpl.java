package com.example.restservice.service;

import com.example.restservice.entity.Flight;
import com.example.restservice.jpa.FlightRepository;
import com.example.restservice.viewmodel.FlightForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.logging.Logger;

@Service("flightService")
public class FlightServiceImpl implements FlightService{
    static Logger logger = Logger.getLogger(FlightServiceImpl.class.getName());

    @Autowired
    private FlightRepository flightRepository;

    public Flight save(Flight flight){
        return flightRepository.save(flight);
    }

    @Override
    public Flight delete(Flight flight) {
        flightRepository.delete(flight);
        return flight;
    }

    @Override
    public Collection<Flight> filtering(Flight flight) {

        return null;
    }

    public Collection<Flight> findAll(){
        return flightRepository.findAll();
    }

    @Override
    public Flight create(Flight flight) {
        return null;
    }

    @Override
    public Flight create(FlightForm flightForm) {
        return null;
    }


}
