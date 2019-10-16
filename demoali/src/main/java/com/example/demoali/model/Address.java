package com.example.demoali.model;

public class Address {


    private String state;
    private String county;
    private String city;

    public Address() {
    }

    public Address(String state, String county, String city) {
        this.state = state;
        this.county = county;
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "state='" + state + '\'' +
                ", county='" + county + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

