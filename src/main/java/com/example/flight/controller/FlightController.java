package com.example.flight.controller;

import com.example.flight.model.Airport;
import com.example.flight.model.Flight;
import com.example.flight.service.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightService service;

    public FlightController(FlightService service) {
        this.service = service;
    }

    @GetMapping("/getallFlights")
    public List<Flight> getFlights() {
        return service.getFlights();
    }

    @GetMapping("/getFlightID_{id}")
    public Flight getFlight(@PathVariable UUID id) {
        return service.getFlight(id);
    }

    @PostMapping("/addFlight")
    @ResponseStatus(HttpStatus.CREATED)
    public Flight addFlight(@RequestBody Flight flight) {
        return service.addFlight(flight);
    }

    @DeleteMapping("/deleteFlightID_{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFlight(@PathVariable UUID id) {
        service.deleteFlight(id);
    }

    @PatchMapping("/updateFlight")
    public Flight updateAdmin(@RequestBody Flight flight) {
        return service.updateFlight(flight);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNotFound(NoSuchElementException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleBadRequest(IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @GetMapping("/searchFlights")
    public List<Flight> getFlights(
            @RequestParam String departureAirport,
            @RequestParam String arrivalAirport,
            @RequestParam LocalDateTime departureDate,
            @RequestParam(required = false) LocalDateTime returnDate) {

        List<Flight>mockFlights = service.getFlights();
        List<Flight> flights = new ArrayList<>();

        // Tek yönlü uçuş
        for (Flight flight : mockFlights) {
            if (flight.getDepartureAirport().getAbbreviation().equals(departureAirport) &&
                    flight.getArrivalAirport().getAbbreviation().equals(arrivalAirport) &&
                    flight.getDepartureDate().equals(departureDate)) {
                if(returnDate == null) {
                    flights.add(new Flight(flight.getId(), flight.getDepartureAirport(), flight.getArrivalAirport(),flight.getDepartureDate(), flight.getPrice()));
                }else {
                    if(flight.getReturnDate().equals(returnDate)){
                        flights.add(new Flight(flight.getId(), flight.getDepartureAirport(), flight.getArrivalAirport(),flight.getDepartureDate(), flight.getPrice()));
                        flights.add(new Flight(flight.getId(), flight.getArrivalAirport(), flight.getDepartureAirport(),flight.getReturnDate(), flight.getPrice()));
                    }
                }

            }
        }

        return flights;
    }

}
