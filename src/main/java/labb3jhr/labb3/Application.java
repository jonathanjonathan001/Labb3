package labb3jhr.labb3;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("draw-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 645, 682);
        stage.setTitle("Draw!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        // add comment
    }

    public static void main(String[] args) {
        launch();
    }
}