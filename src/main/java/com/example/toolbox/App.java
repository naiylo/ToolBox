package com.example.toolbox;

import com.example.toolbox.Models.Model;
import javafx.application.Application;
import javafx.stage.Stage;

import java.sql.SQLException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws SQLException {
        Model.getInstance().getViewFactory().showLoginWindow();
    }
}
