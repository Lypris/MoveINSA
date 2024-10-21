package fr.insa.moveinsa.data.entity;

import jakarta.persistence.Entity;

@Entity
public class StatistiqueMobilite extends AbstractEntity{
    // YEAR (année concernée par les statistiques)
    private int annee;
    private int nb_candidatures; //nombre de candidatures
    private int nb_offres; //nombre d’offres de mobilité
    private int nb_attributions; //nombre d’attributions
    private float taux_acceptation; //taux d’acceptation des candidatures

    public StatistiqueMobilite() {
    }

    public StatistiqueMobilite(int annee, int nb_candidatures, int nb_offres, int nb_attributions, float taux_acceptation) {
        this.annee = annee;
        this.nb_candidatures = nb_candidatures;
        this.nb_offres = nb_offres;
        this.nb_attributions = nb_attributions;
        this.taux_acceptation = taux_acceptation;
    }
}
