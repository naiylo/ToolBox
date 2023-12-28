module com.example.toolbox {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.xerial.sqlitejdbc;
    requires fontawesomefx;


    opens com.example.toolbox to javafx.fxml;
    exports com.example.toolbox;
    exports com.example.toolbox.Controllers;
    exports com.example.toolbox.Controllers.Admin;
    exports com.example.toolbox.Controllers.Client;
    exports com.example.toolbox.Models;
    exports com.example.toolbox.Views;
}