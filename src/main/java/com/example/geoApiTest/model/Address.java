package com.example.geoApiTest.model;

public class Address {
    String amenity;
    String house_number;
    String highway;
    String road;
    String city;
    String state_district;
    String state;
    String postcode;
    String country;
    String country_code;

    public Address() {
    }

    public Address(String amenity, String house_number, String highway, String road, String city, String state_district, String state, String postcode, String country, String country_code) {
        this.amenity = amenity;
        this.house_number = house_number;
        this.highway = highway;
        this.road = road;
        this.city = city;
        this.state_district = state_district;
        this.state = state;
        this.postcode = postcode;
        this.country = country;
        this.country_code = country_code;
    }

    public String getAmenity() {
        return amenity;
    }

    public void setAmenity(String amenity) {
        this.amenity = amenity;
    }

    public String getHouse_number() {
        return house_number;
    }

    public void setHouse_number(String house_number) {
        this.house_number = house_number;
    }

    public String getHighway() {
        return highway;
    }

    public void setHighway(String highway) {
        this.highway = highway;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState_district() {
        return state_district;
    }

    public void setState_district(String state_district) {
        this.state_district = state_district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }
}
