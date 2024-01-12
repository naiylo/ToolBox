package com.example.toolbox.Controllers.Client;

import com.example.toolbox.Models.Model;
import javafx.beans.property.StringProperty;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ClientProfileController implements Initializable {
    public Label name_label;
    public Label email_label;
    public Label password_label;
    public Button change_profile_button;
    public Button delete_profile_button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        StringProperty password = null;
        try {
            password = Model.getInstance().getClient().passwordProperty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        StringProperty firstName = null;
        try {
            firstName = Model.getInstance().getClient().firstnameProperty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        StringProperty lastname = null;
        try {
            lastname = Model.getInstance().getClient().lastnameProperty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        StringProperty email_address = null;
        try {
            email_address = Model.getInstance().getClient().email_addressProperty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        name_label.setText(firstName.getValue() + " " + lastname.getValue());
        email_label.setText(email_address.getValue());
        password_label.setText(password.getValue());
    }
}
