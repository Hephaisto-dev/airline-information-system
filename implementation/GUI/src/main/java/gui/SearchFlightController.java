package gui;

import businesslogic.api.flight.Flight;
import businesslogic.api.manager.FlightManager;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class SearchFlightController {
    private final FlightManager flightManager;
    @FXML
    private ListView<Flight> flightListView;
    private FilteredList<Flight> flightFilteredList;

    @FXML
    private TextField searchField;

    @FXML
    private Button cancelButton;

    public SearchFlightController(FlightManager flightManager) {
        this.flightManager = flightManager;
    }

    public void flightSearch() {
        String lowerCase = searchField.getText().toLowerCase();
        flightFilteredList.setPredicate(flight ->
                flight.getId().toLowerCase().contains(lowerCase) ||
                        flight.getDeparture().getId().toLowerCase().contains(lowerCase) ||
                        flight.getArrival().getId().toLowerCase().contains(lowerCase) ||
                        flight.getETD().toString().toLowerCase().contains(lowerCase) ||
                        flight.getETA().toString().toLowerCase().contains(lowerCase) ||
                        String.valueOf(flight.getFlightDuration()).toLowerCase().contains(lowerCase) ||
                        flight.getAirplane().getId().toLowerCase().contains(lowerCase)
        );

        if (flightFilteredList.isEmpty()) {
            // Give the error message that the flight could not be found
            System.out.println("The flight could not be found.");
        }
    }



}
