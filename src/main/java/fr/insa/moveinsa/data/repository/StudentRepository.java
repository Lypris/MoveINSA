package fr.insa.moveinsa.data.repository;

import fr.insa.moveinsa.data.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Long> {

}
