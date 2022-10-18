module labb3jhr.labb3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens labb3jhr.labb3 to javafx.fxml;
    exports labb3jhr.labb3;
}