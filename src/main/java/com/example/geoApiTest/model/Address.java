package com.example.geoApiTest.model;

import javax.persistence.*;

@Entity
@Table(name="Address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    String lon;
    String lat;
    String addressData;

    int frequency;

    public Address() {
    }

    public Address(String lon, String lat, String addressData, int frequency) {
        this.lon = lon;
        this.lat = lat;
        this.addressData = addressData;
        this.frequency = frequency;
    }

    public int getId() {
        return id;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getAddress() {
        return addressData;
    }

    public void setAddress(String adress) {
        this.addressData = adress;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
