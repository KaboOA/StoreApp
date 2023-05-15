package com.example.store_app.Additions;

import com.example.store_app.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class Constants {

    public static Dialog<ButtonType> dialog;
    public static boolean isAdmin = false;


    public static String ChooseImage(Stage stage) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Images", "*.jpg", "*.png"));
        File selectedFile = fc.showOpenDialog(stage);
        if (selectedFile != null) {
            return selectedFile.getPath();
        } else {
            return "Failed to get Image";
        }
    }

    public static FXMLLoader showCustomDialogBox(URL url, String title) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            fxmlLoader.setLocation(url);
            DialogPane dialogPane = fxmlLoader.load();
            dialog = new Dialog<>();
            dialog.setDialogPane(dialogPane);
            dialog.setTitle(title);
            dialog.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return fxmlLoader;
    }

    public static void transitionFromTo(ActionEvent actionEvent, String toElement) {
        try {
            Parent p = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource(toElement)));
            Scene scene = new Scene(p);
            Stage s = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            s.setScene(scene);
            s.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void showWarningAlert(String header) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("WARNING");
        alert.setHeaderText(header);
        alert.show();
    }

    public static Node addImage(String image) {
        ImageView imageView = new ImageView(new Image(image));
        imageView.setFitWidth(10);
        imageView.setFitHeight(10);
        return imageView;
    }

    public enum Sizes {XL, L, M, S}

}
