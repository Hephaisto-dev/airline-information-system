package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.util.function.Supplier;

/**
 * Just for demo purposes, Controller of other view (primary.fxml).
 *
 * @author Informatics Fontys Venlo
 */
public class PrimaryController {

    private final Supplier<SceneManager> sceneManagerSupplier;
    @FXML
    public Button primaryButton;

    public PrimaryController(Supplier<SceneManager> sceneManagerSupplier) {
        this.sceneManagerSupplier = sceneManagerSupplier;
    }

    @FXML
    private void switchToSecondary() {
        sceneManagerSupplier.get().changeScene("secondary");
    }
}
