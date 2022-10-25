package labb3jhr.labb3.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends DrawingShape {


    public Circle(Position position, double size, Color color) {
        super(position, size, color);
    }

    @Override
    public boolean mouseCoordinatesAreOnMe(double mouseX, double mouseY) {

        // formula:
        // (x - center_x)^2 + (y-center_y)^2 < radius^2

        double dx = mouseX - (getPosition().x() + getSize() / 2);
        double dy = mouseY - (getPosition().y() + getSize() / 2);

        return (dx * dx) + (dy * dy) <= ((getSize() / 2) * (getSize() / 2));


    }

    @Override
    public void draw(GraphicsContext context) {
        context.setFill(getColor());
        context.fillOval(getPosition().x() ,
                getPosition().y() ,
                getSize(), getSize());
    }
}


