package com.example.geoApiTest.controller;

import com.example.geoApiTest.model.AdressAnsver;
import com.google.gson.Gson;
import io.swagger.v3.oas.annotations.Operation;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequestMapping("/api")
public class TestController {

    //select mentee by email
    @Operation(summary = "select mentee by token")
    @GetMapping("/getMenteeDTO/")
    ResponseEntity<String> getOneMenteeByToken() throws IOException, JSONException, ParseException {

        String url = "https://nominatim.openstreetmap.org/search?q=19/14+Akademika%20Viliamsa%20Street+Zhulyany+Holosiivskyi%20District+Kyiv+Ukraine&format=json&polygon_geojson=1&addressdetails=1";

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



        return new ResponseEntity<String>(data[0].getLat()+" "+data[0].getLon() ,HttpStatus.OK);
    }
}
