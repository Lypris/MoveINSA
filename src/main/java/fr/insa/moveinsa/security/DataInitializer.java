package fr.insa.moveinsa.security;

import fr.insa.moveinsa.data.entity.Role;
import fr.insa.moveinsa.data.entity.User;
import fr.insa.moveinsa.data.repository.RoleRepository;
import fr.insa.moveinsa.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        // Create roles if they don't exist
        Role adminRole = createRoleIfNotFound("ADMIN");
        Role studentRole = createRoleIfNotFound("STUDENT");

        // Create initial admin user
        if (!userRepository.findByUsername("admin").isPresent()) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("adminpass"));
            admin.setRole(adminRole);
            userRepository.save(admin);
        }

        // Create a test student user
        if (!userRepository.findByUsername("student").isPresent()) {
            User student = new User();
            student.setUsername("student");
            student.setPassword(passwordEncoder.encode("studentpass"));
            student.setRole(studentRole);
            userRepository.save(student);
        }

    }

    private Role createRoleIfNotFound(String name) {
        return roleRepository.findByName(name)
                .orElseGet(() -> {
                    Role role = new Role();
                    role.setName(name);
                    return roleRepository.save(role);
                });
    }
}