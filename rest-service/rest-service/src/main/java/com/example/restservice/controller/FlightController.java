package com.example.restservice.controller;

import com.example.restservice.entity.Airport;
import com.example.restservice.entity.Flight;
import com.example.restservice.entity.Order;
import com.example.restservice.jpa.FlightRepository;
import com.example.restservice.service.AirportService;
import com.example.restservice.service.AirportServiceImpl;
import com.example.restservice.service.FlightService;
import com.example.restservice.viewmodel.FlightForm;
import com.example.restservice.viewmodel.OrderForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping(path = {"flight","/"})
public class FlightController {
    @Autowired
    private FlightService flightService;
    @Autowired
    private AirportService airportService;

    @GetMapping(path="/manage")
    public ModelAndView getAll(){
        List<Airport> airports = (List<Airport>) airportService.findAll();
//        Timestamp t = new Timestamp(System.currentTimeMillis());
//        for(int i=0;i<100;i++){
//            int rand = (int)(Math.random() * airports.size()) + 1;
//            flightService.create(new Flight(
//                    new Timestamp(t.int)(Math.random() * airports.size()))
//            ));
//        }
        ModelAndView model = new ModelAndView("flight_manage");
        model.addObject("flights", flightService.findAll());
        model.addObject("flightForm", new FlightForm());
        return model;
    }

    @GetMapping(path="/booking/search")
    public ModelAndView search(){
//        Timestamp t = new Timestamp(System.currentTimeMillis());
//        for(int i=0;i<100;i++){
//            int rand = (int)(Math.random() * airports.size()) + 1;
//            flightService.create(new Flight(
//                    new Timestamp(t.int)(Math.random() * airports.size()))
//            ));
//        }
        return searchFlightPage();
    }

    @PostMapping(path = "/booking/select-flights") // Map ONLY POST Requests
    public ModelAndView search(@ModelAttribute OrderForm orderForm) {

        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        ModelAndView model = new ModelAndView("flight_select");
        return model;
    }

    @PostMapping(path = "/manage/create") // Map ONLY POST Requests
    public ModelAndView create(@ModelAttribute FlightForm flightFormForm) {

        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        ModelAndView model = new ModelAndView("flight_manage");
        return model;
    }

    public ModelAndView searchFlightPage(){
        ModelAndView model = new ModelAndView("flight_search");
        model.addObject("airports", airportService.findAll());
        model.addObject("orderForm", new OrderForm());
        return model;
    }

}
