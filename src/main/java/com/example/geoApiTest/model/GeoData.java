package com.example.geoApiTest.model;

import javax.persistence.*;

@Entity
@Table(name="GeoData")
public class GeoData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    String place_id;
    String lon;
    String lat;
    String addressData;
    String highway;
    String road;
    String city;
    String state_district;
    String state;
    String postcode;
    String country;
    String country_code;
    String amenity;
    String house_number;

    int frequency;


}
