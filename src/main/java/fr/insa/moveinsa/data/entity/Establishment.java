package fr.insa.moveinsa.data.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.Entity;

@Entity
public class Establishment extends AbstractEntity {
    private String name;
    private String country;
    private String city;
    private String address;
    private String url; // Website URL of the establishment

    // ENUM('Erasmus', 'Double-Degree', 'Non-Erasmus') (mobility program)
    private String program;
    private String availableSpecialties;
    private int availablePlaces;

    public Establishment() {
    }

    public Establishment(String name, String country, String city, String address, String program, String availableSpecialties, int availablePlaces) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.address = address;
        this.program = program;
        this.availableSpecialties = availableSpecialties;
        this.availablePlaces = availablePlaces;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getAvailableSpecialties() {
        return availableSpecialties;
    }

    public void setAvailableSpecialties(String availableSpecialties) {
        this.availableSpecialties = availableSpecialties;
    }

    public int getAvailablePlaces() {
        return availablePlaces;
    }

    public void setAvailablePlaces(int availablePlaces) {
        this.availablePlaces = availablePlaces;
    }
}

