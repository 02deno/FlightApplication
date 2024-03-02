package com.example.flight.data.mock;

import com.example.flight.data.AirportDataSource;
import com.example.flight.model.Airport;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MockAirportDataSource implements AirportDataSource {

    private final List<Airport> airports = new ArrayList<>(Arrays.asList(
            new Airport(UUID.randomUUID(), "Istanbul", "Sabiha Gokcen","SAW"),
            new Airport(UUID.randomUUID(), "Istanbul", "Turk Hava Yollari", "THY"),
            new Airport(UUID.randomUUID(), "Izmir", "Izmir Hava Yollari","IHY"),
            new Airport(UUID.randomUUID(), "Ankara","Ankara Hava Yollari","AHY"),
            new Airport(UUID.randomUUID(), "Sivas","Sivas Hava Yollari","SHY"),
            new Airport(UUID.randomUUID(), "Trabzon","Trabzon Hava Yollari","THY")
    ));
    @Override
    public List<Airport> retrieveAirports() {
        return airports;
    }

    @Override
    public Airport retrieveAirport(UUID id) {
        for (Airport airport : airports) {
            if (airport.getId().equals(id)) {
                System.out.println("Airport retrieved: " + airport);
                return airport;
            }
        }
        throw new NoSuchElementException("Could not find an Airport with id " + id);
    }

    @Override
    public Airport createAirport(Airport newAirport) {
        for (Airport airport : airports) {
            if (airport.getId().equals(newAirport.getId())) {
                throw new IllegalArgumentException("Airport with id " + newAirport.getId() + " already exists");
            }
        }
        airports.add(newAirport);
        return newAirport;
    }

    @Override
    public void deleteAirport(UUID id) {
        Airport currentAirport = null;
        for (Airport airport : airports) {
            if (airport.getId().equals(id)) {
                currentAirport = airport;
                break;
            }
        }
        if (currentAirport == null) {
            throw new NoSuchElementException("Could not find a Airport with id " + id);
        }
        airports.remove(currentAirport);
    }

    @Override
    public Airport updateAirport(Airport newAirport) {
        Airport currentAirport = null;
        for (Airport airport : airports) {
            if (airport.getId().equals(newAirport.getId())) {
                currentAirport = airport;
                break;
            }
        }
        if (currentAirport == null) {
            throw new NoSuchElementException("Could not find a Airport with id " + newAirport.getId());
        }
        airports.remove(currentAirport);
        airports.add(newAirport);
        return newAirport;
    }
}
