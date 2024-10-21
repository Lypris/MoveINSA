package fr.insa.moveinsa.data.repository;

import fr.insa.moveinsa.data.entity.Etudiant;
import fr.insa.moveinsa.data.entity.HistoriqueMobilite;
import fr.insa.moveinsa.data.entity.OffreMobilite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoriqueMobiliteRepository extends JpaRepository<HistoriqueMobilite, Long> {
    List<HistoriqueMobilite> findByEtudiant(Etudiant etudiant);
    List<HistoriqueMobilite> findByOffreMobilite(OffreMobilite offreMobilite);
    List<HistoriqueMobilite> findByAnnee(String annee);
    List<HistoriqueMobilite> findByStatutFinal(String statut_final);
    List<HistoriqueMobilite> findByEtudiantAndOffreMobilite(Etudiant etudiant, OffreMobilite offreMobilite);
}
