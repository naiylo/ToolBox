package com.example.toolbox.Controllers.Client;

import com.example.toolbox.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
    public BorderPane client_parent;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().addListener((observableValue, oldVal, newVal) -> {
            switch(newVal) {
                case CALENDAR -> client_parent.setCenter(Model.getInstance().getViewFactory().getCalendarView());
                case PROFILE -> client_parent.setCenter(Model.getInstance().getViewFactory().getProfileView());
                case SETTINGS -> client_parent.setCenter(Model.getInstance().getViewFactory().getSettingsView());
                default -> client_parent.setCenter(Model.getInstance().getViewFactory().getHomeView());
            }

        });
    }
}
