package com.example.flight.data;

import com.example.flight.model.Airport;
import java.util.List;
import java.util.UUID;

public interface AirportDataSource {
    // Create, Retrieve, Update, Delete
    List<Airport> retrieveAirports();
    Airport retrieveAirport(UUID id);
    Airport createAirport(Airport airport);
    void deleteAirport(UUID id);
    Airport updateAirport(Airport airport);
}
