package fr.insa.moveinsa.data.entity;

import jakarta.persistence.Entity;

@Entity
public class Etablissement extends AbstractEntity{
    private String nom;
    private String pays;
    private String ville;
    private String adresse;

    // ENUM('Erasmus', 'Double-Diplôme', 'Hors-Erasmus') (dispositif de mobilité)
    private String dispositif;
    private String specialites_disponibles;
    private int nb_places;

    public Etablissement() {
    }

    public Etablissement(String nom, String pays, String ville, String adresse, String dispositif, String specialites_disponibles, int nb_places) {
        this.nom = nom;
        this.pays = pays;
        this.ville = ville;
        this.adresse = adresse;
        this.dispositif = dispositif;
        this.specialites_disponibles = specialites_disponibles;
        this.nb_places = nb_places;
    }
}
