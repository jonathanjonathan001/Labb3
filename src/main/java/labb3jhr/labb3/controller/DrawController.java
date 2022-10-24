package labb3jhr.labb3.controller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import labb3jhr.labb3.model.DrawingShape;
import labb3jhr.labb3.model.Model;
import labb3jhr.labb3.model.ShapeType;


public class DrawController {

    @FXML
    private Model model = new Model();

    @FXML
    private Canvas canvas;


    @FXML
    private GraphicsContext context;


    @FXML
    private Button circleButton;

    @FXML
    private TextField sizeTextField;

    @FXML
    private ColorPicker colorPicker;

    public void initialize() {
        // textField1.textProperty().bindBidirectional(model.textProperty());
        // welcomeText.textProperty().bind(helloModel.textProperty());
        sizeTextField.setText("20");
        context = canvas.getGraphicsContext2D();
    }


     // welcomeText.setText(hellomodel.getText());

    @FXML
    protected void onCircleButtonClicked() {
        model.setShapeTypeInput(ShapeType.CIRCLE);
        System.out.println("Circle button clicked!");
        // helloModel.setText("");

    }
    @FXML
    protected void onSquareButtonClicked() {
        model.setShapeTypeInput(ShapeType.SQUARE);
        System.out.println("Square button clicked!");
    }

    @FXML
    protected void onClearButtonClicked() {
        System.out.println("Clear button clicked!");
        context.setFill(Color.WHITE);
        context.fillRect(0,0, canvas.getWidth(), canvas.getHeight());
    }

    @FXML
    protected void render() {
        context.setFill(Color.WHITE);
        context.fillRect(0,0, canvas.getWidth(), canvas.getHeight());

        for ( DrawingShape shape : model.getShapesList()) {
            switch (shape.shapeType()) {
                case CIRCLE -> {
                    context.setFill(shape.color());
                    context.fillOval(shape.x() - shape.size()/2,
                                    shape.y() - shape.size()/2,
                                    shape.size(), shape.size());
                }
                case SQUARE -> {
                    context.setFill(shape.color());
                    context.fillRect(shape.x() - shape.size()/2,
                            shape.y() - shape.size()/2,
                            shape.size(), shape.size());

                }
            }
        }

    }
    @FXML
    protected void onCanvasClicked(MouseEvent mouseEvent) {

        // System.out.println("Canvas clicked!");

        double x = mouseEvent.getX();
        double y = mouseEvent.getY();
        // gc.moveTo(x,y);
        double size = 0;
        try {
            size = Double.parseDouble(sizeTextField.getText());
        } catch (Exception e) {
            //throw new RuntimeException(e);
            // System.out.println();
        }

        ShapeType actualShapeType = model.getShapeTypeInput();
        Color actualColor = colorPicker.getValue();
        model.getShapesList().add(new DrawingShape(x,y,size,actualColor,actualShapeType));

        render();

    }
}