// StudentsView.java
package fr.insa.moveinsa.view.admin;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import fr.insa.moveinsa.data.entity.Student;
import fr.insa.moveinsa.data.service.StudentService;
import fr.insa.moveinsa.view.MainLayout;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "admin/students", layout = MainLayout.class)
@PageTitle("Students | MoveINSA")
@RolesAllowed("ADMIN")
public class StudentsView extends VerticalLayout {
    private final StudentService studentService;
    private final Grid<Student> studentGrid = new Grid<>(Student.class);
    private final StudentForm studentForm;

    @Autowired
    public StudentsView(StudentService studentService) {
        this.studentService = studentService;
        this.studentForm = new StudentForm(this, studentService);

        addClassName("students-view");
        setSizeFull();

        configureGrid();
        configureForm();

        add(getToolbar(), studentGrid, studentForm);
        updateList();
        closeEditor();
    }

    private void configureGrid() {
        studentGrid.addClassName("student-grid");
        studentGrid.setSizeFull();
        studentGrid.setColumns("nom", "prenom", "email", "specialite", "classement");
        studentGrid.getColumns().forEach(col -> col.setAutoWidth(true));

        studentGrid.asSingleSelect().addValueChangeListener(event -> editStudent(event.getValue()));
    }

    private HorizontalLayout getToolbar() {
        Button addStudentButton = new Button("+", click -> addStudent());
        HorizontalLayout toolbar = new HorizontalLayout(addStudentButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void configureForm() {
        studentForm.setWidth("25em");
    }

    public void updateList() {
        studentGrid.setItems(studentService.findAll());
    }

    public void closeEditor() {
        studentForm.setStudent(null);
        studentForm.setVisible(false);
        removeClassName("editing");
    }

    private void addStudent() {
        studentGrid.asSingleSelect().clear();
        editStudent(new Student());
    }

    private void editStudent(Student student) {
        if (student == null) {
            closeEditor();
        } else {
            studentForm.setStudent(student);
            studentForm.setVisible(true);
            addClassName("editing");
        }
    }
}
