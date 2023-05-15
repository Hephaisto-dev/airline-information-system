package gui;

import businesslogic.api.booking.BookingCreator;
import businesslogic.api.customer.Price;
import businesslogic.api.employee.Employee;
import businesslogic.api.flight.Flight;
import businesslogic.api.flight.FlightFactory;
import businesslogic.api.manager.BookingManager;
import businesslogic.api.manager.FlightManager;
import datarecords.CustomerData;
import datarecords.FlightData;
import datarecords.TicketData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import persistence.api.NoDBConnectionException;
import utilities.FxUtilTest;

import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;


public class CreateBookingController implements Initializable {

    final ArrayList<String> extras = new ArrayList<>();
    final ArrayList<CustomerData> customers = new ArrayList<>();
    final List<TicketData> tickets = new ArrayList<>();//Change this from string to Ticket
    final FlightData selectedFlight = null;
    final BookingManager bookingManager;
    private final BookingCreator bookingCreator;
    private final Supplier<SceneManager> sceneManagerSupplier;
    //TODO IMPLEMENT TICKETS
    @FXML
    public ComboBox<Employee> employeeComboBox;
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
    private BookingCreator bookCreator;


    public CreateBookingController(Supplier<SceneManager> sceneManagerSupplier, BookingManager bookingManager) {
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.bookingManager = bookingManager;
        this.bookingCreator = new BookingCreator(bookingManager);
    }

    @FXML
    public void createBooking(ActionEvent actionEvent) {

        String booking = bookingCreator.createBooking("1",employeeComboBox.getSelectionModel().getSelectedItem().getData(), selectedFlight, tickets, LocalDate.now(), extras, customers);
        result.setText(booking);

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

    public List<TicketData> createTickets() {
        for (CustomerData customer : customers) {  //TODO ADD REAL TICKET IMPLEMENTATION

            //tickets.add(new TicketImpl(customer.firstName(),cbFlights.getValue(),));
        }
        return tickets;
    }

    @FXML
    public void fakeInfo(ActionEvent actionEvent) throws NoDBConnectionException {
        Flight flight = FlightFactory.createFlight(new FlightData("1", LocalDateTime.now(), LocalDateTime.now(), Duration.ZERO, "1", "2", "3"));

        cbFlights.getItems().add(flight);

    }

    @FXML
    public void updatePrice(ActionEvent actionEvent) {

        if (cbFlights.getValue() != null) {
            int total = 0;
            Price perPerson = cbFlights.getValue().getPrice();
            for (CustomerData c : customers) {

                total = total + perPerson.getBackendPrice() / 100;
            }
            for (String x : extras) {
                total = total + 15;
            }
            String currency = perPerson.toString().replace("1", "").replace("2", "").replace("3", "").replace("4", "").replace("5", "").replace("6", "").replace("7", "").replace("8", "").replace("9", "").replace("0", "").replace(",", "").replace(".", "");//TODO change this after implementation of new prices

            totalToPay.setText(Integer.toString(total) + " " + currency);
            pricePerPerson.setText(perPerson.toString());
        } else {
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
