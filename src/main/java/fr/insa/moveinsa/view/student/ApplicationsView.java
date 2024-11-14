package fr.insa.moveinsa.view.student;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import fr.insa.moveinsa.view.MainLayout;
import jakarta.annotation.security.RolesAllowed;

@Route(value = "applications", layout = MainLayout.class)
@PageTitle("Applications | MoveINSA")
@RolesAllowed("STUDENT")
public class ApplicationsView extends VerticalLayout {

    public ApplicationsView() {
        this.setSizeFull();
        this.setId("applications-view");
    }
}
