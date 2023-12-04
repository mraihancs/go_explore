module com.example.gotravel {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gotravel to javafx.fxml;
    exports com.example.gotravel;
}