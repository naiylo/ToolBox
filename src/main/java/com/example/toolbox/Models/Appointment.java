package com.example.toolbox.Models;

import javafx.beans.property.*;
import java.time.LocalDate;

public class Appointment {
    private final ObjectProperty<LocalDate> date;
    private final StringProperty slot;
    private final StringProperty description;


    public Appointment(LocalDate date, String slot, String description) {
        this.date = new SimpleObjectProperty<>(this, "Date", date);
        this.slot = new SimpleStringProperty(this, "Timeslot", slot);
        this.description = new SimpleStringProperty(this, "Description", description);
    }

    public StringProperty descriptionProperty() {return this.description;}

    public StringProperty slotProperty() {return this.slot;}

    public ObjectProperty<LocalDate> localDateProperty() {return this.date;}

}
