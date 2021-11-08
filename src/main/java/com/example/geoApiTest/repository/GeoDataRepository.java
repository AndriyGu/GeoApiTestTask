package com.example.geoApiTest.repository;

import com.example.geoApiTest.model.Account;
import com.example.geoApiTest.model.GeoData;
import com.example.geoApiTest.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface GeoDataRepository extends JpaRepository<GeoData, Integer> {

    @Query("Select geo from GeoData geo WHERE geo.lat=?1 and geo.lon=?2")
    GeoData findByLatLon(String lat, String lon);

    @Query("Select geo from GeoData geo WHERE geo.lat=?1 and geo.lon=?2")
    List<GeoData> findAllByLatLon(String lat, String lon);

}
