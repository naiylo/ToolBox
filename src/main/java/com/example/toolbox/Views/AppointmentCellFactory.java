package com.example.toolbox.Views;

import com.example.toolbox.Controllers.Client.ClientUpcomingAppointmentCellController;
import com.example.toolbox.Models.Appointment;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class AppointmentCellFactory extends ListCell<Appointment> {
    @Override
    protected void updateItem(Appointment appointment, boolean empty) {
        super.updateItem(appointment, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Fxml/Client/ClientUpcomingAppointmentCell.fxml"));
            ClientUpcomingAppointmentCellController controller = new ClientUpcomingAppointmentCellController(appointment);
            loader.setController(controller);
            setText(null);
            try {
                setGraphic(loader.load());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
