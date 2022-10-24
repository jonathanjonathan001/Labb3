module labb3jhr.labb3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens labb3jhr.labb3 to javafx.fxml;
    exports labb3jhr.labb3;
    exports labb3jhr.labb3.controller;
    opens labb3jhr.labb3.controller to javafx.fxml;
    exports labb3jhr.labb3.model;
    opens labb3jhr.labb3.model to javafx.fxml;
}