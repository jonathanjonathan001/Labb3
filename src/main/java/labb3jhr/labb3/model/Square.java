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

    @Override
    public String toSVG() {

        String color = String.format(
                "%02X%02X%02X"
                , Math.round(getColor().getRed()*255)
                , Math.round(getColor().getGreen()*255)
                , Math.round(getColor().getBlue()*255)
        );


        return "<rect x=\"" + getPosition().x() + "\" y=\"" + getPosition().y() +
                "\" width=\"" + getSize() + "\" height=\"" + getSize() +
                "\" stroke=\"black\" stroke-width=\"0\" fill=\"#" + color + "\" />";
    }


}
