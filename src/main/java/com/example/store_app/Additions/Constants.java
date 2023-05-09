package com.example.store_app.Additions;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class Constants {

    public static Dialog<ButtonType> dialog;

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

    public static void showCustomDialogBox(URL url, String title) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(url);
            DialogPane dialogPane = fxmlLoader.load();
            dialog = new Dialog<>();
            dialog.setDialogPane(dialogPane);
            dialog.setTitle(title);
            dialog.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public enum sizes {XL, L, M, S}

}
