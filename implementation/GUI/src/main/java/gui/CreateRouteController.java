package gui;

import businesslogic.api.flight.Flight;
import businesslogic.api.manager.FlightManager;
import businesslogic.api.manager.RouteManager;
import businesslogic.api.route.RouteCreator;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.*;

public class CreateRouteController implements Initializable {

    private final RouteCreator routeCreator;


    private final FlightManager flightManager;
    @FXML
    private TableView<Flight> flightTableView;
    @FXML
    private TableColumn<Flight, String> flightID;
    @FXML
    private TableColumn<Flight, String> flightFrom;
    @FXML
    private TableColumn<Flight, String> flightTo;
    @FXML
    private TableColumn<Flight, String> flightETD;
    @FXML
    private TableColumn<Flight, String> flightETA;
    @FXML
    private TableColumn<Flight, Integer> flightDuration;
    @FXML
    private TableColumn<Flight, String> flightAirplane;
    @FXML
    private TableView<Flight> routeTableView;
    @FXML
    private TableColumn<Flight, String> routeID;
    @FXML
    private TableColumn<Flight, String> routeFrom;
    @FXML
    private TableColumn<Flight, String> routeTo;
    @FXML
    private TableColumn<Flight, String> routeETD;
    @FXML
    private TableColumn<Flight, String> routeETA;
    @FXML
    private TableColumn<Flight, Integer> routeDuration;
    @FXML
    private TableColumn<Flight, String> routeAirplane;
    @FXML
    private TableColumn<Flight, String> routeTransitTime;


    @FXML
    private TextField name;
    @FXML
    private TextField searchBar;
    @FXML
    private Button submit;
    @FXML
    private Label result;


    @FXML
    private Label originalPriceLabel;

    @FXML
    private Label currentPriceLabel;


    private int originalPrice;

    private final List<String> transitTimes = new ArrayList<>();
    private FilteredList<Flight> flightFilteredList;
    private Flight flightsInRoute;
    private final HashMap<Integer, String> transitTimeChanges = new HashMap<>();
    private final Map<String, Long> flightIdAndTransit = new HashMap<>();

    public CreateRouteController(FlightManager flightManager, RouteManager routeManager) {
        this.flightManager = flightManager;
        this.routeCreator = new RouteCreator(routeManager);
    }


    @FXML
    private void handleSubmit(ActionEvent event) {
        // Retrieve the first non-null element from the routeID column
        String firstRouteID = null;
        for (Flight flight : routeTableView.getItems()) {
            String routeID = flight.getId();
            if (routeID != null && !routeID.isEmpty()) {
                firstRouteID = routeID;
                break;
            }
        }

        // Retrieve the last non-null element from the routeID column
        String lastRouteID = null;
        for (int i = routeTableView.getItems().size() - 1; i >= 0; i--) {
            Flight flight = routeTableView.getItems().get(i);
            String routeID = flight.getId();
            if (routeID != null && !routeID.isEmpty()) {
                lastRouteID = routeID;
                break;
            }
        }
        String databaseId = firstRouteID + "------->" + lastRouteID;


        //Get the transit times and add them to the HashMap for later checks
        transitTimeChanges.forEach((positionInTable, value) -> transitTimes.add(value));


        List<Flight> rawTableData = routeTableView.getItems();

        //Create an ArrayList inside an ArrayList, iterate through the table data
        //if the position in the table is smaller than the size of the transit times
        //add them to the array and then to the multi array
        //if not then add a zero if the place is empty
        ArrayList<ArrayList<String>> tempRouteData = new ArrayList<>();
        for (int i = 0; i < rawTableData.size(); i++) {
            ArrayList<String> temp = new ArrayList<>();
            if (i < transitTimes.size()) {
                temp.add(rawTableData.get(i).toString());
                temp.add(transitTimes.get(i));
                tempRouteData.add(temp);
            } else {
                temp.add(rawTableData.get(i).toString());
                temp.add("0");
                tempRouteData.add(temp);
            }
        }


        //Add the values from the ArrayLists to the Map , transit times are computed through a special function
        //and returned as long
        for (ArrayList<String> tempRouteDatum : tempRouteData) {

            flightIdAndTransit.put(tempRouteDatum.get(0), computeSpecificTransit(tempRouteDatum.get(1)));
//            System.out.println(flightIdAndTransit.toString());
        }


        //Get all the prices of all the flights in the database from ticket , add them and display them
        flightIdAndTransit.forEach((key, value) -> {
            flightsInRoute = flightManager.getById(key);
            originalPrice += flightsInRoute.getPrice().getBackendPrice();
        });
        originalPriceLabel.setText("Original price: " + originalPrice);


        //reduce the price by 10% because the price of any route is always reduced by 10%
        int currentPrice = originalPrice - ((int) (originalPrice * 0.1));
        currentPriceLabel.setText("Current price: " + currentPrice);


        //get the name
        String nameForSpecialRoute = name.getText();

        try {
            String res = routeCreator.createRoute(nameForSpecialRoute, databaseId,
                    flightIdAndTransit, currentPrice, transitTimeChanges);
            result.setText(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //clear the routeTableView after a route has been added
        routeTableView.getItems().clear();
        originalPrice = 0;

    }

    public Long computeSpecificTransit(String transitTime) {
        // Convert and compute the transit times

        int temp = 0;

        if (transitTime.matches("\\d+h")) {
            int hours = Integer.parseInt(transitTime.replaceAll("\\D", ""));
            temp += hours * 60 * 60;
        } else if (transitTime.matches("\\d+d")) {
            int days = Integer.parseInt(transitTime.replaceAll("\\D", ""));
            temp += days * 1440 * 60;
        } else if (transitTime.matches("\\d+w")) {
            int weeks = Integer.parseInt(transitTime.replaceAll("\\D", ""));
            temp += weeks * 10080 * 60;
        }

        return (long) temp;
    }


    @FXML
    private void handleAddFlightToRoute(ActionEvent ignoredEvent) {

        Flight selectedFlight = flightTableView.getSelectionModel().getSelectedItem();
        //routeTo.getCellData(routeTableView.getItems().size()

        if (selectedFlight != null) {
            if (routeTableView.getItems().size() == 0
                    || routeTo.getCellData(routeTableView.getItems().size() - 1).equals(selectedFlight.getData().departureAirportId())) {

                String flightId = flightID.getCellData(selectedFlight);
                routeTableView.getItems().add(flightManager.getById(flightId));
            }
        }


    }

    //A METHOD TO FILTER THE TABLE VIEW
    @FXML
    public void onSearch() {
        String lowerCase = searchBar.getText().toLowerCase();
        flightFilteredList.setPredicate(flight ->
                flight.getId().toLowerCase().contains(lowerCase) ||
                        flight.getData().departureAirportId().toLowerCase().contains(lowerCase) ||
                        flight.getData().arrivalAirportId().toLowerCase().contains(lowerCase) ||
                        flight.getETD().toString().toLowerCase().contains(lowerCase) ||
                        flight.getETA().toString().toLowerCase().contains(lowerCase) ||
                        String.valueOf(flight.getFlightDuration()).toLowerCase().contains(lowerCase) ||
                        flight.getData().airplaneId().toLowerCase().contains(lowerCase));
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        routeID.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        routeFrom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getData().departureAirportId()));
        routeTo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getData().arrivalAirportId()));
        routeETD.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getETD().toString()));
        routeETA.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getETA().toString()));
        routeDuration.setCellValueFactory(cellData -> {
            int flightDuration = (int) cellData.getValue().getFlightDuration().toSeconds();
            return new SimpleIntegerProperty(flightDuration).asObject();
        });
        routeAirplane.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAirplane().getId()));


        //flight cell init
        flightFilteredList = new FilteredList<>(FXCollections.observableArrayList(flightManager.getAll()));
        flightTableView.setItems(flightFilteredList);

        flightID.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        flightFrom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getData().departureAirportId()));
        flightTo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getData().arrivalAirportId()));
        flightETD.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getETD().toString()));
        flightETA.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getETA().toString()));
        flightDuration.setCellValueFactory(cellData -> {
            int flightDuration = (int) cellData.getValue().getFlightDuration().toSeconds();
            return new SimpleIntegerProperty(flightDuration).asObject();
        });
        flightAirplane.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAirplane().getId()));


        routeTableView.setEditable(true);
        routeTransitTime.setCellFactory(TextFieldTableCell.forTableColumn()); // Enable editing for the routeTransitTime column

        routeTransitTime.setOnEditCommit(edited -> {
            if (transitTimeChanges.containsKey(edited.getTablePosition().getRow())) {
                transitTimeChanges.replace(edited.getTablePosition().getRow(), edited.getNewValue());
            } else {
                transitTimeChanges.put(edited.getTablePosition().getRow(), edited.getNewValue());
            }
        });

        submit.setOnAction(this::handleSubmit);
    }
}

