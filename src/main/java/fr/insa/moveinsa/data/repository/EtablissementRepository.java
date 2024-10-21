package fr.insa.moveinsa.data.repository;

import fr.insa.moveinsa.data.entity.Etablissement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtablissementRepository extends JpaRepository<Etablissement, Long> {
}
