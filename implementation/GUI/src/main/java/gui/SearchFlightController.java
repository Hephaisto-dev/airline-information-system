package gui;

import businesslogic.api.flight.Flight;
import businesslogic.api.manager.FlightManager;
import datarecords.FlightData;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SearchFlightController implements Initializable {

    private final FlightManager flightManager;
    private FilteredList<Flight> flightFilteredList;

    @FXML
    private ListView<Flight> flightListView;

    private ArrayList<FlightData> flightDataArrayList = new ArrayList<>();
    @FXML
    private TableColumn FlightID;
    @FXML
    private TableColumn Departure;
    @FXML
    private TableColumn Arrival;
    @FXML
    private TableColumn etd;
    @FXML
    private TableColumn eta;
    @FXML
    private TableColumn Duration;
    @FXML
    private TableColumn AirplaneID;

    @FXML
    private TextField searchField;
    public SearchFlightController(FlightManager flightManager) {
        this.flightManager = flightManager;
    }

    @FXML
    public void onSearch() {
        String lowerCase = searchField.getText().toLowerCase();
        flightFilteredList.setPredicate(flight ->
                flight.getId().toLowerCase().contains(lowerCase) ||
                        flight.getDeparture().getId().toLowerCase().contains(lowerCase) ||
                        flight.getArrival().getId().toLowerCase().contains(lowerCase) ||
                        flight.getETD().toString().toLowerCase().contains(lowerCase) ||
                        flight.getETA().toString().toLowerCase().contains(lowerCase) ||
                        String.valueOf(flight.getFlightDuration()).toLowerCase().contains(lowerCase) ||
                        flight.getAirplane().getId().toLowerCase().contains(lowerCase));
    }

    private void updateFlightList() {
        flightFilteredList = new FilteredList<>(FXCollections.observableArrayList(flightManager.getAll()));
        flightListView.setItems(flightFilteredList);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateFlightList();
    }

//
//    public void flightSearch() {
//        String lowerCase = searchField.getText().toLowerCase();
//        flightFilteredList.setPredicate(flight ->
//                flight.getId().toLowerCase().contains(lowerCase) ||
//                        flight.getDeparture().getId().toLowerCase().contains(lowerCase) ||
//                        flight.getArrival().getId().toLowerCase().contains(lowerCase) ||
//                        flight.getETD().toString().toLowerCase().contains(lowerCase) ||
//                        flight.getETA().toString().toLowerCase().contains(lowerCase) ||
//                        String.valueOf(flight.getFlightDuration()).toLowerCase().contains(lowerCase) ||
//                        flight.getAirplane().getId().toLowerCase().contains(lowerCase)
//        );
//
//        if (flightFilteredList.isEmpty()) {
//            // Give the error message that the flight could not be found
//            System.out.println("The flight could not be found.");
//        }
//    }




}
