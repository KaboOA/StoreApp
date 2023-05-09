package com.example.store_app.Additions;

import com.example.store_app.Controllers.HelloController;
import com.example.store_app.DataModels.Clothes;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import static com.example.store_app.Controllers.HelloController.clothesObservableList1;

public class ItemCell extends ListCell<Clothes> {


    @Override
    protected void updateItem(Clothes clothes, boolean b) {
        super.updateItem(clothes, b);
        if (clothes == null) {
            setGraphic(null);
        } else {
            setGraphic(itemDesign(clothes));
        }
    }

    private Node itemDesign(Clothes clothes) {
        ImageView imageView = new ImageView(clothes.getImage());
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        Font f1 = Font.font("system", FontWeight.BOLD, 15);
        Text name = new Text(clothes.getName());
        name.setWrappingWidth(180);
        // name.setTextOverrun(OverrunStyle.ELLIPSIS);
        name.setFont(f1);
        Text price = new Text(clothes.getPrice() + " EGP");
        price.setWrappingWidth(180);
        //  price.setTextOverrun(OverrunStyle.ELLIPSIS);
        VBox vBox = new VBox(name, price);
        vBox.setAlignment(Pos.CENTER_LEFT);
        vBox.setPrefWidth(220);
        Text quantity = new Text(String.valueOf(clothes.getQuantity()));
        Button del = new Button("Del");
        del.setOnAction(actionEvent -> {
            HelloController.clothesObservableList.remove(clothes);
            if (HelloController.clothesObservableList1 != null) {
                clothesObservableList1.remove(clothes);
            }
        });
        del.setStyle("-fx-text-fill: red");
        HBox hBox = new HBox(imageView, vBox, quantity, del);
        hBox.setSpacing(15);
        hBox.setAlignment(Pos.CENTER_LEFT);

        return hBox;
    }


}
