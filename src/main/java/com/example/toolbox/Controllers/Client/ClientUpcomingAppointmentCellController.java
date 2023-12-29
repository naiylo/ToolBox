package com.example.toolbox.Controllers.Client;

import com.example.toolbox.Models.Appointment;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientUpcomingAppointmentCellController implements Initializable {
    public Label date_label;
    public Label description_label;
    public Label timeslot_label;

    private final Appointment appointment;

    public ClientUpcomingAppointmentCellController(Appointment appointment) {
        this.appointment = appointment;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
