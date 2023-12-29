package com.example.toolbox.Views;

import com.example.toolbox.Controllers.Admin.AdminController;
import com.example.toolbox.Controllers.Client.ClientController;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewFactory {

    private AccountType loginAccountType;

    // Client Views
    private final ObjectProperty<ClientMenuOptions> clientSelectedMenuItem;
    private AnchorPane homeView;
    private AnchorPane calendarView;
    private AnchorPane profileView;
    private AnchorPane settingsView;

    // Admin Views
    private final SimpleObjectProperty<AdminMenuOptions> adminSelectedMenuItem;
    private AnchorPane profilesView;
    private AnchorPane createClientView;
    private AnchorPane deleteClientView;


    public ViewFactory() {
        this.loginAccountType = AccountType.CLIENT;
        this.clientSelectedMenuItem = new SimpleObjectProperty<>();
        this.adminSelectedMenuItem = new SimpleObjectProperty<>();
    }

    public AccountType getLoginAccountType() {
        return loginAccountType;
    }

    public void setLoginAccountType(AccountType loginAccountType) {
        this.loginAccountType = loginAccountType;
    }


    // Initialize Client Views
    public ObjectProperty<ClientMenuOptions> getClientSelectedMenuItem() {
        return this.clientSelectedMenuItem;
    }
    public AnchorPane getHomeView() {
        if (homeView == null) {
            try {
                homeView = new FXMLLoader(getClass().getResource("/Fxml/Client/ClientHome.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return homeView;
    }

    public AnchorPane getCalendarView() {
        if (calendarView == null) {
            try {
                calendarView = new FXMLLoader(getClass().getResource("/Fxml/Client/ClientCalendar.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return calendarView;
    }

    public AnchorPane getProfileView() {
        if (profileView == null) {
            try {
                profileView = new FXMLLoader(getClass().getResource("/Fxml/Client/ClientProfile.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return profileView;
    }

    public AnchorPane getSettingsView() {
        if (settingsView == null) {
            try {
                settingsView = new FXMLLoader(getClass().getResource("/Fxml/Client/ClientSettings.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return settingsView;
    }

    public void showClientWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Client/Client.fxml"));
        ClientController clientController = new ClientController();
        loader.setController(clientController);
        createStage(loader);
    }

    // Initialize Admin Views
    public ObjectProperty<AdminMenuOptions> getAdminSelectedMenuItem() {
        return this.adminSelectedMenuItem;
    }

    public AnchorPane getProfilesView() {
        if (profilesView == null) {
            try {
                profilesView = new FXMLLoader(getClass().getResource("/Fxml/Admin/AdminProfiles.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return profilesView;
    }

    public AnchorPane getCreateClientView() {
        if (createClientView == null) {
            try {
                createClientView = new FXMLLoader(getClass().getResource("/Fxml/Admin/AdminCreateClient.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return createClientView;
    }

    public AnchorPane getDeleteClientView() {
        if (deleteClientView == null) {
            try {
                deleteClientView = new FXMLLoader(getClass().getResource("/Fxml/Admin/AdminDeleteClient.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return deleteClientView;
    }

    public void showAdminWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Admin/Admin.fxml"));
        AdminController adminController = new AdminController();
        loader.setController(adminController);
        createStage(loader);
    }

    // Create LoginWindow
    public void showLoginWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
        createStage(loader);
    }

    // Set scene
    private void createStage(FXMLLoader loader) {
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/Images/icon.png"))));
        stage.setTitle("ToolBox");
        stage.setResizable(false);
        stage.show();
    }

    // Close scene
    public void closeStage(Stage stage) {
        stage.close();
    }

}


