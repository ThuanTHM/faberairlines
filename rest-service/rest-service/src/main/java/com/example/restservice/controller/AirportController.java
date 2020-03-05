package com.example.restservice.controller;

import com.example.restservice.entity.Airport;
import com.example.restservice.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path="/airport")
public class AirportController {
    @Autowired
    private AirportService airportService;

    @GetMapping(path="/all")
    public ModelAndView getAll(){
        return getAllAirport();
    }

    @PostMapping(path = "/all") // Map ONLY POST Requests
    public ModelAndView addNewUser(@ModelAttribute Airport airportDetail) {

        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        airportService.save(airportDetail);
        return getAllAirport();
    }

    public ModelAndView getAllAirport(){
        ModelAndView model = new ModelAndView("airports");
        model.addObject("airports", airportService.findAll());
        model.addObject("airportDetail", new Airport());
        return model;
    }
}
