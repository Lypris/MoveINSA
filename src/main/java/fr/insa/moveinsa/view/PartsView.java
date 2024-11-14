package fr.insa.moveinsa.view;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import fr.insa.moveinsa.view.components.GoogleMapComponent;
import jakarta.annotation.security.RolesAllowed;

@Route(value = "/parts", layout = MainLayout.class)
@PageTitle("Parts | MoveINSA")
@AnonymousAllowed
public class PartsView extends VerticalLayout {
    private GoogleMapComponent map;

    public PartsView() {
        this.setSizeFull();
        this.setId("dashboard-view");
        String apikey = "AIzaSyB-PS3i95SbI5UDj-W7Y5DUECSySELZGw4";
        map = new GoogleMapComponent(apikey);
        map.setSizeFull();
        this.add(map);
    }
}
