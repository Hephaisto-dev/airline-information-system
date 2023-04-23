package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class NavBarController implements Initializable {
    //Main menu bar
    @FXML
    private MenuBar mainMenuBar;


    //Home page
    @FXML
    private Menu homeMenu;
    @FXML
    private MenuItem homePage;


    //Flight Menu and all flight options
    @FXML
    private Menu flightMenu;
    @FXML
    private MenuItem createFlight;
    @FXML
    private MenuItem editFlight;
    @FXML
    private MenuItem searchForFlight;
    @FXML
    private MenuItem viewFlightInformation;
    @FXML
    private MenuItem viewPreviousFlights;


    //Route menu and all its options
    @FXML
    private Menu routeMenu;
    @FXML
    private MenuItem createRoute;
    @FXML
    private MenuItem editRoute;
    @FXML
    private MenuItem searchForRoute;


    //Airport and all its options
    @FXML
    private Menu airportMenu;
    @FXML
    private MenuItem createAirport;
    @FXML
    private MenuItem editAirport;


    //Booking and all its options
    @FXML
    private Menu bookingMenu;
    @FXML
    private MenuItem createBooking;
    @FXML
    private MenuItem editBooking;
    @FXML
    private MenuItem searchForBooking;


    //Ticket and all its options
    @FXML
    private Menu ticketMenu;
    @FXML
    private MenuItem createTicket;
    @FXML
    private MenuItem editTicket;
    @FXML
    private MenuItem purchaseTicket;


    //Customer and all its options
    @FXML
    private Menu customerMenu;
    @FXML
    private MenuItem registerCustomer;
    @FXML
    private MenuItem editCustomer;


    //Management and all its options
    @FXML
    private Menu managementMenu;
    @FXML
    private MenuItem financialSheet;
    @FXML
    private MenuItem statistics;
    @FXML
    private MenuItem registerEmployee;
    @FXML
    private MenuItem startSalesProcess;

    private final Supplier<SceneManager> sceneManagerSupplier;
    public NavBarController(Supplier<SceneManager> sceneManagerSupplier){
        this.sceneManagerSupplier = sceneManagerSupplier;
    }
    //left customerView
    public void sendToHomePage(ActionEvent actionEvent) {
        sceneManagerSupplier.get().changeScene("mainGUI");
    }

    public void sendToCreateFlight(ActionEvent actionEvent) {
        sceneManagerSupplier.get().changeScene("createFlightView");
    }
    public void sendToEditFlight(ActionEvent actionEvent) {

    }
    public void sendToSearchForFlight(ActionEvent actionEvent) {
        sceneManagerSupplier.get().changeScene("searchFlightView");
    }
    public void sendToViewFlightInformation(ActionEvent actionEvent) {

    }
    public void sendToViewPreviousFlights(ActionEvent actionEvent) {

    }


    public void sendToCreateRoute(ActionEvent actionEvent) {

    }
    public void sendToEditRoute(ActionEvent actionEvent) {

    }
    public void sendToSearchForRoute(ActionEvent actionEvent) {

    }


    public void sendToCreateAirport(ActionEvent actionEvent) {
        sceneManagerSupplier.get().changeScene("createAirportView");
    }
    public void sendToEditAirport(ActionEvent actionEvent) {

    }


    public void sendToCreateBooking(ActionEvent actionEvent) {
        sceneManagerSupplier.get().changeScene("createBookingView");
    }
    public void sendToEditBooking(ActionEvent actionEvent) {

    }
    public void sendToSearchForBooking(ActionEvent actionEvent) {
        sceneManagerSupplier.get().changeScene("searchBookingView");
    }


    public void sendToCreateTicket(ActionEvent actionEvent) {
        sceneManagerSupplier.get().changeScene("createTicketView");
    }
    public void sendToEditTicket(ActionEvent actionEvent) {

    }
    public void sendToPurchaseTicket(ActionEvent actionEvent) {

    }


    public void sendToRegisterCustomer(ActionEvent actionEvent) {

    }
    public void sendToEditCustomer(ActionEvent actionEvent) {

    }


    public void sendToFinancialSheet(ActionEvent actionEvent) {

    }
    public void sendToStatistics(ActionEvent actionEvent) {

    }
    public void sendToRegisterEmployee(ActionEvent actionEvent) {

    }
    public void sendToStartSalesProcess(ActionEvent actionEvent) {

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //When the login is done the role-type will be gathered from DB and
        //depending on the role-type different options will be visible
        //role-types can be either a string or int

        //what about all the cancel options - take a look at the gui and give feedback
        //also look at who does what and fix the analysis - should the search for... be an option in itself
        //also test visibility of the menu
        //Change every Anchor pane to Border pane - to display the navbar
        //include the navbar on every page
        //make it dynamic - resizable - either in fxml or css file(if css where do I put it and make it apply for all files)

        String permission = "salesOfficer/1-allVisibleTest";

//        createFlight.setVisible(false);
//        editFlight.setVisible(false);
        searchForFlight.setVisible(false);
        viewFlightInformation.setVisible(false);
        viewPreviousFlights.setVisible(false);

        //createRoute.setVisible(false);
        //editRoute.setVisible(false);
        searchForRoute.setVisible(false);

        createAirport.setVisible(false);
        editAirport.setVisible(false);

//        createBooking.setVisible(false);
//        editBooking.setVisible(false);
//        searchForBooking.setVisible(false);

        createTicket.setVisible(false);
        editTicket.setVisible(false);
        purchaseTicket.setVisible(false);

//        registerCustomer.setVisible(false);
//        editCustomer.setVisible(false);

//        financialSheet.setVisible(false);
//        statistics.setVisible(false);
//        registerEmployee.setVisible(false);
//        startSalesProcess.setVisible(false);

        switch (permission){
            case "salesOfficer":
                createRoute.setVisible(true);
                editRoute.setVisible(true);
                createFlight.setVisible(true);
                editFlight.setVisible(true);

                startSalesProcess.setVisible(true);
                break;
            case "salesManager":
                financialSheet.setVisible(true);
                statistics.setVisible(true);
                registerEmployee.setVisible(true);
                break;
            case "salesEmployee":
                createBooking.setVisible(true);
                editBooking.setVisible(true);
                searchForBooking.setVisible(true);

                registerCustomer.setVisible(true);
                editCustomer.setVisible(true);
                break;
            default:
                createFlight.setVisible(true);
                editFlight.setVisible(true);
                searchForFlight.setVisible(true);
                viewFlightInformation.setVisible(true);
                viewPreviousFlights.setVisible(true);

                createRoute.setVisible(true);
                editRoute.setVisible(true);
                searchForRoute.setVisible(true);

                createAirport.setVisible(true);
                editAirport.setVisible(true);

                createBooking.setVisible(true);
                editBooking.setVisible(true);
                searchForBooking.setVisible(true);

                createTicket.setVisible(true);
                editTicket.setVisible(true);
                purchaseTicket.setVisible(true);

                registerCustomer.setVisible(true);
                editCustomer.setVisible(true);

                financialSheet.setVisible(true);
                statistics.setVisible(true);
                registerEmployee.setVisible(true);
                break;
        }
    }
}
