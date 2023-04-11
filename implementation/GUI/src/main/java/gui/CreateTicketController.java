package gui;

import businesslogic.api.airplane.SeatImpl;
import businesslogic.api.customer.TicketCreator;
import businesslogic.api.flight.Flight;
import datarecords.FlightData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import persistence.FlightStorageServiceImpl;

import java.util.List;

public class CreateTicketController {

    private final FlightStorageServiceImpl FSSI = new FlightStorageServiceImpl();
    public AnchorPane AnchorPaneView;


    @FXML
    ComboBox FlightSelector;
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
    public void initialize(){
        List<FlightData> FlightList = FSSI.getAll();
        for(FlightData flighter: FlightList){
            FlightSelector.getItems().add(flighter);
        }
    }


    @FXML
    protected void onCreateTicketPress(ActionEvent e){
        //
        Flight flight = (Flight) FlightSelector.getValue();
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
