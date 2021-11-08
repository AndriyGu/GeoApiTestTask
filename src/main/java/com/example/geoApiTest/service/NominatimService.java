package com.example.geoApiTest.service;

import com.example.geoApiTest.model.DTO.AddressDataDTO;
import com.example.geoApiTest.model.DTO.CoordinatesDTO;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class NominatimService {

    public ResponseEntity<CoordinatesDTO[]> getDataFromAddress(String requestAddress) throws IOException {

        String url = String.format("https://nominatim.openstreetmap.org/search?q=%s&format=json&polygon_geojson=1&addressdetails=1", requestAddress);
        String response = useApiNominatium(url);

        CoordinatesDTO[] data = new Gson().fromJson(response, CoordinatesDTO[].class);

        if (data.length > 0) {
            return new ResponseEntity<CoordinatesDTO[]>(data, HttpStatus.OK);
        } else {
            return new ResponseEntity<CoordinatesDTO[]>(data, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<AddressDataDTO> getDataFromCoordinates(String lon, String lat) throws IOException {

        String url = String.format("https://nominatim.openstreetmap.org/reverse?format=json&lat=%s&lon=%s", lon, lat);
        String response = useApiNominatium(url);

        AddressDataDTO data = new Gson().fromJson(response, AddressDataDTO.class);

        if (data!=null) {
            return new ResponseEntity<AddressDataDTO>(data, HttpStatus.OK);
        } else {
            return new ResponseEntity<AddressDataDTO>(data, HttpStatus.NOT_FOUND);
        }


    }
    private String useApiNominatium(String url) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));

        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return  String.valueOf(response);
    }
}
