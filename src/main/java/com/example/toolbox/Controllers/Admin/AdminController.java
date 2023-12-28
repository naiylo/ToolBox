package com.example.toolbox.Controllers.Admin;

import com.example.toolbox.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    public BorderPane admin_parent;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().addListener((observableValue, oldVal, newVal) -> {
            switch(newVal) {
                case CREATE_ACCOUNTS -> admin_parent.setCenter(Model.getInstance().getViewFactory().getCreateClientView());
                case DELETE_ACCOUNTS -> admin_parent.setCenter(Model.getInstance().getViewFactory().getDeleteClientView());
                default -> admin_parent.setCenter(Model.getInstance().getViewFactory().getProfilesView());
            }

        });
    }
}
