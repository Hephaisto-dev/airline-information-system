package gui;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.fxml.FXML;

import java.util.function.Supplier;

public class FooterController {
    private final Supplier<SceneManager> sceneManagerSupplier;

    @FXML
    private FontAwesomeIcon InstagramIcon;

    @FXML
    private FontAwesomeIcon emailIcon;

    @FXML
    private FontAwesomeIcon facebookIcon;

    @FXML
    private FontAwesomeIcon twitterIcon;

    public FooterController(Supplier<SceneManager> sceneManagerSupplier){
        this.sceneManagerSupplier = sceneManagerSupplier;
    }


}
