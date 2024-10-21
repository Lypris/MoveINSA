package fr.insa.moveinsa.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;

import java.time.LocalDateTime;

@Entity
public class Attribution extends AbstractEntity{
     @JoinColumn(name = "candidature_id")
    private Candidature candidature;
    private LocalDateTime date_attribution; //date d’attribution de la mobilité
    private String statut_final; //ENUM('Accepté', 'Refusé') (statut final de l’attribution)

    public Attribution() {
    }

    public Attribution(Candidature candidature, LocalDateTime date_attribution, String statut_final) {
        this.candidature = candidature;
        this.date_attribution = date_attribution;
        this.statut_final = statut_final;
    }
}
