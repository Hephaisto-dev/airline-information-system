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

import java.util.Collection;

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
    TextField discountGet;
    @FXML
    TextField VoucherGet;
    @FXML
    Button TicketButton;
    public void initialize() {
        Collection<Flight> FlightList = flightManager.getAll();
        for (Flight flighter : FlightList) {
            FlightSelector.getItems().add(flighter);
        }
    }

    public CreateTicketController(FlightManager flightManager) {
        this.flightManager = flightManager;
    }




    @FXML
    protected void onCreateTicketPress(ActionEvent e) {
        Flight flight = FlightSelector.getValue();
        String seatRow = SeatRowGet.getText();
        String seatColumn = SeatColumnGet.getText();
        String customerName = CustomerNameGet.getText();
        String discountField = discountGet.getText();
        String voucherField = VoucherGet.getText();
        feedbackField.clear();
        feedbackField.appendText(useInfo(flight, seatRow, seatColumn, customerName,discountField, voucherField));
    }

    protected String useInfo(Flight f, String row, String column, String name, String discount, String voucher) {
        TicketCreator tc = new TicketCreator();
        return tc.createTicket(f, row, column, name, discount, voucher);
    }
}
