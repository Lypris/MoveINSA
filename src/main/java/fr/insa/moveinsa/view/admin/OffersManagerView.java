package fr.insa.moveinsa.view.admin;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import fr.insa.moveinsa.data.entity.Establishment;
import fr.insa.moveinsa.data.entity.MobilityOffer;
import fr.insa.moveinsa.data.service.EtablissementService;
import fr.insa.moveinsa.data.service.MobilityOfferService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route("admin/offers")
@RolesAllowed("ADMIN")
public class OffersManagerView extends VerticalLayout {

    private final MobilityOfferService mobilityOfferService;
    private final EtablissementService etablissementService;

    private Grid<MobilityOffer> offerGrid = new Grid<>(MobilityOffer.class);
    private Grid<Establishment> establishmentGrid = new Grid<>(Establishment.class);
    private Binder<MobilityOffer> offerBinder = new Binder<>(MobilityOffer.class);
    private Binder<Establishment> establishmentBinder = new Binder<>(Establishment.class);

    // Form fields for offers
    private TextField specialtyField = new TextField("Spécialité");
    private TextField semesterField = new TextField("Semestre");
    private TextField availablePlacesField = new TextField("Nombre de places");
    private TextField establishmentField = new TextField("Établissement");
    private DateTimePicker startDateField = new DateTimePicker("Date de début");
    private DateTimePicker endDateField = new DateTimePicker("Date de fin");

    // Form fields for establishments
    private TextField establishmentNameField = new TextField("Nom de l'établissement");
    private TextField establishmentCountryField = new TextField("Pays");
    private TextField establishmentCityField = new TextField("Ville");
    private TextField establishmentAddressField = new TextField("Adresse");
    private TextField establishmentUrlField = new TextField("URL du site web");

    private MobilityOffer selectedOffer;
    private Establishment selectedEstablishment;

    @Autowired
    public OffersManagerView(MobilityOfferService mobilityOfferService, EtablissementService etablissementService) {
        this.mobilityOfferService = mobilityOfferService;
        this.etablissementService = etablissementService;

        add(new H2("Manage Mobility Offers & Establishments"));

        // Configure the grids and the forms
        configureOfferGrid();
        configureEstablishmentGrid();
        configureForms();

        // Layout for offer form
        HorizontalLayout offerFormLayout = new HorizontalLayout(
                specialtyField, semesterField, availablePlacesField, establishmentField, startDateField, endDateField);
        Button saveOfferButton = new Button("Save Offer", e -> saveOffer());
        Button clearOfferButton = new Button("Clear Offer", e -> clearOfferForm());
        offerFormLayout.add(saveOfferButton, clearOfferButton);

        // Layout for establishment form
        HorizontalLayout establishmentFormLayout = new HorizontalLayout(establishmentNameField, establishmentCountryField);
        Button saveEtablissementButton = new Button("Save Establishment", e -> saveEtablissement());
        Button clearEtablissementButton = new Button("Clear Establishment", e -> clearEtablissementForm());
        establishmentFormLayout.add(saveEtablissementButton, clearEtablissementButton);

        add(offerFormLayout, offerGrid, establishmentFormLayout, establishmentGrid);
        updateOfferList();
        updateEtablissementList();
    }

    private void configureOfferGrid() {
        offerGrid.addClassName("offer-grid");
        offerGrid.setSizeFull();

        offerGrid.setColumns("establishment.name", "specialty", "semester", "availablePlaces", "startDate", "endDate");
        offerGrid.addColumn(offer -> offer.getEstablishment().getName()).setHeader("Établissement");

        offerGrid.getColumnByKey("establishment.name").setHeader("Établissement");
        offerGrid.getColumnByKey("specialty").setHeader("Spécialité");
        offerGrid.getColumnByKey("semester").setHeader("Semestre");
        offerGrid.getColumnByKey("availablePlaces").setHeader("Places Disponibles");
        offerGrid.getColumnByKey("startDate").setHeader("Date de Début");
        offerGrid.getColumnByKey("endDate").setHeader("Date de Fin");

        offerGrid.addComponentColumn(offer -> createEditOfferButton(offer)).setHeader("Actions");

        offerGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        offerGrid.setSelectionMode(Grid.SelectionMode.SINGLE);
        offerGrid.asSingleSelect().addValueChangeListener(event -> editOffer(event.getValue()));
    }

    private void configureEstablishmentGrid() {
        establishmentGrid.addClassName("etablissement-grid");
        establishmentGrid.setSizeFull();

        establishmentGrid.setColumns("name", "country");
        establishmentGrid.getColumnByKey("name").setHeader("Nom de l'établissement");
        establishmentGrid.getColumnByKey("country").setHeader("Pays");

        establishmentGrid.addComponentColumn(establishment -> createEditEtablissementButton(establishment))
                .setHeader("Actions");

        establishmentGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        establishmentGrid.setSelectionMode(Grid.SelectionMode.SINGLE);
        establishmentGrid.asSingleSelect().addValueChangeListener(event -> editEtablissement(event.getValue()));
    }

    private void configureForms() {
        offerBinder.bindInstanceFields(this);
        establishmentBinder.bindInstanceFields(this);

        availablePlacesField.setValueChangeMode(ValueChangeMode.EAGER);
    }

    private void saveOffer() {
        if (selectedOffer == null) {
            selectedOffer = new MobilityOffer();
        }

        // Bind form fields to the offer entity
        offerBinder.writeBeanIfValid(selectedOffer);

        // Find the selected establishment by name
        Establishment establishment = etablissementService.findByName(establishmentField.getValue());
        if (establishment != null) {
            selectedOffer.setEstablishment(establishment);
        }

        mobilityOfferService.save(selectedOffer);
        updateOfferList();
        clearOfferForm();
        Notification.show("Offer saved successfully", 3000, Notification.Position.BOTTOM_START);
    }

    private void saveEtablissement() {
        if (selectedEstablishment == null) {
            selectedEstablishment = new Establishment();
        }

        establishmentBinder.writeBeanIfValid(selectedEstablishment);
        etablissementService.save(selectedEstablishment);
        updateEtablissementList();
        clearEtablissementForm();
        Notification.show("Establishment saved successfully", 3000, Notification.Position.BOTTOM_START);
    }

    private void editOffer(MobilityOffer offer) {
        if (offer != null) {
            selectedOffer = offer;
            offerBinder.readBean(offer);
        } else {
            clearOfferForm();
        }
    }

    private void editEtablissement(Establishment establishment) {
        if (establishment != null) {
            selectedEstablishment = establishment;
            establishmentBinder.readBean(establishment);
        } else {
            clearEtablissementForm();
        }
    }

    private void clearOfferForm() {
        selectedOffer = null;
        offerBinder.readBean(null);
        establishmentField.clear();
    }

    private void clearEtablissementForm() {
        selectedEstablishment = null;
        establishmentBinder.readBean(null);
    }

    private void updateOfferList() {
        List<MobilityOffer> offers = mobilityOfferService.findAll();
        offerGrid.setItems(offers);
    }

    private void updateEtablissementList() {
        List<Establishment> establishments = etablissementService.findAll();
        establishmentGrid.setItems(establishments);
    }

    private Button createEditOfferButton(MobilityOffer offer) {
        Button editButton = new Button("Edit", click -> editOffer(offer));
        editButton.getElement().setAttribute("theme", "primary");
        return editButton;
    }

    private Button createEditEtablissementButton(Establishment establishment) {
        Button editButton = new Button("Edit", click -> editEtablissement(establishment));
        editButton.getElement().setAttribute("theme", "primary");
        return editButton;
    }
}