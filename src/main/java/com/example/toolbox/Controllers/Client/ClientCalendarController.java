package com.example.toolbox.Controllers.Client;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.time.ZonedDateTime;
import java.util.*;

public class ClientCalendarController implements Initializable {

    ZonedDateTime dateFocus;
    ZonedDateTime today;
    public AnchorPane main_AnchorPane;
    public FlowPane calendar_FlowPane;
    public Label month_label;
    public Label year_label;
    public Button left_button;
    public Button right_button;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dateFocus = ZonedDateTime.now();
        today = ZonedDateTime.now();
        left_button.setOnAction(event -> backOneMonth());
        right_button.setOnAction(event -> forwardOneMonth());
        drawCalendar();
    }

    public void backOneMonth() {
        dateFocus = dateFocus.plusMonths(-1);
        calendar_FlowPane.getChildren().clear();
    }

    public void forwardOneMonth() {
        dateFocus = dateFocus.plusMonths(-1);
        calendar_FlowPane.getChildren().clear();
    }

    private void drawCalendar() {
        year_label.setText(String.valueOf(dateFocus.getYear()));
        month_label.setText(String.valueOf(dateFocus.getMonth()));

        double calendarWidth = calendar_FlowPane.getPrefWidth();
        double calendarHeight = calendar_FlowPane.getPrefHeight();
        double strokeWidth = 1;
        double spacingH = calendar_FlowPane.getHgap();
        double spacingV = calendar_FlowPane.getVgap();
    }

}

