package labb3jhr.labb3.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.List;

public class Model {
//    private StringProperty text;

    private List<DrawingShape> shapesList = new ArrayList<>();

    private ShapeType shapeTypeInput;

    private DrawingShape selectedShape;
    private InputMode inputMode;
    public Model() {
        shapeTypeInput = ShapeType.SQUARE;
        inputMode = InputMode.DRAW;
        //    text = new SimpleStringProperty();
    }

    public List<DrawingShape> getShapesList() {
        return shapesList;
    }
    public InputMode getInputMode() {
        return inputMode;
    }

    public void setInputMode(InputMode inputMode) {
        this.inputMode = inputMode;
    }

    public ShapeType getShapeTypeInput() {
        return shapeTypeInput;
    }

    public void setShapeTypeInput(ShapeType shapeTypeInput) {
        this.shapeTypeInput = shapeTypeInput;
    }

    public DrawingShape getSelectedShape() {
        return selectedShape;
    }

    public void setSelectedShape(DrawingShape selectedShape) {
        this.selectedShape = selectedShape;
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
