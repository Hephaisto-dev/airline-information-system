package gui;

import businesslogic.api.flight.Flight;
import businesslogic.api.manager.FlightManager;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class SearchFlightController implements Initializable {

    private final FlightManager flightManager;
    private FilteredList<Flight> flightFilteredList;


    @FXML
    private Label result;
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
                        flight.getData().departureAirportId().toLowerCase().contains(lowerCase) ||
                        flight.getData().arrivalAirportId().toLowerCase().contains(lowerCase) ||
                        flight.getETD().toString().toLowerCase().contains(lowerCase) ||
                        flight.getETA().toString().toLowerCase().contains(lowerCase) ||
                        String.valueOf(flight.getFlightDuration()).toLowerCase().contains(lowerCase) ||
                        flight.getData().airplaneId().toLowerCase().contains(lowerCase));
    }

    private void updateFlightList() {
        flightFilteredList = new FilteredList<>(FXCollections.observableArrayList(flightManager.getAll()));
        flightTableView.setItems(flightFilteredList);

        id.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        from.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getData().departureAirportId()));
        to.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getData().arrivalAirportId()));
        etd.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getETD().toString()));
        eta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getETA().toString()));
        duration.setCellValueFactory(cellData -> {
            int flightDuration = (int) cellData.getValue().getFlightDuration().toSeconds();
            return new SimpleIntegerProperty(flightDuration).asObject();
        });
        airplane.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAirplane().getId()));
    }

    public void onDelete() {
        ObservableList<Flight> selectedItems = flightTableView.getSelectionModel().getSelectedItems();
        boolean success = false;
        for (Flight selectedItem : selectedItems) {
            success = selectedItem.delete() || success;
        }
        if (success) {
            updateFlightList();
            result.setText("Successfully deleted flight(s)");
        } else {
            result.setText("Failed to delete flight(s)");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateFlightList();

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





