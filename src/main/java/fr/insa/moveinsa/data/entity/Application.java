package fr.insa.moveinsa.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Application extends AbstractEntity {
    // Foreign key to students (id)
    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    // Foreign key to mobility offers (id)
    @OneToOne
    @JoinColumn(name = "mobility_offer_id")
    private MobilityOffer mobilityOffer;

    private int priority; // 1, 2, 3, 4, 5 to indicate the priority of the application, e.g., 1 for first choice, 2 for second choice

    // Will be an ENUM('Pending', 'Accepted', 'Rejected') (status of the application)
    private String status;

    private String targetSemester;

    public Application() {
    }

    public Application(Student student, MobilityOffer mobilityOffer, int priority, String status, String targetSemester) {
        this.student = student;
        this.mobilityOffer = mobilityOffer;
        this.priority = priority;
        this.status = status;
        this.targetSemester = targetSemester;
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

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTargetSemester() {
        return targetSemester;
    }

    public void setTargetSemester(String targetSemester) {
        this.targetSemester = targetSemester;
    }
}


