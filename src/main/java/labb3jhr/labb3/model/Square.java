package labb3jhr.labb3.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends DrawingShape {


    public Square(Position position, double size, Color color) {
        super(position, size, color);
    }

    @Override
    public boolean mouseCoordinatesAreOnMe(double mouseX, double mouseY) {
        if (mouseX >= (getPosition().x()) && mouseX <= getPosition().x() + getSize()
                && mouseY >= (getPosition().y()) && mouseY <= (getPosition().y() + getSize())) {
            System.out.println("Mouse coordinates match");
            return true;
        }
        else
            return false;
    }

    @Override
    public void draw(GraphicsContext context) {
        context.setFill(getColor());
        context.fillRect(getPosition().x(),
                getPosition().y(),
                getSize(), getSize());
    }


}
