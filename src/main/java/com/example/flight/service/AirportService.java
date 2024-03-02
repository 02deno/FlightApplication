package com.example.flight.service;

import com.example.flight.data.AirportDataSource;
import com.example.flight.model.Airport;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AirportService {
    private final AirportDataSource dataSource;

    public AirportService(AirportDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Airport> getAirports() {
        return dataSource.retrieveAirports();
    }

    public Airport getAirport(UUID id) {
        return dataSource.retrieveAirport(id);
    }

    public Airport addAirport(Airport airport) {
        return dataSource.createAirport(airport);
    }

    public void deleteAirport(UUID id) {
        dataSource.deleteAirport(id);
    }

    public Airport updateAirport(Airport airport) {
        return dataSource.updateAirport(airport);
    }
}
