package com.example.store_app;

import com.example.store_app.DataModels.Clothes;
import com.example.store_app.DataModels.Dairy;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

import static com.example.store_app.Additions.Constants.*;

public class HelloApplication extends Application {
    public static ObservableList<Clothes> clothesObservableList;
    public static ObservableList<Clothes> clothesObservableList1;
    public static ObservableList<Dairy> dairyObservableList;
    public static ObservableList<Dairy> dairyObservableList1;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Store App");
        stage.setScene(scene);
        stage.show();

        initializeClothesData();
        initializeDairyData();

        
    }


    void initializeClothesData() {
        clothesObservableList = FXCollections.observableArrayList(
                new Clothes("Cottonil ", 2022, "Half Sleeves Shirt- 2 Pieces - White", 60, 150, "D:\\My_Works\\Store Java GUI Project\\Project Photos\\Clothes Photos\\under shirt.png", "Under-Shirt", sizes1(), "#0261"),
                new Clothes("Defacto", 2023, "Flyon Women Pant Denim Wide Leg", 100, 300, "D:\\My_Works\\Store Java GUI Project\\Project Photos\\Clothes Photos\\wide leg.png", "Pant", sizes2(), "#9243"),
                new Clothes("h&m", 2023, "Girls Pyjama", 20, 179.99, "D:\\My_Works\\Store Java GUI Project\\Project Photos\\Clothes Photos\\pijama.png", "Pyjama", sizes3(), "#2266")
        );
    }

    void initializeDairyData() {
        dairyObservableList = FXCollections.observableArrayList(
                new Dairy("Milk", LocalDate.of(2023, 5, 11), LocalDate.of(2023, 6, 12), "Juhayna Full Cream Milk - 1.5 Liter", 50, 35.99, "D:\\My_Works\\Store Java GUI Project\\Project Photos\\Dairy Photos\\juhaina.png", "#0356"),
                new Dairy("Cheese", LocalDate.of(2023, 5, 18), LocalDate.of(2023, 6, 30), "La Vache Qui Rit Cheese - 16 Pieces", 80, 65.5, "D:\\My_Works\\Store Java GUI Project\\Project Photos\\Dairy Photos\\la vache que rit.png", "#6829"),
                new Dairy("Feta Cheese", LocalDate.of(2023, 4, 20), LocalDate.of(2023, 6, 25), "Domty Feta Plus Cheese - 250 gm", 90, 20.5, "D:\\My_Works\\Store Java GUI Project\\Project Photos\\Dairy Photos\\domty.png", "#5492")
        );
    }
}