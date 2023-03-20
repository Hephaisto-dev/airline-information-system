package gui;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;

/**
 * FXML Controller class
 *
 * @author Informatics Fontys Venlo
 */
public class ErrorController implements Initializable {

    private final Supplier<SceneManager> sceneManagerSupplier;

    public ErrorController(Supplier<SceneManager> sceneManagerSupplier) {
        this.sceneManagerSupplier = sceneManagerSupplier;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
