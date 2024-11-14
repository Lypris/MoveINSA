package fr.insa.moveinsa.view;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import jakarta.annotation.security.RolesAllowed;

@Route(value = "/stats", layout = MainLayout.class)
@PageTitle("Stats | MoveINSA")
@AnonymousAllowed
public class StatsView extends VerticalLayout {

    public StatsView() {
        this.setSizeFull();
        this.setId("stats-view");
    }
}
