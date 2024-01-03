package com.example.toolbox.Models;

import java.sql.*;

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
            System.out.print("trying to fetch");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    /*
    Admin Section
     */

    /*
    Utility Methods
     */
}
