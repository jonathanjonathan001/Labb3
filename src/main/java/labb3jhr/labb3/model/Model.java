package labb3jhr.labb3.model;


import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;

public class Model {


    private List<DrawingShape> shapesList = new ArrayList<>();

    private double undoSize;
    private double redoSize;
    private Color undoColor;

    private Color redoColor;
    private boolean undoDone;
    private DrawingShape undoObject;
    private ShapeType shapeTypeInput;

    private DrawingShape selectedShape;
    private InputMode inputMode;
    public Model() {
        shapeTypeInput = ShapeType.SQUARE;
        inputMode = InputMode.DRAW;

    }

    public void createShape(Color actualColor, double x, double y, double size) {
        switch (shapeTypeInput) {
            case CIRCLE -> shapesList.add(
                    new Circle(new Position(x - size / 2, y - size / 2),
                            size, actualColor));
            case SQUARE -> shapesList.add(
                    new Square(new Position(x - size / 2, y - size / 2),
                            size, actualColor));
        }

    }

    public DrawingShape getUndoObject() {
        return undoObject;
    }

    public void setUndoObject(DrawingShape undoObject) {
        this.undoObject = undoObject;
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

    public boolean getUndoDone() {
        return undoDone;
    }

    public void setUndoDone(boolean set) {
        undoDone = set;
    }

    public void setUndoSize(double size) {
        undoSize = size;
    }

    public double getUndoSize() {
        return undoSize;
    }

    public Color getUndoColor() {
        return undoColor;
    }

    public void setUndoColor(Color undoColor) {
        this.undoColor = undoColor;
    }

    public double getRedoSize() {
        return redoSize;
    }

    public void setRedoSize(double redoSize) {
        this.redoSize = redoSize;
    }

    public Color getRedoColor() {
        return redoColor;
    }

    public void setRedoColor(Color redoColor) {
        this.redoColor = redoColor;
    }


}
