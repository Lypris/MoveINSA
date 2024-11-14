package fr.insa.moveinsa.data.repository;

import fr.insa.moveinsa.data.entity.Establishment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstablishmentRepository extends JpaRepository<Establishment, Long> {
    Establishment findByName(String value);
}
