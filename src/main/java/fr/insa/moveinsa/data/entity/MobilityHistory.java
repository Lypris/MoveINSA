package fr.insa.moveinsa.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class MobilityHistory extends AbstractEntity {
    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToOne
    @JoinColumn(name = "mobility_offer_id")
    private MobilityOffer mobilityOffer;

    private String year;

    private String finalStatus; // ENUM('Accepted', 'Rejected') (final status of the offer for that year)

    public MobilityHistory() {
    }

    public MobilityHistory(Student student, MobilityOffer mobilityOffer, String year, String finalStatus) {
        this.student = student;
        this.mobilityOffer = mobilityOffer;
        this.year = year;
        this.finalStatus = finalStatus;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public MobilityOffer getMobilityOffer() {
        return mobilityOffer;
    }

    public void setMobilityOffer(MobilityOffer mobilityOffer) {
        this.mobilityOffer = mobilityOffer;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getFinalStatus() {
        return finalStatus;
    }

    public void setFinalStatus(String finalStatus) {
        this.finalStatus = finalStatus;
    }
}

