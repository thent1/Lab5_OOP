module com.example.lab5_oop {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab5_oop to javafx.fxml;
    exports com.example.lab5_oop;
    exports com.example.lab5_oop.shapeTable;
    opens com.example.lab5_oop.shapeTable to javafx.fxml;
    exports com.example.lab5_oop.shapes;
    opens com.example.lab5_oop.shapes to javafx.fxml;
}