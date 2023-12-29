package com.example.toolbox.Views;

import com.example.toolbox.Controllers.Admin.AdminProfilesCellController;
import com.example.toolbox.Models.Client;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class ProfilesCellFactory extends ListCell<Client> {
    @Override
    protected void updateItem(Client client, boolean empty) {
        super.updateItem(client, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Fxml/Admin/AdminProfilesCell.fxml"));
            AdminProfilesCellController controller = new AdminProfilesCellController(client);
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
