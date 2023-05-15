package com.example.store_app;

import com.example.store_app.Additions.Constants;
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
import java.util.ArrayList;

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
        ArrayList<Constants.Sizes> sizes = new ArrayList<>();
        sizes.add(Constants.Sizes.XL);
        sizes.add(Constants.Sizes.L);
        clothesObservableList = FXCollections.observableArrayList(
                new Clothes("h&m", 2023, "Shirt", 120, 350, "D:\\My_Works\\Store Java GUI Project\\R.jpg", "Shirt", sizes, "#0261"),
                new Clothes("h&m", 2023, "black Shirt", 120, 350, "D:\\My_Works\\Store Java GUI Project\\R.jpg", "Shirt", sizes, "#9243"),
                new Clothes("h&m", 2023, "White Shirt", 120, 350, "D:\\My_Works\\Store Java GUI Project\\R.jpg", "Shirt", sizes, "#2266"),
                new Clothes("h&m", 2023, "yellow Shirt", 120, 350, "D:\\My_Works\\Store Java GUI Project\\R.jpg", "Shirt", sizes, "#4369"));
    }

    void initializeDairyData() {
        dairyObservableList = FXCollections.observableArrayList(
                new Dairy("Milk", LocalDate.of(2023, 5, 11), LocalDate.of(2023, 6, 12), "Labanita", 15, 50, "D:\\My_Works\\Store Java GUI Project\\R.jpg", "#0356"),
                new Dairy("Milk", LocalDate.of(2023, 5, 11), LocalDate.of(2023, 6, 12), "jabanita", 15, 50, "D:\\My_Works\\Store Java GUI Project\\R.jpg", "#6829"),
                new Dairy("Milk", LocalDate.of(2023, 5, 11), LocalDate.of(2023, 6, 12), "kabanita", 15, 50, "D:\\My_Works\\Store Java GUI Project\\R.jpg", "#5492")
        );
    }
}