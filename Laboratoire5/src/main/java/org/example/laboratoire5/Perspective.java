package org.example.laboratoire5;

import javafx.scene.image.Image;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Perspective implements Subject,Serializable {
    private double currentScale = 1.0;
    private double positionX = 0.0;
    private double positionY = 0.0;
    private transient String imagePath;
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public double getCurrentScale() {
        return currentScale;
    }

    @Override
    public void setCurrentScale(Double currentScale) {
        this.currentScale = currentScale;
        notifyObservers();
    }
    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
        notifyObservers();
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
        notifyObservers();
    }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
        notifyObservers();
    }

    public String getImagePath() {
        return imagePath;
    }
    public void setImage(Image image) {
        this.imagePath = image.getUrl();
        notifyObservers();
    }
    public Image getImage() {
        return new Image(imagePath);
    }

    public void addObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}
