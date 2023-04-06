package gui;

import businesslogic.api.flight.FlightCreator;
import businesslogic.api.manager.FlightManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
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
    @FXML
    public TextField departurePlace;
    @FXML
    public TextField arrivalPlace;
    @FXML
    public DatePicker deparureLocalDateTime;
    @FXML
    public DatePicker arrivalLocalDateTime;
    @FXML
    public TextField airplaneName;
    @FXML
    public Button createButton;
    private final FlightCreator flightCreator;
    @FXML
    private Label result;

    @FXML
    private ComboBox<String> depHour;
    @FXML
    private ComboBox<String> depMin;
    @FXML
    private ComboBox<String> arriHour;
    @FXML
    private ComboBox<String> arriMin;


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
                deparureLocalDateTime.getValue().toString() + "T" + depHour.getValue() + ":" + depMin.getValue(),
                arrivalLocalDateTime.getValue().toString() + "T" + arriHour.getValue() + ":" + arriMin.getValue(),
                airplaneName.getText());
        result.setText(output);
    }

    public String sendFlight(String departPlace, String arrivePlace, String departLDT, String arriveLDT,
                             String planeName) {
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
        for (int i = 0; 12 > i; i++) {
            if (i < 10) {
                arriHour.getItems().add("0" + i);
            } else {
                arriHour.getItems().add(String.valueOf(i));
            }


        }
        for (int c = 0; 60 > c; c++) {
            if (c < 10) {
                arriMin.getItems().add("0" + c);
            } else {
                arriMin.getItems().add(String.valueOf(c));
            }


        }
        for (int d = 0; 12 > d; d++) {
            if (d < 10) {
                depHour.getItems().add("0" + d);
            } else {
                depHour.getItems().add(String.valueOf(d));
            }


        }
        for (int q = 0; 60 > q; q++) {
            if (q < 10) {
                depMin.getItems().add("0" + q);
            } else {
                depMin.getItems().add(String.valueOf(q));
            }


        }

    }

}
