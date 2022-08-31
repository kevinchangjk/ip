package carbon.gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import carbon.Carbon;

/**
 * A GUI for Carbon using FXML.
 */
public class Main extends Application {
    private Stage stage;
    private Carbon carbon = new Carbon();

    @Override
    public void start(Stage stage) {
        try {
            this.stage = stage;
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            fxmlLoader.<MainWindow>getController().setCarbon(carbon);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
