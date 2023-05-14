package gui;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.function.Supplier;

//import static jdk.jpackage.internal.WixAppImageFragmentBuilder.ShortcutsFolder.Desktop;
import java.awt.Desktop;
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
    @FXML
    public void initialize() {
        facebookIcon.setOnMouseClicked(event -> {
            openUrl("https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley");
        });

        twitterIcon.setOnMouseClicked(event -> {
            openUrl("https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley");
        });

        InstagramIcon.setOnMouseClicked(event -> {
            openUrl("https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley");
        });

        emailIcon.setOnMouseClicked(event -> {
            openUrl("https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley");
        });
    }

    // helper method to open a URL in the default browser
    private void openUrl(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
