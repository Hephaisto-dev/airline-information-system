package gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class MainController implements Initializable {

    @FXML
    private Button logout;

    private final Supplier<SceneManager> sceneManagerSupplier;
    public MainController(Supplier<SceneManager> sceneManagerSupplier){
        this.sceneManagerSupplier = sceneManagerSupplier;
    }
    //TODO Implement the rest of the code here after discussion with the team

    public void sendToLogin(){
        sceneManagerSupplier.get().changeScene("loginView");
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
