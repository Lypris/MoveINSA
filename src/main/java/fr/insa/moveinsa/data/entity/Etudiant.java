package fr.insa.moveinsa.data.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

@Entity
public class Etudiant extends AbstractEntity{
    @NotNull
    private String nom;
    @NotNull
    private String prenom;
    @NotNull
    private String email;
    @NotNull
    private String specialite;
    private float classement;
    private String semestre_cible;


    public Etudiant(String nom, String prenom, String email, String specialite, float classement, String semestre_cible) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.specialite = specialite;
        this.classement = classement;
        this.semestre_cible = semestre_cible;
    }

    public Etudiant() {
    }

}
