package org.example.laboratoire5;

import javafx.scene.image.Image;

public interface Subject {

    public Image getImage();

    public double getCurrentScale();
    public void setCurrentScale(Double currentScale);
    public double getPositionX() ;


    public double getPositionY() ;

    public void setPositionX(double positionX) ;


    public void setPositionY(double positionY) ;

    public void addObserver(Observer o);
    public void removeObserver(Observer o);

    public void notifyObservers();

}
