package com.example.geoApiTest.model;

import javax.persistence.*;
import java.util.StringJoiner;

@Entity
@Table(name = "GeoData")
public class GeoData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    String place_id;
    String lon;
    String lat;
    String addressData;
    String highway;
    String house_number;
    String road;
    String city;
    String suburb;
    String district;
    String state;
    String state_district;
    String postcode;
    String country;
    String country_code;
    String amenity;

    public GeoData() {
    }

    public GeoData(int id, String place_id, String lon, String lat, String addressData, String highway, String road, String city, String suburb, String district, String state, String state_district, String postcode, String country, String country_code, String amenity, String house_number) {
        this.id = id;
        this.place_id = place_id;
        this.lon = lon;
        this.lat = lat;
        this.addressData = addressData;
        this.highway = highway;
        this.road = road;
        this.city = city;
        this.suburb = suburb;
        this.district = district;
        this.state = state;
        this.state_district = state_district;
        this.postcode = postcode;
        this.country = country;
        this.country_code = country_code;
        this.amenity = amenity;
        this.house_number = house_number;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getId() {
        return id;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
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

    public String getAddressData() {
        return addressData;
    }

    public void setAddressData(String addressData) {
        this.addressData = addressData;
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
}
