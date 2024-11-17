package fr.insa.moveinsa.data.service;

import fr.insa.moveinsa.data.entity.Student;
import fr.insa.moveinsa.data.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public void save(Student student) {
        if (student == null) {
            System.err.println("Student is null. Are you sure you have connected your form to the application?");
            return;
        }
        studentRepository.save(student);
    }

    public void delete(Student student) {
        studentRepository.delete(student);
    }

}
