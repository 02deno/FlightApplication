package com.example.flight.data;

import com.example.flight.model.Flight;

import java.util.List;
import java.util.UUID;

public interface FlightDataSource {
    // Create, Retrieve, Update, Delete
    List<Flight> retrieveFlights();
    Flight retrieveFlight(UUID id);
    Flight createFlight(Flight flight);
    void deleteFlight(UUID id);
    Flight updateFlight(Flight flight);
}
