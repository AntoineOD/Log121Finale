package org.example.laboratoire5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
        

//        Text scenetitle = new Text("Paramètres pour la visualisation du tri:");
//        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
//        grid.add(scenetitle, 0, 0, 2, 1);
//
//        Label typeTri = new Label("Choix du type de tri:");
//        grid.add(typeTri, 0, 2, 2,1);
//
//        ChoiceBox choiceBox = new ChoiceBox();
//        choiceBox.setValue("Sélectionnez un type");
//        choiceBox.getItems().add("Merge Sort");
//        choiceBox.getItems().add("Quick Sort");
//        grid.add(choiceBox, 2, 2, 3,1);
//
//        Label vals = new Label("Entrez les valeurs à trier (val1,val2 ...):");
//        grid.add(vals, 0, 3, 2,1);
//
//        TextField inputVals = new TextField();
//        grid.add(inputVals,2,3,2,1);
//
//        Button btnOk = new Button("Ok");
//        grid.add(btnOk, 4,8);
//
//        Button btnAnnuler = new Button("Annuler");
//        grid.add(btnAnnuler,5,8);
//
//        Button btnAppliquer = new Button("Appliquer");
//        grid.add(btnAppliquer,6,8);

        Scene scene = new Scene(grid, 700, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
