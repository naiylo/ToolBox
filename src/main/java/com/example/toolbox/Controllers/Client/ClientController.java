package com.example.toolbox.Controllers.Client;

import com.example.toolbox.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
    public BorderPane client_parent;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Model.getInstance().getViewFactory().getClientSelectedMenuItem().addListener((observableValue, oldVal, newVal) -> {
                switch(newVal) {
                    case CALENDAR -> {
                        try {
                            client_parent.setCenter(Model.getInstance().getViewFactory().getCalendarView());
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    case PROFILE -> {
                        try {
                            client_parent.setCenter(Model.getInstance().getViewFactory().getProfileView());
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    case SETTINGS -> {
                        try {
                            client_parent.setCenter(Model.getInstance().getViewFactory().getSettingsView());
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    default -> {
                        try {
                            client_parent.setCenter(Model.getInstance().getViewFactory().getHomeView());
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

            });
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
