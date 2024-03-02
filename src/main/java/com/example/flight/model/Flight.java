package com.example.flight.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Component
public class Flight {

    private UUID id;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private LocalDateTime departureDate;
    private LocalDateTime returnDate;
    private double price;

    // Default constructor
    public Flight() {
        // You can initialize default values if needed
    }

    // Constructor for one-way flight
    public Flight(UUID id, Airport departureAirport, Airport arrivalAirport, LocalDateTime departureDate, double price) {
        this.id = id;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDate = departureDate;
        this.price = price;
    }

    // Constructor for two-way flight
    public Flight(UUID id, Airport departureAirport, Airport arrivalAirport, LocalDateTime departureDate, LocalDateTime returnDate, double price) {
        this.id = id;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", departureAirport=" + departureAirport +
                ", arrivalAirport=" + arrivalAirport +
                ", departureDate=" + departureDate +
                ", returnDate=" + returnDate +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Double.compare(getPrice(), flight.getPrice()) == 0 && Objects.equals(getId(), flight.getId()) && Objects.equals(getDepartureAirport(), flight.getDepartureAirport()) && Objects.equals(getArrivalAirport(), flight.getArrivalAirport()) && Objects.equals(getDepartureDate(), flight.getDepartureDate()) && Objects.equals(getReturnDate(), flight.getReturnDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDepartureAirport(), getArrivalAirport(), getDepartureDate(), getReturnDate(), getPrice());
    }
}
