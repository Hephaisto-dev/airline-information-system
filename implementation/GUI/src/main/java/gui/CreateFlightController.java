package gui;

import businesslogic.api.airplane.Airplane;
import businesslogic.api.airport.Airport;
import businesslogic.api.flight.FlightCreator;
import businesslogic.api.manager.AirplaneManager;
import businesslogic.api.manager.AirportManager;
import businesslogic.api.manager.FlightManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * FXML Create Flight Controller class.
 * The controller class contains GUI-logic (no business logic!). It reacts on
 * GUI events like button clicks. It triggers the BusinessLogic layer
 * to do the real work. Furthermore, the controller will trigger navigation
 * and update the GUI.
 *
 * @author Mathias Filliol
 */
public class CreateFlightController implements Initializable {

    private final Supplier<SceneManager> sceneManagerSupplier;
    private final AirportManager airportManager;
    private final AirplaneManager airplaneManager;
    private final FlightCreator flightCreator;
    @FXML
    public ComboBox<Airport> departureAirport;
    @FXML
    public ComboBox<Airport> arrivalAirport;
    @FXML
    public DatePicker departureLocalDate;
    @FXML
    public DatePicker arrivalLocalDate;
    @FXML
    public ComboBox<Airplane> airplaneComboBox;
    @FXML
    public Button createButton;
    @FXML
    private Label result;
    @FXML
    private Button BtnBack;

    @FXML
    private ComboBox<String> depHour;
    @FXML
    private ComboBox<String> depMin;
    @FXML
    private ComboBox<String> arriHour;
    @FXML
    private ComboBox<String> arriMin;


    public CreateFlightController(Supplier<SceneManager> sceneManagerSupplier, FlightManager flightManager, AirportManager airportManager, AirplaneManager airplaneManager) {
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.flightCreator = new FlightCreator(flightManager);
        this.airportManager = airportManager;
        this.airplaneManager = airplaneManager;
    }

    @FXML
    public void BackToMain(ActionEvent actionEvent) {

        sceneManagerSupplier.get().changeScene("mainGUI");

    }

    @FXML
    private void toSecondary() {
        Consumer<SecondaryController> consumer
                = (c) -> c.setPreviousView("Customer");
        sceneManagerSupplier.get().changeScene("secondary", consumer);
    }

    @FXML
    public void createFlight(ActionEvent actionEvent) {
        String output = sendFlight(departureAirport.getValue(),
                arrivalAirport.getValue(),
                departureLocalDate.getValue().toString() + "T" + depHour.getValue() + ":" + depMin.getValue(),
                arrivalLocalDate.getValue().toString() + "T" + arriHour.getValue() + ":" + arriMin.getValue(),
                airplaneComboBox.getValue());
        result.setText(output);
    }

    public String sendFlight(Airport departPlace, Airport arrivePlace, String departLDT, String arriveLDT,
                             Airplane planeName) {
        return flightCreator.createFlight(departPlace, arrivePlace, departLDT, arriveLDT, planeName);
    }


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        arriMin.setValue("00");
        arriHour.setValue("00");
        depMin.setValue("00");
        depHour.setValue("00");
        for (int hours = 0; hours < 24; hours++) {
            if (hours < 10) {
                arriHour.getItems().add("0" + hours);
                depHour.getItems().add("0" + hours);
            } else {
                arriHour.getItems().add(String.valueOf(hours));
                depHour.getItems().add(String.valueOf(hours));
            }
        }
        for (int minutes = 0; 60 > minutes; minutes++) {
            if (minutes < 10) {
                arriMin.getItems().add("0" + minutes);
                depMin.getItems().add("0" + minutes);
            } else {
                arriMin.getItems().add(String.valueOf(minutes));
                depMin.getItems().add(String.valueOf(minutes));
            }
        }
        airportManager.getAll().forEach(airport -> {
            departureAirport.getItems().add(airport);
            arrivalAirport.getItems().add(airport);
        });
        airplaneManager.getAll().forEach(airplane -> airplaneComboBox.getItems().add(airplane));
        //TODO change from string
        Utils.makeComboBoxSearchable(departureAirport, Airport::getName);
        Utils.makeComboBoxSearchable(arrivalAirport, Airport::getName);
        Utils.makeComboBoxSearchable(airplaneComboBox, Airplane::getId);

        departureLocalDate.setDayCellFactory(d ->
                new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        setDisable(item.isBefore(LocalDate.now()));
                    }
                });

        arrivalLocalDate.setDayCellFactory(d ->
                new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        setDisable(item.isBefore(departureLocalDate.getValue()));
                    }
                });
    }
}
