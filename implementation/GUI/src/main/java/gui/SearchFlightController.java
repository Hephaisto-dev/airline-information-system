package gui;

import businesslogic.api.flight.Flight;
import businesslogic.api.manager.FlightManager;
import datarecords.FlightData;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SearchFlightController implements Initializable {

    private final FlightManager flightManager;
    private FilteredList<Flight> flightFilteredList;

    @FXML
    private TableView<Flight> flightTableView;
    @FXML
    private TableColumn<Flight, String> id;
    @FXML
    private TableColumn<Flight, String> from;
    @FXML
    private TableColumn<Flight, String> to;
    @FXML
    private TableColumn<Flight, String> etd;
    @FXML
    private TableColumn<Flight, String> eta;
    @FXML
    private TableColumn<Flight, Integer> duration;
    @FXML
    private TableColumn<Flight, String> airplane;
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
        flightTableView.setItems(flightFilteredList);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateFlightList();
        id.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        from.setCellValueFactory(cellData -> cellData.getValue().fromProperty());
        to.setCellValueFactory(cellData -> cellData.getValue().toProperty());
        etd.setCellValueFactory(cellData -> cellData.getValue().etdProperty());
        eta.setCellValueFactory(cellData -> cellData.getValue().etaProperty());
        duration.setCellValueFactory(cellData -> cellData.getValue().durationProperty().asObject());
        airplane.setCellValueFactory(cellData -> cellData.getValue().airplaneProperty());
    }
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
