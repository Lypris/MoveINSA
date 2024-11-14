package fr.insa.moveinsa.data.repository;

import fr.insa.moveinsa.data.entity.MobilityOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MobilityOfferRepository extends JpaRepository<MobilityOffer, Long> {

    @Query("SELECT mo FROM MobilityOffer mo " +
            "WHERE (:establishment IS NULL OR LOWER(mo.establishment.name) LIKE LOWER(CONCAT('%', :establishment, '%'))) " +
            "AND (:specialty IS NULL OR LOWER(mo.specialty) LIKE LOWER(CONCAT('%', :specialty, '%'))) " +
            "AND (:semester IS NULL OR LOWER(mo.semester) LIKE LOWER(CONCAT('%', :semester, '%')))")
    List<MobilityOffer> findByCriteria(
            @Param("establishment") String establishment,
            @Param("specialty") String specialty,
            @Param("semester") String semester
    );

    @Query("SELECT mo FROM MobilityOffer mo WHERE mo.establishment.name = :partnerUsername")

    List<MobilityOffer> findByPartnerUsername(@Param("partnerUsername") String partnerUsername);
}
