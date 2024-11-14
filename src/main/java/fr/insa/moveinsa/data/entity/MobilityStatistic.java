package fr.insa.moveinsa.data.entity;

import jakarta.persistence.Entity;

@Entity
public class MobilityStatistic extends AbstractEntity {
    // YEAR (year concerned by the statistics)
    private int year;
    private int numberOfApplications; // number of applications
    private int numberOfOffers; // number of mobility offers
    private int numberOfAllocations; // number of allocations
    private float acceptanceRate; // acceptance rate of the applications

    public MobilityStatistic() {
    }

    public MobilityStatistic(int year, int numberOfApplications, int numberOfOffers, int numberOfAllocations, float acceptanceRate) {
        this.year = year;
        this.numberOfApplications = numberOfApplications;
        this.numberOfOffers = numberOfOffers;
        this.numberOfAllocations = numberOfAllocations;
        this.acceptanceRate = acceptanceRate;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumberOfApplications() {
        return numberOfApplications;
    }

    public void setNumberOfApplications(int numberOfApplications) {
        this.numberOfApplications = numberOfApplications;
    }

    public int getNumberOfOffers() {
        return numberOfOffers;
    }

    public void setNumberOfOffers(int numberOfOffers) {
        this.numberOfOffers = numberOfOffers;
    }

    public int getNumberOfAllocations() {
        return numberOfAllocations;
    }

    public void setNumberOfAllocations(int numberOfAllocations) {
        this.numberOfAllocations = numberOfAllocations;
    }

    public float getAcceptanceRate() {
        return acceptanceRate;
    }

    public void setAcceptanceRate(float acceptanceRate) {
        this.acceptanceRate = acceptanceRate;
    }
}
