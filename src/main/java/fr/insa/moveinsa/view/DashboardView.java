package fr.insa.moveinsa.view;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = MainLayout.class)
@PageTitle("Dashboard | Factory Manager")
public class DashboardView extends VerticalLayout {
    public DashboardView() {
        this.setSizeFull();
        this.setId("dashboard-view");

    }
}
