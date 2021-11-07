package com.example.geoApiTest.service;

import com.example.geoApiTest.model.Address;
import com.example.geoApiTest.model.AdressAnsver;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Service
public class NominatimService {

    public Address[] getODataFromAddress(String reqestAddress) throws IOException {

        String url = String.format("https://nominatim.openstreetmap.org/search?q=[%s]&format=json&polygon_geojson=1&addressdetails=1", reqestAddress);

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

        AdressAnsver[] data = new Gson().fromJson(String.valueOf(response), AdressAnsver[].class);

        System.out.println(data[0].getLat());
        System.out.println(data[0].getLon());

        System.out.println(response.toString());

        return null;
    }
}
