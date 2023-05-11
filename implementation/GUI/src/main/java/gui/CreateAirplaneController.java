package gui;

import businesslogic.api.airplane.AirplaneCreator;
import businesslogic.api.manager.AirplaneManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class CreateAirplaneController implements Initializable {
    private final Supplier<SceneManager> sceneManagerSupplier;
    private final AirplaneCreator airplaneCreator;

    @FXML
    private TextField manufacturer;

    @FXML
    private TextField length;

    @FXML
    private TextField width;

    @FXML
    private TextField model;

    @FXML
    private TextField seats;

    @FXML
    private Button backButton;

    @FXML
    private Button confirmButton;

    public CreateAirplaneController(
            Supplier<SceneManager> sceneManagerSupplier,
            AirplaneManager airplaneManager
    ) {
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.airplaneCreator = new AirplaneCreator(airplaneManager);
    }

    public void createAirplane() {
        String manufacturerValue = manufacturer.getText();
        String lengthValue = length.getText();
        String widthValue = width.getText();
        String modelValue = model.getText();
        String seatsValue = seats.getText();

        int convertedLength = Integer.parseInt(lengthValue);
        int convertedWidth = Integer.parseInt(widthValue);
        int convertedSeats = Integer.parseInt(seatsValue);

        sendAirplane(manufacturerValue, convertedLength, convertedWidth, modelValue, convertedSeats);
    }

    public String sendAirplane(String manufacturer, int length, int width, String model, int seats) {
        String id = manufacturer + ":" + model;
        String result = airplaneCreator.createAirplane(id, manufacturer, length, width, model, seats);

        return result;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        confirmButton.setOnAction(event -> {
            createAirplane();
        });
    }
}
