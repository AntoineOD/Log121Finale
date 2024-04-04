module com.example.log121image {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.log121image to javafx.fxml;
    exports com.example.log121image;
}