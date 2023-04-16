package gui;

import businesslogic.api.flight.Flight;
import businesslogic.api.manager.FlightManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class SearchFlightController {
    private final FlightManager flightManager;
    @FXML
    private ListView<Flight> flightListView;
    private FilteredList<Flight> flightFilteredList;

    public TableView<Flight> Table;
    public TableColumn FlightID;
    public TableColumn Departure;
    public TableColumn Arrival;
    public TableColumn etd;
    public TableColumn eta;
    public TableColumn Duration;
    public TableColumn AirplaneID;

    @FXML
    private TextField searchField;



    public void initializer() {
        final ObservableList<Flight> flightObservableList = FXCollections.observableArrayList();

        this.FlightID.setCellFactory(new PropertyValueFactory<>("id"));
        this.Departure.setCellFactory(new PropertyValueFactory<>("departure"));
        this.Arrival.setCellFactory(new PropertyValueFactory<>("arrival"));
        this.etd.setCellFactory(new PropertyValueFactory<>("etdDateTime"));
        this.eta.setCellFactory(new PropertyValueFactory<>("etaDateTime"));
        this.Duration.setCellFactory(new PropertyValueFactory<>("flightDuration"));
        this.AirplaneID.setCellFactory(new PropertyValueFactory<>("airplane"));
        this.Table.setItems(this.flightFilteredList);


    }

    private void searchFilter() {
        FilteredList<Flight> filterData = new FilteredList(this.flightFilteredList, (e) -> {
            return true;
        });
        this.searchField.setOnKeyReleased((e) -> {
            this.searchField.textProperty().addListener((observable, oldValue, newValue) -> {
                filterData.setPredicate((cust) -> {
                    if (newValue == null) {
                        return true;
                    } else {
                        String toLowerCaseFilter = newValue.toLowerCase();
                        if (cust.getId().contains(newValue)) {
                            return true;
                        } else if (cust.getId().toLowerCase().contains(toLowerCaseFilter)) {
                            return true;
                        } else if (cust.getDeparture().getId().toLowerCase().contains(toLowerCaseFilter)) {
                            return true;
                        } else if (cust.getArrival().getId().toLowerCase().contains(toLowerCaseFilter)) {
                            return true;
                        } else if (cust.getETD().toString().toLowerCase().contains(toLowerCaseFilter)) {
                            return true;
                        } else if (cust.getETA().toString().toLowerCase().contains(toLowerCaseFilter)) {
                            return true;
                        } else if (cust.getFlightDuration().toString().toLowerCase().contains(toLowerCaseFilter)) {
                            return true;
                        } else {
                            return cust.getArrival().getId().toLowerCase().contains(toLowerCaseFilter);
                        }
                    }
                });
            });
            SortedList<Flight> flightSortedList = new SortedList<>(filterData);
            flightSortedList.comparatorProperty().bind(this.Table.comparatorProperty());
            this.Table.setItems(flightSortedList);
        });
    }
    public SearchFlightController(FlightManager flightManager) {
        this.flightManager = flightManager;
    }

//    private void setFlight() {
//        FlightStorageServiceImpl flightStorageService = new FlightStorageServiceImpl(); // create an instance of the class
//        Set<FlightData> flightData = flightStorageService.getAll(id, etd, eta, airplane, departureAirport, arrivalAirport);
//
//    }

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
