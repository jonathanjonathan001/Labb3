package labb3jhr.labb3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("draw-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 604, 682);
        stage.setTitle("Draw!");
        stage.setScene(scene);
        stage.show();
        // add comment
    }

    public static void main(String[] args) {
        launch();
    }
}