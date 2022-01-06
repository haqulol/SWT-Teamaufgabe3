module com.example.default_javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.default_javafx to javafx.fxml;
    exports com.example.default_javafx;
}