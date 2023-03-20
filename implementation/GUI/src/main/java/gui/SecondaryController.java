package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.function.Supplier;


/**
 * Just for demo purposes, Controller of other view (secondary.fxml).
 *
 * @author Informatics Fontys Venlo
 */
public class SecondaryController {

    private final Supplier<SceneManager> sceneManagerSupplier;
    @FXML
    private Button secondaryButton;
    @FXML
    private Label prevLabel;

    public SecondaryController(Supplier<SceneManager> sceneManagerSupplier) {
        this.sceneManagerSupplier = sceneManagerSupplier;
    }

    @FXML
    private void switchToPrimary() {
        sceneManagerSupplier.get().changeScene("customerView");
    }

    public void setPreviousView(String view) {
        prevLabel.setText(view);
    }
}