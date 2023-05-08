package gui;

import businesslogic.api.airport.AirportCreator;
import businesslogic.api.manager.AirportManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.function.Supplier;

public class CreateAirportController {

    private static int counter = 1;

    private final Supplier<SceneManager> sceneManagerSupplier;

    private final AirportManager airportManager;

    private final AirportCreator airportCreator;

    @FXML
    private TextField airportName;

    @FXML
    private TextField airportCountry;

    @FXML
    private Label result;

    @FXML
    private Button submitButton;


    public CreateAirportController(Supplier<SceneManager> sceneManagerSupplier, AirportManager airportManager){
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.airportManager = airportManager; // this is linked to the controller,
        this.airportCreator = new AirportCreator(airportManager); // as well as this
    }

    public void airportCreator(ActionEvent actionEvent){
        String output = sendAirport(airportName.getText(),airportCountry.getText());
        result.setText(output);
    }

    public String sendAirport(String airportName, String airportCountry){
        String id = "AIR" + airportName.toUpperCase() + String.format("%04d",counter);
        counter++;

        return airportCreator.createAirport(id,airportName, airportCountry);
    }

}
