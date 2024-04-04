package org.example.laboratoire5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image ;

public class VuePrincipale extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        Button btnSauvegarder = new Button("Sauvegarder");
        grid.add(btnSauvegarder, 0, 0);

        Button btnQuitter = new Button("Quitter");
        grid.add(btnQuitter, 1, 0);

        Image image = new Image("file:beautiful-fantasy-landscape-desktop-wallpaper-preview.png");
        ImageView iv = new ImageView(image);
        iv.setPreserveRatio(true);
        iv.setFitWidth(400);
        grid.add(iv, 2,5);

        Button btnUp = new Button("^");
        grid.add(btnUp, 4, 10);

        Button btnDown = new Button("⌄");
        grid.add(btnDown, 4, 12);

        Button btnGauche = new Button("<");
        grid.add(btnGauche, 3, 11);

        Button btnDroite = new Button(">");
        grid.add(btnDroite, 5, 11);

        Button btnZoom = new Button("+");
        grid.add(btnZoom, 7, 10);

        Button btnDeZoom = new Button("-");
        grid.add(btnDeZoom, 7, 12);

        Scene scene = new Scene(grid, 750, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
