package com.example.flight.data;

import com.example.flight.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AirportDatabase extends JpaRepository<Airport, UUID> {
}
