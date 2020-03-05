/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restservice.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;
import javax.persistence.*;

/**
 * @author FB-001
 */
@Entity
public class Flight {
    private String id;
    private Date departureTime;
    private Date arrivalTime;
    private Airport departureAirport;
    private Airport arrivalAirport;
    //total seat

    //todo dumming for missing business's feature
    private int totalSeat;//info of this field maybe moved into another entity storing Plane's info as soon as posible
    //    price for 3 different age ranks depends on these infomations and based on algorithm which may be cover soon as possible:
    // -NET seat price
    // -system & admin fee
    // -domestic passenger service charge depend on international/ national flight
    // -domestic itineries: (including VAT 10%) for adult depending on airport. Children from 2 to under 12 years pay 50% applicable adult rate. Infants under 2 years without seats are exempt.
    // (VAT: regularly by 10% of NET seat price + dps
    private BigDecimal adultSeatPrice;//temporarily input by user
    private BigDecimal childSeatPrice;//temporarily input by user
    private BigDecimal infantSeatPrice;//temporarily input by user

    private Collection<Order> goFlightOrders;
    private Collection<Order> returnFlightOrders;

    @Id
    @Column(name = "id", nullable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "departure_time", nullable = false)
    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    @Basic
    @Column(name = "arrival_time", nullable = false)
    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
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

    @ManyToOne
    @JoinColumn(name = "departure_airport_id", referencedColumnName = "id", nullable = false)
    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    @ManyToOne
    @JoinColumn(name = "arrival_airport_id", referencedColumnName = "id", nullable = false)
    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    @OneToMany(mappedBy = "goFlight")
    public Collection<Order> getGoFlightOrders() {
        return goFlightOrders;
    }

    public void setGoFlightOrders(Collection<Order> goFlightOrders) {
        this.goFlightOrders = goFlightOrders;
    }

    @OneToMany(mappedBy = "returnFlight")
    public Collection<Order> getReturnFlightOrders() {
        return returnFlightOrders;
    }

    public void setReturnFlightOrders(Collection<Order> returnFlightOrders) {
        this.returnFlightOrders = returnFlightOrders;
    }
}
