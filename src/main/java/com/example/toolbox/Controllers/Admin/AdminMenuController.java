package com.example.toolbox.Controllers.Admin;

import com.example.toolbox.Views.AdminMenuOptions;
import com.example.toolbox.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminMenuController implements Initializable {
    public Button profiles_button;
    public Button create_account_button;
    public Button delete_account_button;
    public Button settings_button;
    public Button logout_button;
    public Label report_Label;
    public Button report_button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    private void addListeners() {
        profiles_button.setOnAction(event -> onProfiles());
        create_account_button.setOnAction(event -> onCreateAccounts());
        delete_account_button.setOnAction(event -> onDeleteAccounts());
    }

    private void onDeleteAccounts() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.DELETE_ACCOUNTS);
    }

    private void onProfiles() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.PROFILES);
    }

    private void onCreateAccounts() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.CREATE_ACCOUNTS);
    }
}
