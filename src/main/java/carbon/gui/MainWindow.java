package carbon.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import carbon.Carbon;

/**
 * Controller for MainWindow.
 * Provides the layout for the other controls.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Carbon carbon;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/clown.png"));
    private Image carbonImage = new Image(this.getClass().getResourceAsStream("/images/carbon.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    public void setCarbon(Carbon carbon) {
        this.carbon = carbon;
        String greeting = this.carbon.greet();
        dialogContainer.getChildren().add(DialogBox.getCarbonDialog(greeting, carbonImage));
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container.
     * Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = carbon.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getCarbonDialog(response, carbonImage)
        );
        userInput.clear();
    }
}
