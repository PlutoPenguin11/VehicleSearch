package com.example.vehiclesearch.model;

public class Vehicle {
    private final String make;
    private final String model;
    private final int year;

    public Vehicle(String make, String model, int year){
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getMake() {return make;}
    public String getModel() {return model;}
    public String getYear() {return year;}



}
