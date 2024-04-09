package org.example.laboratoire5;

import javafx.scene.image.Image;

public class Zoom implements Commande {

    Perspective perspective;
    double zoom;
    double scale;
    double previousScale;

    private double minScale = 0.5;
    private double maxScale = 2.0;

    public Zoom(double zoom, Perspective perspective)
    {
        this.zoom=zoom;
        this.perspective=perspective;
    }
    public void execute()
    {
        previousScale = perspective.getCurrentScale();
        double scaleFactor = (zoom > 0) ? 1.05: 1 / 1.05;

        scale = previousScale * scaleFactor;
        if (scale < minScale || scale > maxScale)
            return;
        perspective.setCurrentScale(scale);
    }
    public void undo()
    {
        perspective.setCurrentScale(previousScale);
    }
}
