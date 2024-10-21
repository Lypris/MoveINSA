package fr.insa.moveinsa.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;

@Entity
public class Candidature extends AbstractEntity{
    // clé étrangère vers etudiants(id)
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;
    // clé étrangère vers offres_mobilite(id)
    @JoinColumn(name = "offre_mobilite_id")
    private OffreMobilite offre_mobilite;
    private int priorite; // 1, 2, 3, 4, 5 pour indiquer priorité de la candidature, ex. 1 pour premier choix, 2 pour deuxième choix
    // sera un ENUM('En attente', 'Accepté', 'Refusé') (statut de la candidature)
    private String statut;

    public Candidature() {
    }

    public Candidature(Etudiant etudiant, OffreMobilite offre_mobilite, int priorite, String statut) {
        this.etudiant = etudiant;
        this.offre_mobilite = offre_mobilite;
        this.priorite = priorite;
        this.statut = statut;
    }
}

