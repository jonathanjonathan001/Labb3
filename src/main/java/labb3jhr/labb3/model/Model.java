package labb3jhr.labb3.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.List;

public class Model {
//    private StringProperty text;

    private List<DrawingShape> shapesList = new ArrayList<>();

    private ShapeType shapeTypeInput;

    private InputMode inputMode;
    public Model() {
        shapeTypeInput = ShapeType.SQUARE;
        //    text = new SimpleStringProperty();
    }

    public List<DrawingShape> getShapesList() {
        return shapesList;
    }

    public ShapeType getShapeTypeInput() {
        return shapeTypeInput;
    }

    public void setShapeTypeInput(ShapeType shapeTypeInput) {
        this.shapeTypeInput = shapeTypeInput;
    }
/*public String getText() {
        return text.get();
    }

    public void setText(String text) {
        this.text.set(text);

    }

    public StringProperty textProperty() {
        return text;
    }*/
}
