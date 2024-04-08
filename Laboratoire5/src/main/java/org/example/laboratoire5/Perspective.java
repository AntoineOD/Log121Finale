package org.example.laboratoire5;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;

public class Perspective implements Subject {

    Double currentScale = 1.0;
    Image image;
    List<Observer> observerList= new ArrayList<Observer>();

    public Image getImage() {
        return image;
    }

    public Double getCurrentScale() {
        return currentScale;
    }

    public void setCurrentScale(Double currentScale) {
        this.currentScale = currentScale;
        notifyObservers();
    }

    public void setImage(Image image) {
        this.image = image;
        notifyObservers();
    }

    public void addObserver(Observer o)
    {
        observerList.add(o);
        o.update(this);
    }
    public void removeObserver(Observer o)
    {
        observerList.add(o);
    }
    public void notifyObservers()
    {
        for(Observer o :observerList)
        {
            o.update(this);
        }
    }
}
