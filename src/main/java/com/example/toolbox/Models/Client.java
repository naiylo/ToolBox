package com.example.toolbox.Models;

import javafx.beans.property.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.time.LocalDate;
import com.example.toolbox.Models.Appointment;
import javafx.collections.FXCollections;

public class Client {

    private final StringProperty firstname;
    private final StringProperty lastname;
    private final StringProperty email_address;
    private final ObjectProperty<LocalDate> date;
    private final StringProperty password;
    private final ListProperty<Appointment> appointmentList;

    public Client(String firstname, String lastname, String email_Address, String password, LocalDate date, ResultSet appointments) throws SQLException {
        this.firstname = new SimpleStringProperty(this, "Firstname", firstname);
        this.lastname = new SimpleStringProperty(this, "Lastname", lastname);
        this.email_address = new SimpleStringProperty(this, "Email-Address", email_Address);
        this.password = new SimpleStringProperty(this, "Password", password);
        this.date = new SimpleObjectProperty<>(this, "Date", date);
        this.appointmentList = new SimpleListProperty<Appointment>(this, "AppointmentList", FXCollections.observableArrayList());
    }

    public StringProperty firstnameProperty() {return this.firstname;}
    public StringProperty lastnameProperty() {return this.lastname;}
    public StringProperty email_addressProperty() {return this.email_address;}
    public StringProperty passwordProperty() {return this.password;}
    public ObjectProperty<LocalDate> localDateProperty() {return this.date;}
    public ListProperty<Appointment> appointmentListProperty() {return this.appointmentList;}

    public void addAppointment(Appointment appointment) {
        this.appointmentList.add(appointment);
    }
}
