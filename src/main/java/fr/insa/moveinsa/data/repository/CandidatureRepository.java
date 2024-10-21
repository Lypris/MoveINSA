package fr.insa.moveinsa.data.repository;

import fr.insa.moveinsa.data.entity.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatureRepository extends JpaRepository<Candidature, Long> {
}
