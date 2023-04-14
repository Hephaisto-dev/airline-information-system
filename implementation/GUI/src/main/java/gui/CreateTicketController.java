package gui;

import businesslogic.api.customer.TicketCreator;
import businesslogic.api.flight.Flight;
import businesslogic.api.manager.FlightManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.util.Set;

public class CreateTicketController {
    private final FlightManager flightManager;
    public AnchorPane AnchorPaneView;


    @FXML
    ComboBox<Flight> FlightSelector;
    @FXML
    TextField SeatRowGet;
    @FXML
    TextField SeatColumnGet;
    @FXML
    TextField CustomerNameGet;
    @FXML
    TextField feedbackField;
    @FXML
    Button TicketButton;

    public CreateTicketController(FlightManager flightManager) {
        this.flightManager = flightManager;
    }

    public void initialize(){
        Set<Flight> FlightList = flightManager.getAll();
        for(Flight flighter: FlightList){
            FlightSelector.getItems().add(flighter);
        }
    }


    @FXML
    protected void onCreateTicketPress(ActionEvent e){
        //
        Flight flight = FlightSelector.getValue();
        String seatRow = SeatRowGet.getText();
        String seatColumn = SeatColumnGet.getText();
        String customerName = CustomerNameGet.getText();
        feedbackField.clear();
        feedbackField.appendText(useInfo(flight, seatRow, seatColumn, customerName));
    }

    protected String useInfo(Flight f, String row, String column, String name){
        TicketCreator tc = new TicketCreator();
        return tc.createTicket(f,row,column,name);
    }
}
