package labb3jhr.labb3.controller;


import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import labb3jhr.labb3.model.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


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
        model.getShapesList().clear();
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

        model.setUndoDone(false);
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
                    new Circle(new Position(x - size / 2, y - size / 2),
                            size, actualColor));
            case SQUARE -> model.getShapesList().add(
                    new Square(new Position(x - size / 2, y - size / 2),
                            size, actualColor));
        }

    }

    @FXML
    protected void onOkButtonClicked() {
        if (model.getSelectedShape() != null) {

            model.setUndoColor(model.getSelectedShape().getColor());
            model.getSelectedShape().setColor(colorPicker.getValue());


            double size = 0;
            try {
                size = Double.parseDouble(sizeTextField.getText());
            } catch (Exception ignored) {

            }
            model.setUndoSize(model.getSelectedShape().getSize());
            model.getSelectedShape().setSize(size);

            render();
        }
    }


    @FXML
    protected void onDrawModeClicked() {
        model.setUndoDone(false);
        model.setInputMode(InputMode.DRAW);
    }

    @FXML
    protected void onSelectModeClicked() {
        model.setUndoDone(false);
        model.setInputMode(InputMode.SELECT);
    }

    @FXML
    protected void onUndoClicked() {
        switch (model.getInputMode()) {
            case DRAW -> {
                List<DrawingShape> shapesList = model.getShapesList();
                if (!model.getUndoDone() && !shapesList.isEmpty()) {
                    model.setUndoObject(model.getShapesList().get(shapesList.size() - 1));
                    shapesList.remove(shapesList.size() - 1);
                    model.setUndoDone(true);
                    render();

                }
            }
            case SELECT -> {
                if (!model.getShapesList().isEmpty() && !model.getUndoDone()) {
                    model.setRedoColor(model.getSelectedShape().getColor());
                    model.getSelectedShape().setColor(model.getUndoColor());
                    model.setRedoSize(model.getSelectedShape().getSize());
                    model.getSelectedShape().setSize(model.getUndoSize());
                    model.setUndoDone(true);
                    render();
                }
            }
        }

    }

    @FXML
    protected void onRedoClicked() {
        switch (model.getInputMode()) {
            case DRAW -> {
                if (model.getUndoDone()) {
                    model.getShapesList().add(model.getUndoObject());
                    render();
                    model.setUndoDone(false);
                }
            }
            case SELECT -> {
                if (model.getUndoDone()) {
                    model.getSelectedShape().setColor(model.getRedoColor());
                    model.getSelectedShape().setSize(model.getRedoSize());
                    render();
                    model.setUndoDone(false);
                }
            }
        }
    }

    @FXML
    protected void onSaveClicked() {

        
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save as..");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("SVG Files", "*.svg"));
        File file = fileChooser.showSaveDialog(sizeTextField.getScene().getWindow());
        Path path = Path.of(file.getAbsolutePath());

        Thread thread1 = new Thread(() -> {
            System.out.println(path);
            saveFile(path);
        });
        thread1.start();

    }

    private void saveFile(Path path) {
        double width = canvas.getWidth();
        double height = canvas.getHeight();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("" +
                "<svg xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" version=\"1.1\"" +
                " width=\"" + (int)width + "\" height=\""+ (int)height + "\">\n");

        if (!model.getShapesList().isEmpty()) {
            for (DrawingShape shape : model.getShapesList()) {
                stringBuilder.append(shape.toSVG());
                stringBuilder.append("\n");
            }
        }


        stringBuilder.append("</svg>");
        
        writeToSvgFile(stringBuilder, path);
    }

    private void writeToSvgFile(StringBuilder stringBuilder, Path path) {
        try {
            if (!Files.exists(path))
                Files.createFile(path);
            Files.writeString(path, stringBuilder.toString());

        } catch (IOException e) {
            System.out.println("Something went wrong with the file handling: " + e.getClass().getName() + ": " + e.getMessage());
        }

    }

}