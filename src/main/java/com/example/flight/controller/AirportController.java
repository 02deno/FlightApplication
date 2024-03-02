package com.example.flight.controller;

import com.example.flight.model.Airport;
import com.example.flight.service.AirportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/api/airports")
public class AirportController {

    private final AirportService service;

    public AirportController(AirportService service) {
        this.service = service;
    }

    @GetMapping("/getAllAirports")
    public List<Airport> getAirports() {
        return service.getAirports();
    }

    @GetMapping("/getAirportID_{id}")
    public Airport getAirport(@PathVariable UUID id) {
        return service.getAirport(id);
    }

    @PostMapping("/addAirport")
    @ResponseStatus(HttpStatus.CREATED)
    public Airport addAirport(@RequestBody Airport airport) {
        return service.addAirport(airport);
    }

    @DeleteMapping("/deleteAirportID_{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAirport(@PathVariable UUID id) {
        service.deleteAirport(id);
    }

    @PatchMapping("/updateAirport")
    public Airport updateAirport(@RequestBody Airport airport) {
        return service.updateAirport(airport);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNotFound(NoSuchElementException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleBadRequest(IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}

