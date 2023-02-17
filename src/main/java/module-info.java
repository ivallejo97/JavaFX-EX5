module com.example.javafxex5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxex5 to javafx.fxml;
    exports com.example.javafxex5;
}