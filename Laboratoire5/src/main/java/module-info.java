module org.example.laboratoire5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.laboratoire5 to javafx.fxml;
    exports org.example.laboratoire5;
}