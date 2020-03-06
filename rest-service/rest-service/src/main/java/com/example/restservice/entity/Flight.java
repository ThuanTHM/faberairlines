/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restservice.entity;

//import com.example.restservice.viewmodel.TargetView;
//import com.fasterxml.jackson.annotation.JsonView;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
import javax.persistence.*;

/**
 * @author FB-001
 */
@Entity
public class Flight {
    private static final long serialVersionUID = -297553281792804396L;

    private Long id;
//    @JsonView({TargetView.flightView.class, TargetView.orderView.class})
    private Timestamp departureTime;
//    @JsonView({TargetView.flightView.class, TargetView.orderView.class})
    private Timestamp arrivalTime;
//    @JsonView({TargetView.flightView.class, TargetView.orderView.class})
    private Airport departureAirport;
//    @JsonView({TargetView.flightView.class, TargetView.orderView.class})
    private Airport arrivalAirport;
    //total seat

    //todo dumming for missing business's feature
//    @JsonView({TargetView.flightView.class})
    private int totalSeat;//info of this field maybe moved into another entity storing Plane's info as soon as posible
//    @JsonView({TargetView.flightView.class})
    private BigDecimal adultSeatPrice;//temporarily input by user
//    @JsonView({TargetView.flightView.class})
    private BigDecimal childSeatPrice;//temporarily input by user
//    @JsonView({TargetView.flightView.class})
    private BigDecimal infantSeatPrice;//temporarily input by user

    //    price for 3 different age ranks depends on these infomations and based on algorithm which may be cover as soon as possibledeparture:
    // -NET seat price
    // -system & admin fee
    // -domestic passenger service charge depend on international/ national flight
    // -domestic itineries: (including VAT 10%) for adult depending on airport. Children from 2 to under 12 years pay 50% applicable adult rate. Infants under 2 years without seats are exempt.
    // (VAT: regularly by 10% of NET seat price + dps)

//    @JsonView({TargetView.flightView.class})
    private Collection<Order> goFlightOrders;
//    @JsonView({TargetView.flightView.class})
    private Collection<Order> returnFlightOrders;

    public Flight(Timestamp departureTime, Timestamp arrivalTime, Airport departureAirport, Airport arrivalAirport, int totalSeat, BigDecimal adultSeatPrice, BigDecimal childSeatPrice, BigDecimal infantSeatPrice, Collection<Order> goFlightOrders, Collection<Order> returnFlightOrders) {
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.totalSeat = totalSeat;
        this.adultSeatPrice = adultSeatPrice;
        this.childSeatPrice = childSeatPrice;
        this.infantSeatPrice = infantSeatPrice;
        this.goFlightOrders = goFlightOrders;
        this.returnFlightOrders = returnFlightOrders;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "departure_time", nullable = false)
    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    @Basic
    @Column(name = "arrival_time", nullable = false)
    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Basic
    @Column(name = "total_seat", nullable = false)
    public int getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(int totalSeat) {
        this.totalSeat = totalSeat;
    }

    @Basic
    @Column(name = "adult_seat_price", nullable = false)
    public BigDecimal getAdultSeatPrice() {
        return adultSeatPrice;
    }

    public void setAdultSeatPrice(BigDecimal adultSeatPrice) {
        this.adultSeatPrice = adultSeatPrice;
    }

    @Basic
    @Column(name = "child_seat_price", nullable = false)
    public BigDecimal getChildSeatPrice() {
        return childSeatPrice;
    }

    public void setChildSeatPrice(BigDecimal childSeatPrice) {
        this.childSeatPrice = childSeatPrice;
    }

    @Basic
    @Column(name = "infant_seat_price", nullable = false)
    public BigDecimal getInfantSeatPrice() {
        return infantSeatPrice;
    }

    public void setInfantSeatPrice(BigDecimal infantSeatPrice) {
        this.infantSeatPrice = infantSeatPrice;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departure_airport_id", referencedColumnName = "id", nullable = false)
    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "arrival_airport_id", referencedColumnName = "id", nullable = false)
    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    @OneToMany(mappedBy = "goFlight", fetch = FetchType.LAZY)
    public Collection<Order> getGoFlightOrders() {
        return goFlightOrders;
    }

    public void setGoFlightOrders(Collection<Order> goFlightOrders) {
        this.goFlightOrders = goFlightOrders;
    }

    @OneToMany(mappedBy = "returnFlight", fetch = FetchType.LAZY)
    public Collection<Order> getReturnFlightOrders() {
        return returnFlightOrders;
    }

    public void setReturnFlightOrders(Collection<Order> returnFlightOrders) {
        this.returnFlightOrders = returnFlightOrders;
    }
}
