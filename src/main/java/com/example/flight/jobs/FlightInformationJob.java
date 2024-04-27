package com.example.flight.jobs;

import com.example.flight.data.FlightDatabase;
import com.example.flight.model.Flight;
import com.example.flight.service.MockFlightInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlightInformationJob {
    private final MockFlightInfoService flightInfoService;
    private final FlightDatabase flightDatabase;

    @Autowired
    public FlightInformationJob(MockFlightInfoService flightInfoService, FlightDatabase flightDatabase) {
        this.flightInfoService = flightInfoService;
        this.flightDatabase = flightDatabase;
    }

    //@Scheduled(cron = "0 0 0 * * ?") // Runs at midnight every day
    @Scheduled(fixedRate = 30000)
    public void retrieveFlightInformation() {
        List<Flight> flights= flightInfoService.getFlightInformation();
        for (Flight flight : flights){
            flightDatabase.save(flight);
            System.out.println("Saved flight information: " + flight);
        }

    }
}
