package com.example.geoApiTest.model.DTO;

public class CoordinatesDTO {

    String lat;
    String lon;

    public CoordinatesDTO() {
    }

    public CoordinatesDTO(String lon, String lat) {
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
