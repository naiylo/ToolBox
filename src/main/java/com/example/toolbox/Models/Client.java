package com.example.toolbox.Models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class Client {

    private final StringProperty firstname;
    private final StringProperty lastname;
    private final StringProperty email_address;
    private final ObjectProperty<LocalDate> date;

    public Client(String firstname, String lastname, String email_Address, LocalDate date) {
        this.firstname = new SimpleStringProperty(this, "Firstname", firstname);
        this.lastname = new SimpleStringProperty(this, "Lastname", lastname);
        this.email_address = new SimpleStringProperty(this, "Email-Address", email_Address);
        this.date = new SimpleObjectProperty<>(this, "Date", date);
    }

    public StringProperty firstnameProperty() {return this.firstname;}
    public StringProperty lastnameProperty() {return this.lastname;}
    public StringProperty email_addressProperty() {return this.email_address;}
    public ObjectProperty<LocalDate> localDateProperty() {return this.date;}
}
