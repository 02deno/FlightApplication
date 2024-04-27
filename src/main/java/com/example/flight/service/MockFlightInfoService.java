package com.example.flight.service;

import com.example.flight.model.Airport;
import com.example.flight.model.Flight;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
public class MockFlightInfoService {
    public List<Flight> getFlightInformation() {
        return new ArrayList<>(Arrays.asList(
                new Flight(UUID.randomUUID(), new Airport(UUID.randomUUID(),"London","Heatrow","ENG"), new Airport(),LocalDateTime.of(2024, 12, 12,11,30), LocalDateTime.of(2024, 12, 12,16,30), 250.00),
                new Flight(UUID.randomUUID(), new Airport(UUID.randomUUID(),"Paris","Eifel","FRC"), new Airport(), LocalDateTime.of(2024, 11, 23,11,30), LocalDateTime.of(2024, 11, 23,16,30), 300.00)

        ));
    }
}
