package org.example.laboratoire5;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Controleur{
    @FXML
    private MenuItem chargerMenuItem;
    @FXML
    ImageView iv1;
    @FXML
    ImageView iv2;
    @FXML
    ImageView ivMini;
    @FXML
    ScrollPane paneI1;
    @FXML
    ScrollPane paneI2;
    @FXML
    MenuItem Undo;
    private double orgSceneX, orgSceneY;

    public void initialize() {
        perspective1 = new Perspective();
        perspective1.addObserver(new VueImg(iv1));
        iv1.setOnScroll(event -> zoom(event, perspective1));
        iv1.setOnMousePressed(this::handleMousePressed);
        iv1.setOnMouseReleased(event -> translation(event, perspective1));

        perspective2 = new Perspective();
        perspective2.addObserver(new VueImg(iv2));
        iv2.setOnScroll(event -> zoom(event, perspective2));
        iv2.setOnMousePressed(this::handleMousePressed);
        iv2.setOnMouseReleased(event -> translation(event, perspective2));

        chargerMenuItem.setOnAction(event -> handleChargerAction());

        Undo.setOnAction(event -> undo());
    }


    private void handleMousePressed(MouseEvent event) {
        orgSceneX = event.getSceneX();
        orgSceneY = event.getSceneY();
    }

    public Perspective perspective1;
    public Perspective perspective2;


    public void sauvegarder() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save State");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("State Files", "*.state"));
        File file = fileChooser.showSaveDialog(new Stage());
        if (file != null) {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
                out.writeObject(perspective1);
                out.writeObject(perspective2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void zoom(ScrollEvent event, Perspective perspective)
    {
        Zoom z= new Zoom(event.getDeltaY(), perspective);
        Gestionnaire.getInstance().execute(z);

    }
    public void translation(MouseEvent event, Perspective perspective)
    {
        Commande c= new Translation(event, orgSceneX,orgSceneY, perspective);
        Gestionnaire.getInstance().execute(c);
    }
    public void undo()
    {
        Gestionnaire.getInstance().undo();
    }

    @FXML
    private void handleChargerAction() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            String imagePath = file.toURI().toString();
            perspective1.setImagePath(imagePath);
            perspective2.setImagePath(imagePath);
            ivMini.setImage(new Image(imagePath));

            perspective1.notifyObservers();
            perspective2.notifyObservers();
        }
    }

}
