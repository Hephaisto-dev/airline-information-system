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
    private TableView<Route> routeTableView;
    @FXML
    private TableColumn<Route, String> routeIDColumn;

    public SearchRouteController(RouteManager routeManager) {
        this.routeManager = routeManager;
    }


    private void updateRouteListView() {
        FilteredList<Route> routeFilteredList = new FilteredList<>(FXCollections.observableArrayList(routeManager.getAll()));
        routeTableView.setItems(routeFilteredList);

        routeIDColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateRouteListView();
    }
}
