package fr.insa.moveinsa.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Student extends AbstractEntity{

    @NotNull
    private String nom;
    @NotNull
    private String prenom;
    @NotNull
    private String email;
    @NotNull
    private String specialite;
    private double classement;


    public Student(String nom, String prenom, String email, String specialite, float classement) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.specialite = specialite;
        this.classement = classement;
    }

    public Student() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public double getClassement() {
        return classement;
    }

    public void setClassement(double classement) {
        this.classement = classement;
    }
}
