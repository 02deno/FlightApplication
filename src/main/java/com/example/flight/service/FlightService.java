package com.example.flight.service;

import com.example.flight.data.FlightDatabase;
import com.example.flight.model.Flight;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FlightService {
    private final FlightDatabase dataSource;
    public FlightService(FlightDatabase dataSource) {
        this.dataSource = dataSource;
    }

    public List<Flight> getFlights() {
        return dataSource.findAll();
    }

    public Optional<Flight> getFlight(UUID id) {
        return dataSource.findById(id);
    }

    public Flight addFlight(Flight flight) {
        return dataSource.save(flight);
    }

    public void deleteFlight(UUID id) {
        dataSource.deleteById(id);
    }

    public void updateFlight(Flight flight) {
        Optional<Flight> optionalFlight = dataSource.findById(flight.getId());
        if (optionalFlight.isPresent()) {
            // Modify the fields of the entity object
            Flight newFlight = optionalFlight.get();
            newFlight.setArrivalAirport(flight.getArrivalAirport());
            newFlight.setDepartureAirport(flight.getDepartureAirport());
            newFlight.setPrice(flight.getPrice());
            newFlight.setDepartureDate(flight.getDepartureDate());
            newFlight.setReturnDate(flight.getReturnDate());
            // Save the entity
            dataSource.save(newFlight);
        }
    }
}
