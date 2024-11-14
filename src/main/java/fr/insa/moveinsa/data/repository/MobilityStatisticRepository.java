package fr.insa.moveinsa.data.repository;

import fr.insa.moveinsa.data.entity.MobilityStatistic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MobilityStatisticRepository extends JpaRepository<MobilityStatistic, Long> {
}
