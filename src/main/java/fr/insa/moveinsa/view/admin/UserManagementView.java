package fr.insa.moveinsa.view.admin;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;

@Route("admin/user-management")
@RolesAllowed("ADMIN")
public class UserManagementView extends VerticalLayout {

    public UserManagementView() {
        add(createUserForm());
    }

    private Component createUserForm() {
        return new VerticalLayout();
    }
}
