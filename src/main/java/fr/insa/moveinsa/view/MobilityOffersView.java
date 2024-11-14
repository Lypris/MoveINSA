package fr.insa.moveinsa.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import fr.insa.moveinsa.data.entity.MobilityOffer;
import fr.insa.moveinsa.data.service.MobilityOfferService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route(value = "/offers", layout = MainLayout.class)
@PageTitle("Offers | MoveINSA")
@AnonymousAllowed
public class MobilityOffersView extends VerticalLayout {
    private final MobilityOfferService mobilityOfferService;
    private final Grid<MobilityOffer> mobilityOfferGrid = new Grid<>(MobilityOffer.class);

    private final TextField establishmentFilter = new TextField("Établissement");
    private final TextField specialtyFilter = new TextField("Spécialité");
    private final TextField semesterFilter = new TextField("Semestre");
    private final Button searchButton = new Button("Rechercher");

    @Autowired
    public MobilityOffersView(MobilityOfferService mobilityOfferService) {
        this.mobilityOfferService = mobilityOfferService;

        // Titre de la page
        H1 title = new H1("Offres de Mobilité");

        // Configuration des filtres et bouton de recherche
        setupFilters();

        // Configuration de la grille
        configureGrid();

        // Chargement initial des données
        updateGrid();

        add(title, establishmentFilter, specialtyFilter, semesterFilter, searchButton, mobilityOfferGrid);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setPadding(true);
        setSpacing(true);
    }

    private void setupFilters() {
        establishmentFilter.setPlaceholder("Nom de l'établissement");
        specialtyFilter.setPlaceholder("Nom de la spécialité");
        semesterFilter.setPlaceholder("Semestre (ex. S1, S2)");

        searchButton.addClickListener(e -> updateGrid());
    }

    private void configureGrid() {
//        mobilityOfferGrid.setColumns("etablissement_id", "specialite", "semestre", "nb_places", "date_debut", "date_fin");
//        mobilityOfferGrid.getColumnByKey("etablissement_id").setHeader("Établissement");
//        mobilityOfferGrid.getColumnByKey("specialite").setHeader("Spécialité");
//        mobilityOfferGrid.getColumnByKey("semestre").setHeader("Semestre");
//        mobilityOfferGrid.getColumnByKey("nb_places").setHeader("Places Disponibles");
//        mobilityOfferGrid.getColumnByKey("date_debut").setHeader("Date de Début");
//        mobilityOfferGrid.getColumnByKey("date_fin").setHeader("Date de Fin");
        mobilityOfferGrid.setSizeFull();
    }

    private void updateGrid() {
        List<MobilityOffer> offers = mobilityOfferService.searchOffers(
                establishmentFilter.getValue(),
                specialtyFilter.getValue(),
                semesterFilter.getValue()
        );
        mobilityOfferGrid.setItems(offers);
    }
}