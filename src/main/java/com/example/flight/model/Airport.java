package com.example.flight.model;

import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class Airport {
    private UUID id;
    private String city;
    private String name;
    private String abbreviation;

    public Airport() {
        //default values
    }

    public Airport(UUID id, String city, String name, String abbreviation) {
        this.id = id;
        this.city = city;
        this.name = name;
        this.abbreviation = abbreviation;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(getId(), airport.getId()) && Objects.equals(getCity(), airport.getCity()) && Objects.equals(getName(), airport.getName()) && Objects.equals(getAbbreviation(), airport.getAbbreviation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCity(), getName(), getAbbreviation());
    }
}
