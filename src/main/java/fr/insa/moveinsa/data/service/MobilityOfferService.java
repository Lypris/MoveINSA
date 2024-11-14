package fr.insa.moveinsa.data.service;

import fr.insa.moveinsa.data.entity.MobilityOffer;
import fr.insa.moveinsa.data.repository.MobilityOfferRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class MobilityOfferService {

    @Autowired
    private MobilityOfferRepository mobilityOfferRepository;

    public List<MobilityOffer> findAllOffers() {
        return mobilityOfferRepository.findAll();
    }

    public List<MobilityOffer> searchOffers(String establishment, String specialty, String semester) {
        // Ajouter ici la logique pour filtrer les offres selon les critères
        return mobilityOfferRepository.findByCriteria(establishment, specialty, semester);
    }
    public List<MobilityOffer> findAllOffersForPartner(String partnerUsername) {
        // Query the repository for offers associated with the logged-in partner.
        return mobilityOfferRepository.findByPartnerUsername(partnerUsername);
    }
    public void save(MobilityOffer offre) {
        if (offre == null) {
            System.err.println("Mobility offer is null. Are you sure you have connected your form to the application?");
            return;
        }
        mobilityOfferRepository.save(offre);
    }

    public List<MobilityOffer> findAll() {
        return mobilityOfferRepository.findAll();
    }
}
