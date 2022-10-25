package labb3jhr.labb3.model;

import javafx.scene.paint.Color;

import java.util.Objects;

public final class DrawingShape {
    private final Position position;
    private double size;
    private Color color;
    private final ShapeType shapeType;

    public DrawingShape(Position position, double size, Color color, ShapeType shapeType) {
        this.position = position;
        this.size = size;
        this.color = color;
        this.shapeType = shapeType;
    }

    public Position getPosition() {
        return position;
    }

    public double size() {
        return size;
    }

    public Color color() {
        return color;
    }

    public ShapeType shapeType() {
        return shapeType;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean mouseCoordinatesAreOnMe(double mouseX, double mouseY) {
        // TODO implement method by comparing mouse coordinates with object
        switch (shapeType) {
            case CIRCLE -> {
                // formula:
                // (x - center_x)^2 + (y-center_y)^2 < radius^2

                double dx = mouseX - (position.x() + size/2) ;
                double dy = mouseY - (position.y() + size/2);

                return (dx * dx) + (dy * dy) <= ((size / 2) * (size / 2));
            }
            case SQUARE -> {
                if (mouseX >= (position.x()) && mouseX <= position.x() + size
                        && mouseY >= (position.y()) && mouseY <= (position.y() + size)) {
                    System.out.println("Mouse coordinates match");
                    return true;
                } else
                    return false;
            }
        }
        return true;
    }


}
