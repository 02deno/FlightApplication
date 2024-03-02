package com.example.flight.service;

import com.example.flight.data.FlightDataSource;
import com.example.flight.model.Flight;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
public class FlightService {
    private final FlightDataSource dataSource;

    public FlightService(FlightDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Flight> getFlights() {
        return dataSource.retrieveFlights();
    }

    public Flight getFlight(UUID id) {
        return dataSource.retrieveFlight(id);
    }

    public Flight addFlight(Flight flight) {
        return dataSource.createFlight(flight);
    }

    public void deleteFlight(UUID id) {
        dataSource.deleteFlight(id);
    }

    public Flight updateFlight(Flight flight) {
        return dataSource.updateFlight(flight);
    }
}
