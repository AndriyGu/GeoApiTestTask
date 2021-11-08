package com.example.geoApiTest.controller;

import com.example.geoApiTest.model.DTO.AddressDataDTO;
import com.example.geoApiTest.model.DTO.CoordinatesDTO;
import com.example.geoApiTest.service.NominatimService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

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
            @PathVariable("address") String address) throws IOException {
        return nominatimService.getDataFromAddress(address);
    }

    @Operation(summary = "GeoData search by coordinates")
    @GetMapping("/getDataFromCoordinates/{lon}/{lat}")
    ResponseEntity<AddressDataDTO> getDataFromCoordinates(@PathVariable("lon") String lon,
                                                          @PathVariable("lat") String lat
    ) throws IOException {
        return nominatimService.getDataFromCoordinates(lon, lat);
    }
}
