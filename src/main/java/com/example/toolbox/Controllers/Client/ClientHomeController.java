package com.example.toolbox.Controllers.Client;

import com.example.toolbox.App;
import com.example.toolbox.Models.Appointment;
import com.example.toolbox.Models.Model;
import com.example.toolbox.Views.AppointmentCellFactory;
import javafx.beans.property.ListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;


import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ClientHomeController implements Initializable {
    public Label date_label;
    public Button student_calendar_find_button;
    public Label welcome_label;
    public ListView<Appointment> upcoming_listView;
    public AnchorPane root_panel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            initializeUpcoming_ListView(Model.getInstance().getClient().appointmentListProperty());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void initializeUpcoming_ListView(ListProperty<Appointment> appointments) {
        upcoming_listView.setCellFactory(new AppointmentCellFactory());
        upcoming_listView.setItems(appointments);
    }
}
