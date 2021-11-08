package com.example.geoApiTest.model.DTO;

import com.example.geoApiTest.model.Address;

public class AddressDataDTO {
    String place_id;
    Address address;

    public AddressDataDTO() {
    }

    public AddressDataDTO(String place_id, Address address) {
        this.place_id = place_id;
        this.address = address;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
