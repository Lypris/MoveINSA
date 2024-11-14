package fr.insa.moveinsa.data.repository;

import fr.insa.moveinsa.data.entity.MobilityHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MobilityHistoryRepository extends JpaRepository<MobilityHistory, Long> {
}
