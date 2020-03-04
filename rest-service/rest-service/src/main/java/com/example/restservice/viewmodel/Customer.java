package com.example.restservice.viewmodel;

public class Customer {
    private int ageRank;
    private String name;

    public int getAgeRank() {
        return ageRank;
    }

    public void setAgeRank(int ageRank) {
        this.ageRank = ageRank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer(int ageRank, String name) {
        this.ageRank = ageRank;
        this.name = name;
    }
}
