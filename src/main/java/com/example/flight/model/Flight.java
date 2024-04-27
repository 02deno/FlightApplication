package com.example.flight.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "departure_airport_id", nullable = false)
    private Airport departureAirport;

    @OneToOne
    @JoinColumn(name = "arrival_airport_id", nullable = false)
    private Airport arrivalAirport;

    private LocalDateTime departureDate;
    private LocalDateTime returnDate;
    private double price;


    // Constructor for one-way flight
    public Flight(UUID id, Airport departureAirport, Airport arrivalAirport, LocalDateTime departureDate, double price) {
        this.id = id;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDate = departureDate;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Double.compare(getPrice(), flight.getPrice()) == 0 && Objects.equals(getId(), flight.getId()) && Objects.equals(getDepartureAirport(), flight.getDepartureAirport()) && Objects.equals(getArrivalAirport(), flight.getArrivalAirport()) && Objects.equals(getDepartureDate(), flight.getDepartureDate()) && Objects.equals(getReturnDate(), flight.getReturnDate());
    }

}
