package com.example.toolbox.Views;

import com.example.toolbox.Controllers.Client.ClientUpcomingAppointmentCellController;
import com.example.toolbox.Models.Appointment;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class AppointmentCellFactory implements Callback<ListView<Appointment>, ListCell<Appointment>> {

    @Override
    public ListCell<Appointment> call(ListView<Appointment> appointmentListView) {
        return new ClientUpcomingAppointmentCellController();
    }
}
