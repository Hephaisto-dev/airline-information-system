package gui;

import businesslogic.api.airplane.AirplaneFactory;
import businesslogic.api.airport.AirportFactory;
import businesslogic.api.flight.Flight;
import businesslogic.api.flight.FlightFactory;
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

    public CreateFlightController(Supplier<SceneManager> sceneManagerSupplier) {
        this.sceneManagerSupplier = sceneManagerSupplier;
    }

    @FXML
    private void toSecondary() {
        Consumer<SecondaryController> consumer
                = (c) -> c.setPreviousView("Customer");
        sceneManagerSupplier.get().changeScene("secondary", consumer);
    }

    @FXML
    public void createFlight(ActionEvent actionEvent) {
        Flight flight = FlightFactory.createFlight(AirportFactory.createAirport(departurePlace.getText()),
                AirportFactory.createAirport(arrivalPlace.getText()),
                LocalDateTime.parse(deparureLocalDateTime.getText()),
                LocalDateTime.parse(arrivalLocalDateTime.getText()),
                AirplaneFactory.createAirplane(airplaneName.getText().toLowerCase().replace(' ', '-'),
                        airplaneName.getText(), 150));
        result.setText("Flight created!" + flight);
    }


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
