package fr.insa.moveinsa.view;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;

@Route(value = "", layout = MainLayout.class)
@PageTitle("Dashboard | MoveINSA")
public class DashboardView extends VerticalLayout {
    public DashboardView() {
        this.setSizeFull();
        this.setId("dashboard-view");

    }
}
