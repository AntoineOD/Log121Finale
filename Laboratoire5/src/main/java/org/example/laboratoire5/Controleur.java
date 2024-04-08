package org.example.laboratoire5;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

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
    Rectangle rec1;
    Rectangle rec2;
    Image image = new Image(getClass().getResourceAsStream("/Images/beautiful-fantasy-landscape-desktop-wallpaper-preview.png"));
    private double orgSceneX, orgSceneY;
    private double orgTranslateX, orgTranslateY;
    private double minScale = 0.5;
    private double maxScale = 2.0;

    public void initialize() {

        perspective1 = new Perspective();
        perspective1.setImage(image);
        perspective1.addObserver(new VueImg1(iv1));
        iv1.setOnScroll(event->zoom(event, perspective1));

//        iv1.setImage(image);
//        iv2.setImage(image);
        ivMini.setImage(image);
//
//
//        iv1.setOnScroll(event -> handleScroll(event, iv1));
//        iv2.setOnScroll(event -> handleScroll(event, iv2));
//
//        iv1.setOnMousePressed(this::handleMousePressed);
//        iv1.setOnMouseDragged(this::handleMouseDragged);
//        iv2.setOnMousePressed(this::handleMousePressed);
//        iv2.setOnMouseDragged(this::handleMouseDragged);
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
        orgTranslateX = ((ImageView) (event.getSource())).getTranslateX();
        orgTranslateY = ((ImageView) (event.getSource())).getTranslateY();
    }

    private void handleMouseDragged(MouseEvent event) {
        double offsetX = event.getSceneX() - orgSceneX;
        double offsetY = event.getSceneY() - orgSceneY;
        double newTranslateX = orgTranslateX + offsetX;
        double newTranslateY = orgTranslateY + offsetY;

        ((ImageView) (event.getSource())).setTranslateX(newTranslateX);
        ((ImageView) (event.getSource())).setTranslateY(newTranslateY);
    }
    public ImageSave imageSave;
    public Perspective perspective1;
    public Perspective perspective2;

    public Controleur()
    {

    }

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
    public void translation()
    {
        Commande c= new Translation();
        Gestionnaire.getInstance().execute(c);
    }
    public void undo()
    {
        Gestionnaire.getInstance().undo();
    }
}
