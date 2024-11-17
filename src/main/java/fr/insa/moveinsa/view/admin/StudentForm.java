// StudentForm.java
package fr.insa.moveinsa.view.admin;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.binder.Validator;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.validator.*;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.component.notification.Notification;
import fr.insa.moveinsa.data.entity.Student;
import fr.insa.moveinsa.data.service.StudentService;

public class StudentForm extends FormLayout {
    private final StudentsView studentsView;
    private final StudentService studentService;
    private Student student;

    private final TextField nom = new TextField("Nom");
    private final TextField prenom = new TextField("Prénom");
    private final TextField email = new TextField("Email");
    private final TextField specialite = new TextField("Spécialité");
    private final NumberField classement = new NumberField("Classement");
    private final Binder<Student> binder = new Binder<>(Student.class);

    public StudentForm(StudentsView studentsView, StudentService studentService) {
        this.studentsView = studentsView;
        this.studentService = studentService;

        addClassName("student-form");

        binder.forField(nom)
                .asRequired("Nom is required")
                .bind(Student::getNom, Student::setNom);
        binder.forField(prenom)
                .asRequired("Prénom is required")
                .bind(Student::getPrenom, Student::setPrenom);
        binder.forField(email)
                .asRequired("Email is required")
                .withValidator(new EmailValidator("Invalid email address"))
                .bind(Student::getEmail, Student::setEmail);
        binder.forField(specialite)
                .asRequired("Spécialité is required")
                .bind(Student::getSpecialite, Student::setSpecialite);
        binder.forField(classement)
                .asRequired("Classement is required")
                .withValidator(new DoubleRangeValidator("Invalid classement", 0.0, 10000.0))
                .bind(Student::getClassement, Student::setClassement);

        add(nom, prenom, email, specialite, classement, createButtonsLayout());
    }

    public void setStudent(Student student) {
        this.student = student;
        binder.readBean(student);
    }

    private HorizontalLayout createButtonsLayout() {
        Button saveButton = new Button("Enregistrer", click -> save());
        Button deleteButton = new Button("Supprimer", click -> delete());
        Button cancelButton = new Button("Annuler", click -> cancel());

        return new HorizontalLayout(saveButton, deleteButton, cancelButton);
    }

    private void save() {
        try {
            binder.writeBean(student);
            studentService.save(student);
            studentsView.updateList();
            studentsView.closeEditor();
            Notification.show("Student saved");
        } catch (ValidationException e) {
            Notification.show("An error occurred while saving the student");
        }
    }

    private void delete() {
        studentService.delete(student);
        studentsView.updateList();
        studentsView.closeEditor();
        Notification.show("Student deleted");
    }

    private void cancel() {
        studentsView.closeEditor();
    }
}