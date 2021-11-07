package com.example.geoApiTest.model;

public class AdressAnsver {
    String lon;
    String lat;

    public AdressAnsver() {
    }

    public AdressAnsver(String lon, String lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public String getLat() {
        return lat;
    }
}
