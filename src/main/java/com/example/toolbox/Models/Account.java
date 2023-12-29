package com.example.toolbox.Models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class Account {
    private final StringProperty owner;
    private final StringProperty accountNumber;

    public Account(String owner, String accountNumber) {
        this.owner = new SimpleStringProperty(this, "Owner", owner);
        this.accountNumber = new SimpleStringProperty(this, "Account Number", accountNumber);
    }

    public StringProperty ownerProperty() {return this.owner;}

    public StringProperty accountNumberProperty() {return this.accountNumber;}

}
