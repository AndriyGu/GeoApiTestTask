package com.example.geoApiTest.model;

import com.example.geoApiTest.model.Address;

public class AddressData {
    String place_id;

    String lat;
    String lon;
    Address address;

    public AddressData() {
    }

    public AddressData(String place_id, String lat, String lon, Address address) {
        this.place_id = place_id;
        this.lat = lat;
        this.lon = lon;
        this.address = address;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
