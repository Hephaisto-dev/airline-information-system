package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.function.Supplier;

public class SearchFlightController {

    @FXML
    private TableView<?> Table;

    @FXML
    private TableColumn<?, ?> flightID;
    @FXML
    private Button BtnBack;
    private final Supplier<SceneManager> sceneManagerSupplier;


    public SearchFlightController(Supplier<SceneManager> sceneManagerSupplier){
        this.sceneManagerSupplier = sceneManagerSupplier;
    }
    @FXML
    public void BackToMain(ActionEvent actionEvent) {

        sceneManagerSupplier.get().changeScene("mainGUI");

    }


}
