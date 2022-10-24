package labb3jhr.labb3.model;

import javafx.scene.paint.Color;

import java.util.Objects;

public final class DrawingShape {
    private final double x;
    private final double y;
    private double size;
    private Color color;
    private final ShapeType shapeType;

    public DrawingShape(double x, double y, double size, Color color, ShapeType shapeType) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        this.shapeType = shapeType;
    }

    public double x() {
        return x;
    }

    public double y() {
        return y;
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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (DrawingShape) obj;
        return Double.doubleToLongBits(this.x) == Double.doubleToLongBits(that.x) &&
                Double.doubleToLongBits(this.y) == Double.doubleToLongBits(that.y) &&
                Double.doubleToLongBits(this.size) == Double.doubleToLongBits(that.size) &&
                Objects.equals(this.color, that.color) &&
                Objects.equals(this.shapeType, that.shapeType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, size, color, shapeType);
    }

    @Override
    public String toString() {
        return "DrawingShape[" +
                "x=" + x + ", " +
                "y=" + y + ", " +
                "size=" + size + ", " +
                "color=" + color + ", " +
                "shapeType=" + shapeType + ']';
    }

}
