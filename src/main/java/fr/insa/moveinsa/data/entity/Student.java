package fr.insa.moveinsa.data.entity;

import jakarta.persistence.Entity;
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
    private float classement;


    public Student(String nom, String prenom, String email, String specialite, float classement) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.specialite = specialite;
        this.classement = classement;
    }

    public Student() {
    }

}
