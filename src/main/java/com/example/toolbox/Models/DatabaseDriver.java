package com.example.toolbox.Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DatabaseDriver {
    private Connection connection;

    public DatabaseDriver() {
        try {
            this.connection = DriverManager.getConnection("jdbc:sqlite:database/ToolBox.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    Client Section
     */

    public ResultSet getClientData(String emailAddress, String password) {
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Clients WHERE EmailAddress='"+emailAddress+"' AND Password='"+password+"';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getClientAppointments(String emailAddress) {
        Statement statement;
        ResultSet appointments = null;
        String query = "SELECT * FROM Appointments WHERE EmailAddress='"+emailAddress+"'";
        try {
            statement = this.connection.createStatement();
            appointments = statement.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }

    /*
    Admin Section
     */

    /*
    Utility Methods
     */
}
