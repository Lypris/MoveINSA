package fr.insa.moveinsa.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.Lumo;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.component.Component;
import fr.insa.moveinsa.view.admin.ApplicationsReviewView;
import fr.insa.moveinsa.view.admin.OffersManagerView;
import fr.insa.moveinsa.view.admin.StudentsView;
import fr.insa.moveinsa.view.admin.UserManagementView;
import fr.insa.moveinsa.view.student.ApplicationsView;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@PageTitle("Main")
public class MainLayout extends AppLayout {

    public MainLayout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        createHeader(authorities);
        createDrawer(authorities);
        this.setId("main-layout");
    }

    private void createHeader(Collection<? extends GrantedAuthority> authorities) {
        H1 logo = new H1("MoveINSA");
        logo.addClassNames(
                LumoUtility.FontSize.LARGE,
                LumoUtility.Margin.MEDIUM);

        var themeToggle = new Checkbox("Mode sombre");
        themeToggle.addValueChangeListener(e -> {
            setTheme(e.getValue());
        });

        Button logoutButton = new Button("Sign Out", new Icon(VaadinIcon.SIGN_OUT));
        logoutButton.addClickListener(e -> {
            UI.getCurrent().navigate(LogoutView.class);
        });
        logoutButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        logoutButton.addClassNames(
                LumoUtility.Margin.Left.AUTO,
                LumoUtility.Padding.Horizontal.MEDIUM
        );

        // login button
        Button loginButton = new Button("Sign In", new Icon(VaadinIcon.SIGN_IN));
        loginButton.addClickListener(e -> {
            UI.getCurrent().navigate(LoginView.class);
        });
        loginButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        loginButton.addClassNames(
                LumoUtility.Margin.Left.AUTO,
                LumoUtility.Padding.Horizontal.MEDIUM
        );

        var header = new HorizontalLayout(new DrawerToggle(), logo, themeToggle);
        if(hasRole(authorities, "ADMIN") || hasRole(authorities, "STUDENT") || hasRole(authorities, "PARTNER")) {
            header.add(logoutButton);
        } else {
            header.add(loginButton);
        }

        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.expand(logo);
        header.setWidthFull();
        header.addClassNames(LumoUtility.Padding.Vertical.NONE, LumoUtility.Padding.Horizontal.MEDIUM);
        addToNavbar(header);
    }

    public void setTheme(boolean dark) {
        var js = "document.documentElement.setAttribute('theme', $0)";
        getElement().executeJs(js, dark ? Lumo.DARK : Lumo.LIGHT);
    }

    private void createDrawer(Collection<? extends GrantedAuthority> authorities) {
        List<Tab> tabs = new ArrayList<>();

        // Dashboard is visible to all authenticated users
        tabs.add(createTab(VaadinIcon.HOME, "Dashboard", DashboardView.class));
        tabs.add(createTab(VaadinIcon.ACADEMY_CAP, "Parts", PartsView.class));
        tabs.add(createTab(VaadinIcon.CHART, "Stats", StatsView.class));

        // Add role-specific tabs
        if (hasRole(authorities, "ADMIN")) {
            tabs.add(createTab(VaadinIcon.USER, "Students", StudentsView.class));
            tabs.add(createTab(VaadinIcon.BUILDING, "Offers", OffersManagerView.class));
            tabs.add(createTab(VaadinIcon.USERS, "User Management", UserManagementView.class));
            tabs.add(createTab(VaadinIcon.EDIT, "Applications Review", ApplicationsReviewView.class));
        }

        if (hasRole(authorities, "STUDENT")) {
            tabs.add(createTab(VaadinIcon.EDIT, "My Applications", ApplicationsView.class));
            tabs.add(createTab(VaadinIcon.BUILDING, "Available Offers", MobilityOffersView.class));
        }

        Tabs tabsComponent = new Tabs(tabs.toArray(new Tab[0]));
        tabsComponent.setOrientation(Tabs.Orientation.VERTICAL);
        tabsComponent.setFlexGrowForEnclosedTabs(1);
        tabsComponent.setId("tabs");
        addToDrawer(tabsComponent);
    }

    private boolean hasRole(Collection<? extends GrantedAuthority> authorities, String role) {
        return authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(authority -> authority.equals("ROLE_" + role));
    }

    private Tab createTab(VaadinIcon icon, String title, Class<? extends Component> viewClass) {
        Icon vaadinIcon = icon.create();
        vaadinIcon.getStyle().set("box-sizing", "border-box")
                .set("margin-inline-end", "var(--lumo-space-m)")
                .set("margin-inline-start", "var(--lumo-space-xs)")
                .set("padding", "var(--lumo-space-xs)");

        RouterLink link = new RouterLink();
        link.add(vaadinIcon, new Span(title));
        link.setRoute(viewClass);
        link.setTabIndex(-1);

        return new Tab(link);
    }

}