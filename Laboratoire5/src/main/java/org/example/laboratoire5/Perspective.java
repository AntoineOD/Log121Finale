package org.example.laboratoire5;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;

public class Perspective implements Subject {
    Image image;
    List<Observer> observerList= new ArrayList<Observer>();

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
            o.update(this);
        }
    }
}
