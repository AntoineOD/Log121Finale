module com.example.dernierlablog121 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dernierlablog121 to javafx.fxml;
    exports com.example.dernierlablog121;
}