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
    private String classe;

    public Etudiant() {
    }

}
