package gui;

import businesslogic.api.booking.BookingCreator;
import businesslogic.api.customer.Price;
import businesslogic.api.employee.Employee;
import businesslogic.api.flight.Flight;
import businesslogic.api.manager.*;
import datarecords.CustomerData;
import datarecords.FlightData;
import datarecords.TicketData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Supplier;


public class CreateBookingController implements Initializable {

    final ArrayList<String> extras = new ArrayList<>();
    ArrayList<CustomerData> customers = new ArrayList<>();
    private CustomerData MainCustomer;
    final List<TicketData> tickets = new ArrayList<>();//Change this from string to Ticket
    final FlightData selectedFlight = null;
    final BookingManager bookingManager;
    private final BookingCreator bookingCreator;
    private final Supplier<SceneManager> sceneManagerSupplier;
    @FXML
    public ComboBox<Employee> employeeComboBox;
    @FXML
    public ComboBox<Flight> cbFlights;
    @FXML
    public ComboBox<String> cbExtras;
    @FXML
    public Button btnCreateBooking;
    @FXML
    public TextField empId;
    @FXML
    public TextField tfArri;
    @FXML
    public TextField tfDep;
    @FXML
    public TextField firstName;
    @FXML
    public TextField passengerName;
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
    @FXML
    public Label lblMainCustomer;
    @FXML
    public ListView<String> listViewExtras;
    @FXML
    public Text result;
    @FXML
    public Text totalToPay;
    @FXML
    public ListView<Flight> lvFlights;

    Collection<Flight> filteredFlights = new ArrayList<Flight>();
    Collection<Flight> allFlights = new ArrayList<Flight>();

    @FXML
    public Text pricePerPerson;
    private BookingCreator bookCreator;
    private FlightManager flightManager;
    private AirportManager airportManager;




    public CreateBookingController(Supplier<SceneManager> sceneManagerSupplier, BookingManager bookingManager, FlightManager flightManager, AirportManager airportManager, TicketManager ticketManager, CustomerManager customerManager) {
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.bookingManager = bookingManager;
        this.bookingCreator = new BookingCreator(bookingManager,ticketManager,customerManager);
        this.flightManager = flightManager;
        this.airportManager= airportManager;
    }

    @FXML
    public void createBooking(ActionEvent actionEvent) {


        String booking = bookingCreator.createBooking(lvFlights.getSelectionModel().getSelectedItem().toString()+MainCustomer.firstName()+MainCustomer.lastName(),empId.getText(), lvFlights.getSelectionModel().getSelectedItem().getData(), tickets, LocalDate.now(), extras, customers,MainCustomer);
        result.setText(booking);

    }

    @FXML
    public void addCustomer(ActionEvent actionEvent) {

        MainCustomer = new CustomerData("CU_" + email.getText(), firstName.getText(), lastName.getText(), dateOfBirth.getValue(), email.getText());
        lblMainCustomer.setText(MainCustomer.firstName()+" "+MainCustomer.lastName());
        btnAddCustomer.setDisable(true);
    }
    @FXML
    public void addCustomerWithTicket(ActionEvent actionEvent) {

        MainCustomer = new CustomerData("CU_" + email.getText(), firstName.getText(), lastName.getText(), dateOfBirth.getValue(), email.getText());
        listViewCustomers.getItems().add(MainCustomer.firstName()+" "+MainCustomer.lastName());
        btnAddCustomer.setDisable(true);
    }
    @FXML
    public void search(ActionEvent actionEvent){
        filteredFlights.clear();
        for(Flight f: allFlights){
            if(f.getArrival().getName().contains(tfArri.getText())&&f.getDeparture().getName().contains(tfDep.getText())){

                filteredFlights.add(f);
            }
        }
        lvFlights.getItems().clear();
        lvFlights.getItems().addAll(filteredFlights);

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


    @FXML
    public void addPassengerToBooking(){
        if(firstName.getText()!=null){

            customers.add(new CustomerData("CU_" + email.getText(), firstName.getText(), lastName.getText(), dateOfBirth.getValue(), email.getText()));

        }
        listViewCustomers.getItems().clear();
        for(CustomerData c : customers){
            listViewCustomers.getItems().add(c.firstName()+" "+c.lastName());
        }

    }

    @FXML
    public void updatePrice(ActionEvent actionEvent) {

        if (lvFlights.getSelectionModel().getSelectedItem() != null) {
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
        allFlights = flightManager.getAll();
        lvFlights.getItems().addAll(allFlights);
        result.setText("");
    }
}
