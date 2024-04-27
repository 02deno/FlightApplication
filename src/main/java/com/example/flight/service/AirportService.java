package com.example.flight.service;

import com.example.flight.data.AirportDatabase;
import com.example.flight.model.Airport;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AirportService {

    private final AirportDatabase dataSource;

    public AirportService(AirportDatabase dataSource) {

        this.dataSource = dataSource;

//        List<Airport> airports = new ArrayList<>(Arrays.asList(
//                new Airport(UUID.randomUUID(), "Istanbul", "Sabiha Gokcen", "SAW"),
//                new Airport(UUID.randomUUID(), "Istanbul", "Turk Hava Yollari", "THY"),
//                new Airport(UUID.randomUUID(), "Izmir", "Izmir Hava Yollari", "IHY"),
//                new Airport(UUID.randomUUID(), "Ankara", "Ankara Hava Yollari", "AHY"),
//                new Airport(UUID.randomUUID(), "Sivas", "Sivas Hava Yollari", "SHY"),
//                new Airport(UUID.randomUUID(), "Trabzon", "Trabzon Hava Yollari", "THY")
//        ));
//        dataSource.saveAll(airports);

    }

    public List<Airport> getAirports() {
        return dataSource.findAll();
    }

    public Optional<Airport> getAirport(UUID id) {
        return dataSource.findById(id);
    }

    public Airport addAirport(Airport airport) {
        return dataSource.save(airport);
    }

    public void deleteAirport(UUID id) {dataSource.deleteById(id);
    }

    public void updateAirport(Airport airport) {
        Optional<Airport> optionalAirport = dataSource.findById(airport.getId());
        if (optionalAirport.isPresent()) {
            // Modify the fields of the entity object
            Airport newAirport = optionalAirport.get();
            newAirport.setAbbreviation(airport.getAbbreviation());
            newAirport.setCity(airport.getCity());
            newAirport.setName(airport.getName());
            // Save the entity
            dataSource.save(newAirport);
        }
    }
}
