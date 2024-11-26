module com.example.files {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.files to javafx.fxml;
    exports com.example.files;
}