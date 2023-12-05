module com.example.lab5_oop {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab5_oop to javafx.fxml;
    exports com.example.lab5_oop;
    exports com.example.lab5_oop.ShapeTable;
    opens com.example.lab5_oop.ShapeTable to javafx.fxml;
    exports com.example.lab5_oop.Shapes;
    opens com.example.lab5_oop.Shapes to javafx.fxml;
}