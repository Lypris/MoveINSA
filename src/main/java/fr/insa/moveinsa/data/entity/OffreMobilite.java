package fr.insa.moveinsa.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;

import java.time.LocalDateTime;

@Entity
public class OffreMobilite extends AbstractEntity{
    @JoinColumn(name = "etablissement_id")
    private Etablissement etablissement;
    private String specialite;
    private String semestre;
    private int nb_places;
    //date de début de la mobilité
    private LocalDateTime date_debut;
    //date de fin de la mobilité
    private LocalDateTime date_fin;

    public OffreMobilite(Etablissement etablissement, String specialite, String semestre, int nb_places, LocalDateTime date_debut, LocalDateTime date_fin) {
        this.etablissement = etablissement;
        this.specialite = specialite;
        this.semestre = semestre;
        this.nb_places = nb_places;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public OffreMobilite() {
    }
}
