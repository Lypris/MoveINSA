package fr.insa.moveinsa.view;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.Theme;
import fr.insa.moveinsa.view.components.GoogleMapComponent;
import org.springframework.security.access.annotation.Secured;

@Route(value = "", layout = MainLayout.class)
@PageTitle("Dashboard | MoveINSA")
@AnonymousAllowed
public class DashboardView extends VerticalLayout {

    public DashboardView() {
        // Contenu principal
        H1 title = new H1("Bienvenue sur MoveINSA");
        H2 subtitle = new H2("Facilitez votre mobilité internationale");

        Paragraph description = new Paragraph(
                "Explorez les opportunités de mobilité internationale offertes par l'INSA de Strasbourg : Erasmus, Double-Diplôme, et Hors-Erasmus."
        );

        // Sections des dispositifs de mobilité
        add(title, subtitle, description, createMobilityOptions());

        // Mise en forme
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setPadding(true);
        setSpacing(true);
    }
    // Méthode pour créer la section des dispositifs de mobilité
    private Div createMobilityOptions() {
        Div mobilityContainer = new Div();

        // Options de mobilité avec descriptions
        VerticalLayout erasmusOption = createMobilityOption(
                "Erasmus",
                "Opportunité de mobilité en Europe pour un semestre ou une année académique.",
                "en savoir plus",
                "partenaires?dispositif=erasmus"
        );

        VerticalLayout doubleDegreeOption = createMobilityOption(
                "Double-Diplôme",
                "Programme permettant de décrocher un double diplôme avec un partenaire international.",
                "en savoir plus",
                "partenaires?dispositif=double-diplome"
        );

        VerticalLayout otherOption = createMobilityOption(
                "Hors-Erasmus",
                "Stages, projets de fin d'études, et autres opportunités de mobilité en dehors de l'Europe.",
                "en savoir plus",
                "partenaires?dispositif=hors-erasmus"
        );

        HorizontalLayout optionsLayout = new HorizontalLayout(erasmusOption, doubleDegreeOption, otherOption);
        optionsLayout.setSpacing(true);
        optionsLayout.setJustifyContentMode(JustifyContentMode.CENTER);

        mobilityContainer.add(optionsLayout);
        mobilityContainer.addClassName("mobility-container");

        return mobilityContainer;
    }

    // Méthode pour créer un composant de dispositif de mobilité
    private VerticalLayout createMobilityOption(String title, String description, String buttonText, String navigationTarget) {
        VerticalLayout layout = new VerticalLayout();

        H2 optionTitle = new H2(title);
        Paragraph optionDescription = new Paragraph(description);
        Button learnMoreButton = new Button(buttonText, e -> getUI().ifPresent(ui -> ui.navigate(navigationTarget)));

        layout.add(optionTitle, optionDescription, learnMoreButton);
        layout.setPadding(true);
        layout.setSpacing(true);
        layout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        layout.addClassName("mobility-option");

        return layout;
    }

}