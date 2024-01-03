package com.example.toolbox.Models;

import com.example.toolbox.Views.AccountType;
import com.example.toolbox.Views.ViewFactory;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Arrays;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;
    private final DatabaseDriver databaseDriver;
    private AccountType loginAccountType = AccountType.CLIENT;

    // Client data section
    private final Client client;
    private Boolean clientLoginSuccessFlag;
    // Admin data section


    private Model() {
        this.viewFactory = new ViewFactory();
        this.databaseDriver = new DatabaseDriver();
        // Client Data Section
        this.clientLoginSuccessFlag = false;
        this.client = new Client(" "," "," ", null);
        // Admin Data Section
    }
    public static synchronized Model getInstance() {
        if (model == null) {
            model = new Model();
        }
        return model;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }

    public AccountType getLoginAccountType() {
        return loginAccountType;
    }

    public void setLoginAccountType(AccountType loginAccountType) {
        this.loginAccountType = loginAccountType;
    }

    public DatabaseDriver getDatabaseDriver() {return this.databaseDriver;}

    /*
    Client Method Section
     */

    public boolean getClientLoginSuccessFlag() {return this.clientLoginSuccessFlag;}

    public void setClientLoginSuccessFlag(boolean flag) {this.clientLoginSuccessFlag = flag;}

    public Client getClient() {
        return client;
    }

    public void evaluateClientCredentials(String emailAddress, String password) {
        Account account;
        ResultSet resultSet = databaseDriver.getClientData(emailAddress, password);
        try {
            if (resultSet.isBeforeFirst()) {
                this.client.firstnameProperty().set(resultSet.getString("FirstName"));
                this.client.lastnameProperty().set(resultSet.getString("LastName"));
                this.client.email_addressProperty().set(resultSet.getString("EmailAddress"));
                String[] dateParts = resultSet.getString("Date").split("-");
                System.out.print(Arrays.toString(dateParts));
                LocalDate date = LocalDate.of(Integer.parseInt(dateParts[0]),Integer.parseInt(dateParts[1]),Integer.parseInt(dateParts[2]));
                this.client.localDateProperty().set(date);
                this.clientLoginSuccessFlag= true;
            }
            else {
                this.clientLoginSuccessFlag = false;
            }

        } catch (Exception e) {
            System.out.print("Error");
        };
    }
}
