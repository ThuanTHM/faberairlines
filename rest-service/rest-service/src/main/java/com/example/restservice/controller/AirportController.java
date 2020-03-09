package com.example.restservice.controller;

import com.example.restservice.entity.Airport;
import com.example.restservice.exception.RecordNotFoundException;
import com.example.restservice.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@ControllerAdvice
@Controller
@RequestMapping(path="/airport")
public class AirportController {
    @Autowired
    private AirportService airportService;

    @RequestMapping(path="/manage")
    public ModelAndView getAll(HttpServletRequest request){
        int page = 0; //default page number is 0 
        int size = 3; //default page size is 10

        if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
            page = Integer.parseInt(request.getParameter("page")) - 1;
        }

        if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
            size = Integer.parseInt(request.getParameter("size"));
        }

        ModelAndView model = new ModelAndView("airport_manage");
        model.addObject("airports", airportService.findAll(PageRequest.of(page, size)));
        return model;
    }

    @RequestMapping(path= {"/manage/edit", "/manage/edit/{id}"})
    public String edit(Model model, @PathVariable("id") Optional<Long> id) throws RecordNotFoundException {
        if (id.isPresent()) {
            Airport airport = airportService.findById(id.get());
            model.addAttribute("airportDetail", airport);
        } else {
            model.addAttribute("airportDetail", new Airport());
        }
        return "airport_modify";
    }
    @RequestMapping(path= {"/manage/delete/{id}"})
    public String delete(Model model, @PathVariable("id") Long id) throws RecordNotFoundException {
        airportService.delete(id);
        return "redirect:/airport/manage";
    }

    @RequestMapping(path = "/manage/create", method = RequestMethod.POST) // Map ONLY POST Requests
    public String addNewUser(@ModelAttribute Airport airportDetail) {
        
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        airportService.createOrUpdate(airportDetail);
        return "redirect:/airport/manage";
    }
}
