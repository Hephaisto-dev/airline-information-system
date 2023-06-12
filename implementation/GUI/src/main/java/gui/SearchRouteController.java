package gui;

import businesslogic.api.manager.RouteManager;
import businesslogic.api.route.Route;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class SearchRouteController implements Initializable {
    private final RouteManager routeManager;

    @FXML
    private TextField searchForRoute;


    @FXML
    private TableView<Route> routeTableView;
    @FXML
    private TableColumn<Route, String> routeIDColumn;
    @FXML
    private TableColumn<Route, String> flightIDColumn;
    @FXML
    private TableColumn<Route, Integer> transitTimeColumn;
    @FXML
    private TableColumn<Route, Integer> priceColumn;


    @FXML
    private Button delete;
    @FXML
    private Label result;

    private FilteredList<Route> routeFilteredList;

    public SearchRouteController(RouteManager routeManager) {
        this.routeManager = routeManager;
    }


//    @FXML
//    public void onSearch(){
//        String lowerCase = searchForRoute.getText().toLowerCase();
//        routeFilteredList.setPredicate(route ->
//                route.getId().toLowerCase().contains(lowerCase) ||
//                        route.getRouteData().flightIds().toLowerCase().contains(lowerCase));
//    }
    private void updateRouteListView(){
        routeFilteredList = new FilteredList<>(FXCollections.observableArrayList(routeManager.getAll()));
        routeTableView.setItems(routeFilteredList);

        routeIDColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
//        flightIDColumn.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().getFlightIds()));
//        transitTimeColumn.setCellValueFactory(cellData -> {
//            int transitTime = (int) cellData.getValue().getFlightTransitTime();
//            return new SimpleIntegerProperty(transitTime).asObject();
//        });
        //priceColumn.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().getPrice()));
    }
//    public void onDelete(){
//        ObservableList<Route> selectedItems = routeTableView.getSelectionModel().getSelectedItems();
//        boolean success = false;
//        for(Route route: selectedItems){
//            success = route.delete() || success;
//        }
//        if (success) {
//            updateRouteListView();
//            result.setText("Successfully deleted route(s)");
//        } else {
//            result.setText("Failed to delete route(s)");
//        }
//    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateRouteListView();
    }
}
