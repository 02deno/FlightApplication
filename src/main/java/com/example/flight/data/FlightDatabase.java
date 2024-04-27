package com.example.flight.data;

import com.example.flight.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface FlightDatabase extends JpaRepository<Flight, UUID> {
}
