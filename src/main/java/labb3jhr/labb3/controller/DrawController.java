package labb3jhr.labb3.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import labb3jhr.labb3.model.*;


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


    }

    @FXML
    protected void onSquareButtonClicked() {
        model.setShapeTypeInput(ShapeType.SQUARE);
        System.out.println("Square button clicked!");
    }

    @FXML
    protected void onClearButtonClicked() {
        System.out.println("Clear button clicked!");
        model.setSelectedShape(null);
        context.setFill(Color.WHITE);
        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }


    @FXML
    protected void render() {
        context.setFill(Color.WHITE);
        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (DrawingShape shape : model.getShapesList()) {
            shape.draw(context);
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


        switch (model.getInputMode()) {

            case DRAW -> {

                ShapeType actualShapeType = model.getShapeTypeInput();
                Color actualColor = colorPicker.getValue();
                createShape(actualShapeType, actualColor, x, y, size);


                render();
            }
            case SELECT -> {
                System.out.println("Select mode selected!");

                if (!model.getShapesList().isEmpty()) {
                    for (int i = model.getShapesList().size() - 1; i >= 0; i--) {
                        if (model.getShapesList().get(i).mouseCoordinatesAreOnMe(x, y)) {
                            model.setSelectedShape(model.getShapesList().get(i));
                            break;
                        }
                    }
                }
            }

        }


    }

    @FXML
    private void createShape(ShapeType actualShapeType, Color actualColor, double x, double y, double size) {
        switch (actualShapeType) {
            case CIRCLE -> model.getShapesList().add(
                    new Circle(new Position(x - size/2, y - size/2),
                            size, actualColor));
            case SQUARE -> model.getShapesList().add(
                    new Square(new Position(x - size/2, y - size/2),
                            size, actualColor));
        }

    }

    @FXML
    protected void onOkButtonClicked() {
        if (model.getSelectedShape() != null) {
            model.getSelectedShape().setColor(colorPicker.getValue());

            double size = 0;
            try {
                size = Double.parseDouble(sizeTextField.getText());
            } catch (Exception ignored) {

            }

            model.getSelectedShape().setSize(size);

            render();
        }
    }


    @FXML
    protected void onDrawModeClicked() {
        model.setInputMode(InputMode.DRAW);
    }

    @FXML
    protected void onSelectModeClicked() {
        model.setInputMode(InputMode.SELECT);
    }
}