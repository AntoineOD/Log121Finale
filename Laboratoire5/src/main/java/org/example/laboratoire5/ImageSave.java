package org.example.laboratoire5;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class ImageSave  {
    Image image;
    Double currentScale;
    List<Observer> observerList= new ArrayList<Observer>();
    public Double getCurrentScale() {
        return currentScale;
    }

    public void setCurrentScale(Double currentScale) {
        this.currentScale = currentScale;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void addObserver(Observer o)
    {
        observerList.add(o);
    }
    public void removeObserver(Observer o)
    {
        observerList.add(o);
    }
    public void notifyObservers()
    {
        for(Observer o :observerList)
        {

        }
    }

}
