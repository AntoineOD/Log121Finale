package org.example.laboratoire5;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

public class Controleur{
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
    Image image = new Image(getClass().getResourceAsStream("/Images/beautiful-fantasy-landscape-desktop-wallpaper-preview.png"));
    private double orgSceneX, orgSceneY;

    public void initialize() {

        perspective1 = new Perspective();
        perspective1.setImage(image);
        perspective1.addObserver(new VueImg(iv1));
        iv1.setOnScroll(event->zoom(event, perspective1));
        iv1.setOnMousePressed(this::handleMousePressed);
        iv1.setOnMouseReleased(event->translation(event,perspective1));
        Undo.setOnAction(event -> undo());

        perspective2=new Perspective();
        perspective2.setImage(image);
        perspective2.addObserver(new VueImg(iv2));
        iv2.setOnScroll(event->zoom(event,perspective2));
        iv2.setOnMousePressed(this::handleMousePressed);
        iv2.setOnMouseReleased(event->translation(event,perspective2));
        ivMini.setImage(image);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    private void handleMousePressed(MouseEvent event) {
        orgSceneX = event.getSceneX();
        orgSceneY = event.getSceneY();
    }

    public Perspective perspective1;
    public Perspective perspective2;


    public void importer()
    {

    }

    public void sauvegarder(){

    }
    public void zoom(ScrollEvent event, Perspective perspective)
    {
        Zoom z= new Zoom(event.getDeltaY(), perspective);
        Gestionnaire.getInstance().execute(z);

    }
    public void translation(MouseEvent event, Perspective perspective)
    {
        System.out.println("oui");
        Commande c= new Translation(event, orgSceneX,orgSceneY, perspective);
        Gestionnaire.getInstance().execute(c);
    }
    public void undo()
    {
        Gestionnaire.getInstance().undo();
    }
}
