package fr.insa.moveinsa.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;

@Entity
public class HistoriqueMobilite extends AbstractEntity{
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;
    @JoinColumn(name = "offre_mobilite_id")
    private OffreMobilite offreMobilite;
    private String annee;
    private String statut_final; //ENUM('Accepté', 'Refusé') (statut final de l’offre cette année-là)

    public HistoriqueMobilite() {
    }

    public HistoriqueMobilite(Etudiant etudiant, OffreMobilite offreMobilite, String annee, String statut_final) {
        this.etudiant = etudiant;
        this.offreMobilite = offreMobilite;
        this.annee = annee;
        this.statut_final = statut_final;
    }
}
