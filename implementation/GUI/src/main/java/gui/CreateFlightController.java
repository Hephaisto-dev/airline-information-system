package gui;

import businesslogic.api.airplane.AirplaneFactory;
import businesslogic.api.airport.AirportFactory;
import businesslogic.api.flight.Flight;
import businesslogic.api.flight.FlightCreator;
import businesslogic.api.flight.FlightFactory;
import businesslogic.api.manager.FlightManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * FXML Create Flight Controller class.
 * The controller class contains GUI-logic (no business logic!). It reacts on
 * GUI events like button clicks. It triggers the BusinessLogic layer
 * to do the real work. Furthermore the controller will trigger navigation
 * and update the GUI.
 *
 * @author Mathias Filliol
 */
public class CreateFlightController implements Initializable {

    private final Supplier<SceneManager> sceneManagerSupplier;

    private final FlightManager flightManager;

    private FlightCreator flightCreator;

    @FXML
    public TextField departurePlace;
    @FXML
    public TextField arrivalPlace;
    @FXML
    public TextField deparureLocalDateTime;
    @FXML
    public TextField arrivalLocalDateTime;
    @FXML
    public TextField airplaneName;
    @FXML
    public Button createButton;
    @FXML
    private Label result;

    public CreateFlightController(Supplier<SceneManager> sceneManagerSupplier, FlightManager flightManager) {
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.flightManager = flightManager;
        this.flightCreator = new FlightCreator(flightManager);
    }

    @FXML
    private void toSecondary() {
        Consumer<SecondaryController> consumer
                = (c) -> c.setPreviousView("Customer");
        sceneManagerSupplier.get().changeScene("secondary", consumer);
    }

    @FXML
    public void createFlight(ActionEvent actionEvent) {
        String output = sendFlight(departurePlace.getText(),
                arrivalPlace.getText(),
                deparureLocalDateTime.getText(),
                arrivalLocalDateTime.getText(),
                airplaneName.getText());
        result.setText(output);
    }

    public String sendFlight(String departPlace, String arrivePlace, String departLDT, String arriveLDT, String planeName){
        return flightCreator.createFlight(departPlace, arrivePlace, departLDT, arriveLDT, planeName);
    }


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
