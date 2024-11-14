package fr.insa.moveinsa.data.service;

import fr.insa.moveinsa.data.entity.Establishment;
import fr.insa.moveinsa.data.repository.EstablishmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtablissementService {

    @Autowired
    private EstablishmentRepository establishmentRepository;

    public List<Establishment> findAllEtablishments() {
        return establishmentRepository.findAll();
    }

    public void save(Establishment establishment) {
        if (establishment == null) {
            System.err.println("Etablishment is null. Are you sure you have connected your form to the application?");
            return;
        }
        establishmentRepository.save(establishment);
    }

    public Establishment findByName(String value) {
        return establishmentRepository.findByName(value);
    }

    public List<Establishment> findAll() {
        return establishmentRepository.findAll();
    }
}
