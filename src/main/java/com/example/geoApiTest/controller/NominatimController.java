package com.example.geoApiTest.controller;

import com.example.geoApiTest.model.AddressData;
import com.example.geoApiTest.model.DTO.CoordinatesDTO;
import com.example.geoApiTest.model.GeoData;
import com.example.geoApiTest.service.NominatimService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@RestController
@RequestMapping("/api/nominatim")
public class NominatimController {

    @Autowired
    NominatimService nominatimService;

    public NominatimController(NominatimService nominatimService) {
        this.nominatimService = nominatimService;
    }

    @Operation(summary = "Coordinates search by address")
    @GetMapping("/findCoordinatesByAddress/{address}")
    ResponseEntity<CoordinatesDTO[]> findCoordinatesByAddress(
            @PathVariable("address") String address) throws IOException, SQLIntegrityConstraintViolationException {
        return nominatimService.getDataFromAddress(address);
    }

    @Operation(summary = "GeoData search by coordinates from Nominatum")
    @GetMapping("/getDataFromCoordinatesFromAPI/{lat}/{lon}")
    ResponseEntity<AddressData> getDataFromCoordinatesFromAPI(@PathVariable("lon") String lon,
                                                       @PathVariable("lat") String lat
    ) throws IOException, SQLIntegrityConstraintViolationException {
        return nominatimService.getDataFromCoordinates(lat, lon);
    }

    //The application must be called by REST API for receiving all addresses from Nominatim API  by saved coordinates.
    @Operation(summary = "GeoData search by coordinates from DB")
    @GetMapping("/getDataFromCoordinatesBD/{lat}/{lon}")
    ResponseEntity<List<GeoData>> getDataFromCoordinatesFromBD(@PathVariable("lon") String lon,
                                                               @PathVariable("lat") String lat
    ) {
        return nominatimService.getDataFromCoordinatesBD(lat, lon);
    }

}
