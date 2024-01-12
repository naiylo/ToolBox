package com.example.toolbox.Controllers.Admin;

import com.example.toolbox.Views.AdminMenuOptions;
import com.example.toolbox.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.SQLException;
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
        profiles_button.setOnAction(event -> {
            try {
                onProfiles();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        create_account_button.setOnAction(event -> {
            try {
                onCreateAccounts();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        delete_account_button.setOnAction(event -> {
            try {
                onDeleteAccounts();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void onDeleteAccounts() throws SQLException {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.DELETE_ACCOUNTS);
    }

    private void onProfiles() throws SQLException {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.PROFILES);
    }

    private void onCreateAccounts() throws SQLException {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.CREATE_ACCOUNTS);
    }
}
