package fr.insa.moveinsa.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.time.LocalDateTime;

@Entity
public class MobilityOffer extends AbstractEntity {
    @OneToOne
    @JoinColumn(name = "establishment_id")
    private Establishment establishment;

    private String specialty;
    private String semester;
    private int availablePlaces;

    // Start date of the mobility
    private LocalDateTime startDate;

    // End date of the mobility
    private LocalDateTime endDate;

    public MobilityOffer(Establishment establishment, String specialty, String semester, int availablePlaces, LocalDateTime startDate, LocalDateTime endDate) {
        this.establishment = establishment;
        this.specialty = specialty;
        this.semester = semester;
        this.availablePlaces = availablePlaces;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public MobilityOffer() {
    }

    public Establishment getEstablishment() {
        return establishment;
    }

    public void setEstablishment(Establishment establishment) {
        this.establishment = establishment;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getAvailablePlaces() {
        return availablePlaces;
    }

    public void setAvailablePlaces(int availablePlaces) {
        this.availablePlaces = availablePlaces;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}

