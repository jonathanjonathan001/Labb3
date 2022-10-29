package labb3jhr.labb3.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public abstract class DrawingShape {
    private final Position position;
    private double size;
    private Color color;


    public DrawingShape(Position position, double size, Color color) {
        this.position = position;
        this.size = size;
        this.color = color;

    }

    public Position getPosition() {
        return position;
    }

    public double getSize() {
        return size;
    }

    public Color getColor() {
        return color;
    }


    public void setSize(double size) {
        this.size = size;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract boolean mouseCoordinatesAreOnMe(double mouseX, double mouseY);

    public abstract void draw(GraphicsContext context);

    public abstract String toSVG();
}
