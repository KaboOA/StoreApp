module com.example.store_app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.store_app to javafx.fxml;
    exports com.example.store_app;
    exports com.example.store_app.Controllers;
    opens com.example.store_app.Controllers to javafx.fxml;
}