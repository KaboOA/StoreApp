package com.example.store_app.Controllers;

import com.example.store_app.Additions.Constants;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    public TextField usernameId;
    public PasswordField passwordId;
    public Label wrongLogin;

    public void submit(ActionEvent actionEvent) {
        if (usernameId.getText().isEmpty() || passwordId.getText().isEmpty()) {
            wrongLogin.setText("Enter All Data");
        } else {
            if (usernameId.getText().equals("admin") && passwordId.getText().equals("admin")) {
                Constants.isAdmin = true;
                Constants.transitionFromTo(actionEvent, "hello-view.fxml");
            } else if (usernameId.getText().equals("1") && passwordId.getText().equals("1")) {
                Constants.isAdmin = false;
                Constants.transitionFromTo(actionEvent, "hello-view.fxml");
            } else {
                wrongLogin.setText("Username or Password is invalid");
            }
        }
    }


}