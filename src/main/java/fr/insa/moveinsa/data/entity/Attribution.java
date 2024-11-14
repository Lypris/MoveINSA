package fr.insa.moveinsa.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.time.LocalDateTime;

@Entity
public class Attribution extends AbstractEntity{
    @OneToOne
    @JoinColumn(name = "candidature_id")
    private Application application;
    private LocalDateTime attribution_date; //date d’attribution de la mobilité
    private String final_status; //ENUM('Accepté', 'Refusé') (statut final de l’attribution)

    public Attribution() {
    }

    public Attribution(Application application, LocalDateTime attribution_date, String final_status) {
        this.application = application;
        this.attribution_date = attribution_date;
        this.final_status = final_status;
    }
}
