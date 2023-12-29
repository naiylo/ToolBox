package com.example.toolbox.Controllers.Admin;

import com.example.toolbox.Models.Client;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminProfilesCellController implements Initializable {
    public Label firstname_label;
    public Label lastname_label;
    public Label email_address_label;
    public Label join_date_label;
    public Button delete_button;

    private final Client client;

    public AdminProfilesCellController(Client client) {
        this.client = client;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
