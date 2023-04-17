package gui;

import businesslogic.api.airport.AirportCreator;
import businesslogic.api.manager.AirportManager;
import businesslogic.api.manager.FlightManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class CreateAirportController {

    private static int counter = 1;

    private final Supplier<SceneManager> sceneManagerSupplier;

    private final AirportManager airportManager;

    private final AirportCreator airportCreator;

    @FXML
    private TextField airportName;

    @FXML
    private TextField airportCity;

    @FXML
    private TextField airportCountry;

    @FXML
    private Button backButton;

    @FXML
    private Button submitButton;
    @FXML
    private Button BtnBack;

    @FXML
    private Label result;

    public CreateAirportController(Supplier<SceneManager> sceneManagerSupplier, AirportManager airportManager){
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.airportManager = airportManager; // this is linked to the controller,
        this.airportCreator = new AirportCreator(airportManager); // as well as this
    }
    @FXML
    public void BackToMain(ActionEvent actionEvent) {

        sceneManagerSupplier.get().changeScene("mainGUI");

    }

    public void airportCreator(){
        String output = sendAirport(airportName.getText(),airportCity.getText(),airportCountry.getText());
        result.setText(output);
    }

    public String sendAirport(String airportName, String airportCity, String airportCountry){
        String id = "AIR" + airportName.toUpperCase() + String.format("%04d",counter);
        counter++;

        return airportCreator.createAirport(id,airportName, airportCity, airportCountry);
    }

}
