package com.example.toolbox.Controllers.Client;

import com.example.toolbox.Views.ClientMenuOptions;
import com.example.toolbox.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
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
        calendar_button.setOnAction(event -> onCalendar());
        home_button.setOnAction(event -> onHome());
        profile_button.setOnAction(event -> onProfile());
        settings_button.setOnAction(event -> onSettings());
    }

    private void onCalendar() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.CALENDAR);
    }

    private void onHome() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.HOME);
    }

    private void onProfile() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.PROFILE);
    }

    private void onSettings() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.SETTINGS);
    }
}
