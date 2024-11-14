package fr.insa.moveinsa.view.admin;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import fr.insa.moveinsa.view.MainLayout;
import jakarta.annotation.security.RolesAllowed;

@Route(value = "admin/students", layout = MainLayout.class)
@PageTitle("Students | MoveINSA")
@RolesAllowed("ADMIN")
public class StudentsView extends VerticalLayout {
    public StudentsView() {
        this.setSizeFull();
        this.setId("students-view");
    }
}
