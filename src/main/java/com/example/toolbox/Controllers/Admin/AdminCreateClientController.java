package com.example.toolbox.Controllers.Admin;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminCreateClientController implements Initializable {
    public TextField first_name_textfield;
    public TextField last_name_textfield;
    public TextField email_textfield;
    public TextField password_textfield;
    public CheckBox admin_checkbox;
    public Button create_new_account_button;
    public Label error_label;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
