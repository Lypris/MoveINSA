package fr.insa.moveinsa.data.repository;

import fr.insa.moveinsa.data.entity.Attribution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttributionRepository extends JpaRepository<Attribution, Long> {
}
