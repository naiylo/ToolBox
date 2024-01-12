package com.example.toolbox.Controllers.Admin;

import com.example.toolbox.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    public BorderPane admin_parent;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Model.getInstance().getViewFactory().getAdminSelectedMenuItem().addListener((observableValue, oldVal, newVal) -> {
                switch(newVal) {
                    case CREATE_ACCOUNTS -> {
                        try {
                            admin_parent.setCenter(Model.getInstance().getViewFactory().getCreateClientView());
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    case DELETE_ACCOUNTS -> {
                        try {
                            admin_parent.setCenter(Model.getInstance().getViewFactory().getDeleteClientView());
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    default -> {
                        try {
                            admin_parent.setCenter(Model.getInstance().getViewFactory().getProfilesView());
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
