package fr.insa.moveinsa.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteConfiguration;
import com.vaadin.flow.server.VaadinServletRequest;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.component.html.Div;

@Route("logout")
@AnonymousAllowed
public class LogoutView extends VerticalLayout {

    public LogoutView() {
        // Configure layout
        setSizeFull();
        setAlignItems(FlexComponent.Alignment.CENTER);
        setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        addClassNames(
                LumoUtility.Padding.LARGE,
                LumoUtility.Background.BASE
        );

        // Create card container
        Div card = new Div();
        card.addClassNames(
                LumoUtility.Background.CONTRAST_5,
                LumoUtility.BorderRadius.LARGE,
                LumoUtility.Padding.LARGE,
                LumoUtility.BoxShadow.MEDIUM
        );
        card.setWidth("400px");

        // Add logo/icon
        Icon logoutIcon = VaadinIcon.SIGN_OUT.create();
        logoutIcon.setSize("50px");
        logoutIcon.setColor("var(--lumo-primary-color)");

        // Add heading
        H2 title = new H2("Sign Out");
        title.addClassNames(
                LumoUtility.TextAlignment.CENTER,
                LumoUtility.Margin.Vertical.MEDIUM
        );

        // Add message
        Paragraph message = new Paragraph("Are you sure you want to sign out?");
        message.addClassNames(
                LumoUtility.TextColor.SECONDARY,
                LumoUtility.TextAlignment.CENTER,
                LumoUtility.Margin.Bottom.LARGE
        );

        // Create buttons
        Button cancelButton = new Button("Cancel", e -> {
            // Navigate back to the main view
            UI.getCurrent().navigate("");
        });
        cancelButton.addClassNames(
                LumoUtility.Margin.Right.SMALL
        );

        Button logoutButton = new Button("Sign Out", e -> {
            // Perform logout
            SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
            logoutHandler.logout(
                    VaadinServletRequest.getCurrent().getHttpServletRequest(),
                    null,
                    null
            );

            // Redirect to home page
            UI.getCurrent().getPage().setLocation("/");
        });
        logoutButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        logoutButton.getElement().getThemeList().add("error");

        // Create button container
        Div buttonContainer = new Div(cancelButton, logoutButton);
        buttonContainer.addClassNames(
                LumoUtility.Display.FLEX,
                LumoUtility.JustifyContent.CENTER,
                LumoUtility.Gap.MEDIUM
        );

        // Add components to card
        card.add(
                logoutIcon,
                title,
                message,
                buttonContainer
        );

        // Center icon
        logoutIcon.getElement().getStyle()
                .set("display", "block")
                .set("margin", "0 auto");

        // Add card to layout
        add(card);

        // Add some spacing at the bottom
        setSpacing(true);
    }
}
