package fr.insa.moveinsa.data.repository;

import fr.insa.moveinsa.data.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
