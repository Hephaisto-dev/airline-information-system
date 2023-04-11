package gui;

import datarecords.FlightData;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SearchFlightController {

        @FXML
        private TableView<FlightData> Table;

        @FXML
        private TableColumn<?, String> flightID;
        private TableColumn<?, String> routeDataFrom;
        private TableColumn<?, String> routeDataToo0;
        private TableColumn<?, String> etdDateTime;
        private TableColumn<?, String> etaDateTime;
        private TableColumn<?, Integer> flightDuration;
        private TableColumn<?, String> airplaneId;



}
