package fr.insa.moveinsa.view.admin;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
@Route("admin/applications-review")
@RolesAllowed("ADMIN")
public class ApplicationsReviewView extends Component {
}
