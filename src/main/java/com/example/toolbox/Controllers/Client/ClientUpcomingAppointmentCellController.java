package com.example.toolbox.Controllers.Client;

import com.example.toolbox.Models.Appointment;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientUpcomingAppointmentCellController extends ListCell<Appointment> {
    public Label date_label;
    public Label description_label;
    public Label timeslot_label;

    public ClientUpcomingAppointmentCellController() {
        loadFXML();
    }

    public void loadFXML() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Client/ClientUpcomingAppointmentCell.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
            setText(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void updateItem(Appointment appointment, boolean empty) {
        super.updateItem(appointment, empty);
        if (empty || appointment == null) {
            setText(null);
            setContentDisplay(ContentDisplay.TEXT_ONLY);
        } else {
            this.date_label.setText(appointment.localDateProperty().toString());
            this.description_label.setText(appointment.descriptionProperty().getValue());
            this.timeslot_label.setText(appointment.slotProperty().getValue());
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        }
    }
}


