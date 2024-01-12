package com.example.toolbox.Controllers.Client;

import com.example.toolbox.Views.ClientMenuOptions;
import com.example.toolbox.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ClientMenuController implements Initializable {
    public Button home_button;
    public Button calendar_button;
    public Button settings_button;
    public Button profile_button;
    public Button logout_button;
    public Label report_Label;
    public Button report_button;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }
    private void addListeners() {
        calendar_button.setOnAction(event -> {
            try {
                onCalendar();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        home_button.setOnAction(event -> {
            try {
                onHome();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        profile_button.setOnAction(event -> {
            try {
                onProfile();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        settings_button.setOnAction(event -> {
            try {
                onSettings();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void onCalendar() throws SQLException {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.CALENDAR);
    }

    private void onHome() throws SQLException {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.HOME);
    }

    private void onProfile() throws SQLException {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.PROFILE);
    }

    private void onSettings() throws SQLException {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.SETTINGS);
    }
}
