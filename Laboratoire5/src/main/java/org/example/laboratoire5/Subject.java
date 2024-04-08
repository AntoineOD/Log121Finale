package org.example.laboratoire5;

import javafx.scene.image.Image;

public interface Subject {
    public Image getImage();
    public void setImage(Image image);

    public Double getCurrentScale();
    public void setCurrentScale(Double currentScale);

    public void addObserver(Observer o);
    public void removeObserver(Observer o);

    public void notifyObservers();

}
