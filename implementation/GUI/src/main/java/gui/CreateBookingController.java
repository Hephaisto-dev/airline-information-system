package gui;

import businesslogic.api.airplane.Airplane;
import businesslogic.api.airplane.AirplaneFactory;
import businesslogic.api.airport.Airport;
import businesslogic.api.airport.AirportFactory;
import businesslogic.api.booking.BookingCreator;
import businesslogic.api.customer.Price;
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
import persistence.api.NoDBConnectionException;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Supplier;


public class CreateBookingController implements Initializable {

    final ArrayList<String> extras = new ArrayList<>();
    final ArrayList<CustomerData> customers = new ArrayList<>();
    final ArrayList<String> tickets = new ArrayList<>();//Change this from string to Ticket
    final FlightData selectedFlight = null;
    final BookingManager bookingManager;
    private final BookingCreator bookingCreator;
    //TODO IMPLEMENT TICKETS
    @FXML
    public TextField empId;
    @FXML
    public ComboBox<Flight> cbFlights;
    @FXML
    public ComboBox<String> cbExtras;
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
    public ListView<String> listViewCustomers;
    @FXML
    public Button btnAddCustomer;
    @FXML//TODO Delete this after connection with the database
    public Button btnFakeInfo;
    @FXML
    public ListView<String> listViewExtras;
    @FXML
    public Text result;
    @FXML
    public Text totalToPay;
    @FXML
    public Text pricePerPerson;
    @FXML
    private Button BtnBack;

    private BookingCreator bookCreator;
    private final Supplier<SceneManager> sceneManagerSupplier;




    public CreateBookingController(Supplier<SceneManager> sceneManagerSupplier, BookingManager bookingManager) {
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.bookingManager = bookingManager;
        this.bookingCreator = new BookingCreator(bookingManager);
    }

    @FXML
    public void createBooking(ActionEvent actionEvent) {

        String booking = bookingCreator.createBooking("1", empId.getText(), selectedFlight, tickets, LocalDateTime.now(), extras, customers);
        result.setText(booking);

    }
    @FXML
    public void BackToMain(ActionEvent actionEvent) {

        sceneManagerSupplier.get().changeScene("mainGUI");

    }

    @FXML
    public void addCustomer(ActionEvent actionEvent) {

        customers.add(new CustomerData("1", firstName.getText(), lastName.getText(), dateOfBirth.getValue(), email.getText()));
        listViewCustomers.getItems().clear();
        for (CustomerData c : customers)
            listViewCustomers.getItems().add(c.toString());

    }

    @FXML
    public void addExtra(ActionEvent actionEvent) {

        if (cbExtras.getValue() != null) {
            extras.add(cbExtras.getValue());
            listViewExtras.getItems().clear();
            for (String s : extras) {
                listViewExtras.getItems().add(s);
            }
        }
    }

    public List<String> createTickets() {
        for (CustomerData customer : customers) {  //TODO ADD REAL TICKET IMPLEMENTATION


            //tickets.add(new TicketImpl(customer.firstName(),cbFlights.getValue(),));
            tickets.add(customer.firstName());
        }


        return tickets;
    }

    @FXML
    public void fakeInfo(ActionEvent actionEvent) throws NoDBConnectionException {
        Airplane airplane = AirplaneFactory.createAirplane("1", "KML 332", 322, 322);
        Airport airport1 = AirportFactory.createAirport("1", "MyHouse", "Netherlands");
        Airport airport2 = AirportFactory.createAirport("2", "YourHouse", "Netherlands");


        Flight flight = FlightFactory.createFlight(airport1, airport2, LocalDateTime.now(), LocalDateTime.now().plusDays(1), airplane);

        cbFlights.getItems().add(flight);

    }
    @FXML
    public void updatePrice(ActionEvent actionEvent){

        if(cbFlights.getValue()!=null){
            int total = 0;
            Price perPerson = cbFlights.getValue().getPrice();
            for (CustomerData c: customers) {

                total = total + perPerson.getBackendPrice()/100;
            }
            for(String x: extras){
                total = total + 15;
            }
            String currency = perPerson.toString().replace("1","").replace("2","").replace("3","").replace("4","").replace("5","").replace("6","").replace("7","").replace("8","").replace("9","").replace("0","").replace(",","").replace(".","");//TODO change this after implementation of new prices

            totalToPay.setText(Integer.toString(total)+" "+ currency);
            pricePerPerson.setText(perPerson.toString());
        }else {
            totalToPay.setText("no flight selected!");
        }

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
