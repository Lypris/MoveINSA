package fr.insa.moveinsa.data.repository;

import com.vaadin.flow.server.Command;
import fr.insa.moveinsa.data.entity.Etudiant;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;




public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

}
