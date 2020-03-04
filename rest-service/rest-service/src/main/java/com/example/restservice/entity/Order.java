/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restservice.entity;

import com.example.restservice.viewmodel.Customer;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;

/**
 * @author FB-001
 */
@Entity
@Table(name = "orderinf")
public class Order {
    private String id;//order's id
    private Date orderTime;//time created of order, maybe at last modified before order being processed
    private boolean returntrip;//return trip or not (one-way trip)
    private String contactName;
    private BigDecimal contactPhoneNum;
    private String contactEmail;
    private String contactAddress;
    private Flight goFlight;
    private Flight returnFlight;
    private int adultNum;//num of >11 years old
    private int childrenNum;//num of children 2-11 years old
    private int infantNum;//num of infants <2 years old
    private String customersInfos;//json string stores list of all customers's names & age ranks
//    private Collection<Customer> customers;//

    public Order() {

    }

    @Id
    @Column(name = "id", nullable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //todo set nullable = false
    @Basic
    @Column(name = "order_time", nullable = true)
    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    //todo set nullable = false
    @Basic
    @Column(name = "return_trip", nullable = true)
    public boolean isReturntrip() {
        return returntrip;
    }

    public void setReturntrip(boolean returntrip) {
        this.returntrip = returntrip;
    }

    //todo set nullable = false
    @Basic
    @Column(name = "contact_name", nullable = true)
    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    //todo set nullable = false
    @Basic
    @Column(name = "contact_phone_num", nullable = true)
    public BigDecimal getContactPhoneNum() {
        return contactPhoneNum;
    }

    public void setContactPhoneNum(BigDecimal contactPhoneNum) {
        this.contactPhoneNum = contactPhoneNum;
    }

    //todo set nullable = false
    @Basic
    @Column(name = "contact_email", nullable = true)
    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    //todo set nullable = false
    @Basic
    @Column(name = "contact_address", nullable = true)
    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    //todo set nullable = false
    @Basic
    @Column(name = "adult_num", nullable = true)
    public int getAdultNum() {
        return adultNum;
    }

    public void setAdultNum(int adultNum) {
        this.adultNum = adultNum;
    }

    //todo set nullable = false
    @Basic
    @Column(name = "children_num", nullable = true)
    public int getChildrenNum() {
        return childrenNum;
    }

    public void setChildrenNum(int childrenNum) {
        this.childrenNum = childrenNum;
    }

    //todo set nullable = false
    @Basic
    @Column(name = "infant_num", nullable = true)
    public int getInfantNum() {
        return infantNum;
    }

    public void setInfantNum(int infantNum) {
        this.infantNum = infantNum;
    }

    //todo set nullable = false
    @Basic
    @Column(name = "customers_infos", nullable = true)
    public String getCustomersInfos() {
        return customersInfos;
    }

    public void setCustomersInfos(String customersInfos) {
        this.customersInfos = customersInfos;
    }

    //    todo set nullable = false
    @ManyToOne
    @JoinColumn(name = "go_flight_id", referencedColumnName = "id", nullable = true)
    public Flight getGoFlight() {
        return goFlight;
    }

    public void setGoFlight(Flight goFlight) {
        this.goFlight = goFlight;
    }

    //    todo set nullable = false
    @ManyToOne
    @JoinColumn(name = "return_flight_id", referencedColumnName = "id", nullable = true)
    public Flight getReturnFlight() {
        return returnFlight;
    }

    public void setReturnFlight(Flight returnFlight) {
        this.returnFlight = returnFlight;
    }


}
