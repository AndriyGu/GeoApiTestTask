package com.example.geoApiTest.service;

import com.example.geoApiTest.model.AddressData;
import com.example.geoApiTest.model.DTO.CoordinatesDTO;
import com.example.geoApiTest.model.GeoData;
import com.example.geoApiTest.repository.GeoDataRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
public class NominatimService {

    @Autowired
    GeoDataRepository geoDataRepository;


    public NominatimService(GeoDataRepository geoDataRepository) {
        this.geoDataRepository = geoDataRepository;
    }

    public ResponseEntity<CoordinatesDTO[]> getDataFromAddress(String requestAddress) throws IOException, SQLIntegrityConstraintViolationException {

        String url = String.format("https://nominatim.openstreetmap.org/search?q=%s&format=json&polygon_geojson=1&addressdetails=1", requestAddress);
        String response = useApiNominatium(url);

        CoordinatesDTO[] data = new Gson().fromJson(response, CoordinatesDTO[].class);
        AddressData[] addressData = new Gson().fromJson(response, AddressData[].class);


        if (data.length > 0) {
            addGeoDataToDB(addressData);
            return new ResponseEntity<CoordinatesDTO[]>(data, HttpStatus.OK);
        } else {
            return new ResponseEntity<CoordinatesDTO[]>(data, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<AddressData> getDataFromCoordinates(String lat, String lon) throws IOException {

        String url = String.format("https://nominatim.openstreetmap.org/reverse?format=json&lat=%s&lon=%s", lat, lon);
        String response = useApiNominatium(url);

        AddressData addressData = new Gson().fromJson(response, AddressData.class);
        CoordinatesDTO data = new Gson().fromJson(response, CoordinatesDTO.class);


        if (addressData != null) {
            addOneGeoDataToDB(addressData);
            return new ResponseEntity<AddressData>(addressData, HttpStatus.OK);
        } else {
            return new ResponseEntity<AddressData>(addressData, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<GeoData>> getDataFromCoordinatesBD(String lat, String lon) {

        List<GeoData> geoData = geoDataRepository.findAllByLatLon(lat, lon);

        if (geoData.isEmpty()) {
            return new ResponseEntity<List<GeoData>>(geoData, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<GeoData>>(geoData, HttpStatus.OK);
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
        return String.valueOf(response);
    }


    private void addGeoDataToDB(AddressData[] address) throws SQLIntegrityConstraintViolationException {
        for (AddressData addressData : address) {
            addOneGeoDataToDB(addressData);
        }
    }

    private void addOneGeoDataToDB(AddressData addressData) {
        GeoData tt = geoDataRepository.findByLatLon(addressData.getLat(), addressData.getLon());
        if (geoDataRepository.findByLatLon(addressData.getLat(), addressData.getLon()) == null) {
            GeoData geoData = new GeoData();
            geoData.setPlace_id(addressData.getPlace_id());
            geoData.setLon(addressData.getLon());
            geoData.setLat(addressData.getLat());
            geoData.setHighway(addressData.getAddress().getHighway());
            geoData.setRoad(addressData.getAddress().getRoad());
            geoData.setCity(addressData.getAddress().getCity());
            geoData.setSuburb(addressData.getAddress().getSuburb());
            geoData.setDistrict(addressData.getAddress().getDistrict());
            geoData.setState(addressData.getAddress().getState());
            geoData.setState_district(addressData.getAddress().getState_district());
            geoData.setPostcode(addressData.getAddress().getPostcode());
            geoData.setCountry(addressData.getAddress().getCountry());
            geoData.setCountry_code(addressData.getAddress().getCountry_code());
            geoData.setAmenity(addressData.getAddress().getAmenity());
            geoData.setHouse_number(addressData.getAddress().getHouse_number());

            geoDataRepository.save(geoData);
            System.out.println("New data added");
        } else {
            System.out.println("This coordinates exist in DB");
        }
    }
}
