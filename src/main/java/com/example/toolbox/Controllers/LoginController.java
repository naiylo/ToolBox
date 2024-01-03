package com.example.toolbox.Controllers;

import com.example.toolbox.Views.AccountType;
import com.example.toolbox.Models.Model;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public ChoiceBox<AccountType> account_selector;
    public PasswordField password_field;
    public TextField email_address_field;
    public Label error_label;
    public Button login_button;
    public Label email_address_label;
    public Label password_label;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        account_selector.setItems(FXCollections.observableArrayList(AccountType.CLIENT,AccountType.ADMIN));
        account_selector.setValue(Model.getInstance().getViewFactory().getLoginAccountType());
        account_selector.valueProperty().addListener(observable -> Model.getInstance().getViewFactory().setLoginAccountType(account_selector.getValue()));
        login_button.setOnAction(event -> onLogin());
    }

    private void onLogin() {
        Stage stage = (Stage) error_label.getScene().getWindow();
        if (Model.getInstance().getViewFactory().getLoginAccountType() == AccountType.CLIENT) {
            // Evaluate Client Login Credentials
            Model.getInstance().evaluateClientCredentials(email_address_field.getText(), password_field.getText());
            if (Model.getInstance().getClientLoginSuccessFlag()) {
                Model.getInstance().getViewFactory().showClientWindow();
                // Close the Login Stage
                Model.getInstance().getViewFactory().closeStage(stage);
            } else {
                error_label.setVisible(true);
                email_address_field.setText("");
                password_field.setText("");
                error_label.setText("No such login credentials found!");
            }
        } else {
            Model.getInstance().getViewFactory().showAdminWindow();
        }
    }
}
