package com.example.flight.data.mock;

import com.example.flight.data.FlightDataSource;
import com.example.flight.model.Flight;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

@Repository
public class MockFlightDataSource implements FlightDataSource {

    MockAirportDataSource airports = new MockAirportDataSource();
    private final List<Flight> flights = new ArrayList<>(Arrays.asList(
            new Flight(UUID.randomUUID(), airports.retrieveAirports().get(0) , airports.retrieveAirports().get(2), LocalDateTime.of(2024, 12, 12,11,30), LocalDateTime.of(2024, 12, 12,16,30), 250.00),
            new Flight(UUID.randomUUID(), airports.retrieveAirports().get(1), airports.retrieveAirports().get(0), LocalDateTime.of(2024, 11, 23,11,30), LocalDateTime.of(2024, 11, 23,16,30), 300.00),
            new Flight(UUID.randomUUID(), airports.retrieveAirports().get(2), airports.retrieveAirports().get(1), LocalDateTime.of(2024, 12, 12,11,30), LocalDateTime.of(2024, 12, 12,16,30), 550.00),
            new Flight(UUID.randomUUID(), airports.retrieveAirports().get(0) , airports.retrieveAirports().get(2), LocalDateTime.of(2025, 12, 12,11,30), 250.00),
            new Flight(UUID.randomUUID(), airports.retrieveAirports().get(1), airports.retrieveAirports().get(0), LocalDateTime.of(2026, 11, 23,11,30), 300.00),
            new Flight(UUID.randomUUID(), airports.retrieveAirports().get(2), airports.retrieveAirports().get(1), LocalDateTime.of(2027, 12, 12,11,30), 550.00)
    ));

    @Override
    public List<Flight> retrieveFlights() {
        return flights;
    }

    @Override
    public Flight retrieveFlight(UUID id) {
        Optional<Flight> flightOptional = flights.stream()
                .filter(currentFlight -> currentFlight.getId().equals(id))
                .findFirst();
        return flightOptional.orElseThrow(() -> new NoSuchElementException("Could not find a Flight with id " + id));

    }

    @Override
    public Flight createFlight(Flight newFlight) {
        for (Flight flight : flights) {
            if (flight.getId() == newFlight.getId()) {
                throw new IllegalArgumentException("Flight with id " + newFlight.getId() + " already exists");
            }
        }
        flights.add(newFlight);
        return newFlight;
    }

    @Override
    public void deleteFlight(UUID id) {
        Flight currentFlight = null;
        for (Flight flight : flights) {
            if (flight.getId() == id) {
                currentFlight = flight;
                break;
            }
        }
        if (currentFlight == null) {
            throw new NoSuchElementException("Could not find a Airport with id " + id);
        }
        flights.remove(currentFlight);
    }

    @Override
    public Flight updateFlight(Flight newFlight) {
        Flight currentFlight = null;
        for (Flight flight : flights) {
            if (flight.getId() == newFlight.getId()) {
                currentFlight = flight;
                break;
            }
        }
        if (currentFlight == null) {
            throw new NoSuchElementException("Could not find a Flight with id " + newFlight.getId());
        }
        flights.remove(currentFlight);
        flights.add(newFlight);
        return newFlight;
    }
}
