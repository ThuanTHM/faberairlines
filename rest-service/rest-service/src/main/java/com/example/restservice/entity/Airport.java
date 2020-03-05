/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restservice.entity;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Collection;

/**
 *
 * @author FB-001
 */
@Entity
@Table(name = "airport", schema = "dbexample")
public class Airport {
    private String id;
    private String name;
    private Collection<Flight> departureFlights;
    private Collection<Flight> arrivalFlights;


    public Airport() {
    }

    public Airport(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @Column(name = "id", nullable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "departureAirport")
    public Collection<Flight> getDepartureFlights() {
        return departureFlights;
    }

    public void setDepartureFlights(Collection<Flight> departureFlights) {
        this.departureFlights = departureFlights;
    }

    @OneToMany(mappedBy = "arrivalAirport")
    public Collection<Flight> getArrivalFlights() {
        return arrivalFlights;
    }

    public void setArrivalFlights(Collection<Flight> arrivalFlights) {
        this.arrivalFlights = arrivalFlights;
    }
}
