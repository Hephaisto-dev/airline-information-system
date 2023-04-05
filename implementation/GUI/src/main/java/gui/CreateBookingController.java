package gui;

import businesslogic.api.airplane.Airplane;
import businesslogic.api.airplane.AirplaneFactory;
import businesslogic.api.airport.Airport;
import businesslogic.api.airport.AirportFactory;
import businesslogic.api.booking.Booking;
import businesslogic.api.booking.BookingFactory;
import businesslogic.api.customer.Customer;

import businesslogic.api.booking.BookingCreator;

import businesslogic.api.flight.Flight;
import businesslogic.api.flight.FlightFactory;
import businesslogic.api.manager.BookingManager;

import datarecords.CustomerData;
import datarecords.FlightData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import persistence.NoDBConnectionException;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.Supplier;


public class CreateBookingController implements Initializable {
    ArrayList<String> extras = new ArrayList<>();
    ArrayList<CustomerData> customers = new ArrayList<>();
    ArrayList<String> tickets = new ArrayList<>();
    FlightData selectedFlight= null;

    //TODO IMPLEMENT TICKETS
    @FXML
    public TextField empId;
    @FXML
    public ComboBox cbFlights;
    @FXML
    public ComboBox cbExtras;
    @FXML
    public Button btnCreateBooking;
    @FXML
    public TextField firstName;
    @FXML
    public TextField lastName;
    @FXML
    public DatePicker dateOfBirth;
    @FXML
    public TextField email;
    @FXML
    public ListView listViewCustomers;
    @FXML
    public Button btnAddCustomer;
    @FXML//Delete this after connection with the database
    public Button btnFakeInfo;
    @FXML
    public ListView listViewExtras;
    @FXML
    public Text result;
    private BookingCreator bookCreator;
    private final Supplier<SceneManager> sceneManagerSupplier;
    private BookingCreator bookingCreator;
    BookingManager bookingManager;
    public CreateBookingController(Supplier<SceneManager> sceneManagerSupplier, BookingManager bookingManager) {
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.bookingManager = bookingManager;
        this.bookingCreator = new BookingCreator(bookingManager);
    }
    @FXML
    public void createBooking(ActionEvent actionEvent) {


       String booking = bookingCreator.CreateBooking("0", empId.getText(), selectedFlight, tickets, LocalDateTime.now(), extras, customers);
       result.setText(booking);

    }
    @FXML
    public void addCustomer(ActionEvent actionEvent) {

            //customers.add(new CustomerFactory(,));
            listViewExtras.getItems().clear();
            for(CustomerData c: customers)
                listViewExtras.getItems().add(c.toString());

    }
    @FXML
    public void addExtra(ActionEvent actionEvent) {

        if(cbExtras.getValue()!=null){
            extras.add(cbExtras.getValue().toString());
            listViewExtras.getItems().clear();
            for(String s: extras)
            listViewExtras.getItems().add(s);
    }
    }
    @FXML
    public void fakeInfo(ActionEvent actionEvent) throws NoDBConnectionException {
        Airplane airplane = AirplaneFactory.createAirplane("1","KML 332", 322);
        Airport airport1 = AirportFactory.createAirport("1","Myhouse","Amsterdam","Netherlands");
        Airport airport2 = AirportFactory.createAirport("2","YourHouse","Amsterdam","Netherlands");


        Flight flight = FlightFactory.createFlight(airport1,airport2,LocalDateTime.now(),LocalDateTime.now().plusDays(1),airplane);

        cbFlights.getItems().add(flight.toString());

    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbExtras.getItems().add("Extra leg space");
        cbExtras.getItems().add("vegetarian food");
        cbExtras.getItems().add("Extra luggage");
        cbExtras.getItems().add("Prepaid food");
        result.setText("");


    }
}
