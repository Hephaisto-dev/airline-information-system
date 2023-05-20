package gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;

import businesslogic.api.employee.EmployeeType;
import businesslogic.api.BusinessLogicAPI;

public class NavBarController implements Initializable {

    private final BusinessLogicAPI businessLogicAPI;

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
    private MenuItem deleteCustomer;


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
    public NavBarController(BusinessLogicAPI businessLogicAPI, Supplier<SceneManager> sceneManagerSupplier){
        this.businessLogicAPI = businessLogicAPI;
        this.sceneManagerSupplier = sceneManagerSupplier;
    }
    //left customerView
    public void sendToHomePage() {
        sceneManagerSupplier.get().changeScene("mainGUI");
    }

    public void sendToCreateFlight() {
        sceneManagerSupplier.get().changeScene("createFlightView");
    }

    public void sendToSearchForFlight() {
        sceneManagerSupplier.get().changeScene("searchFlightView");
    }

    public void sendToCreateRoute() {
        sceneManagerSupplier.get().changeScene("createRouteView");
    }
    public void sendToSearchForRoute() {
        sceneManagerSupplier.get().changeScene("searchRouteView");
    }


    public void sendToCreateAirport() {
        sceneManagerSupplier.get().changeScene("createAirportView");
    }

    public void sendToCreateBooking() {
        sceneManagerSupplier.get().changeScene("createBookingView");
    }

    public void sendToSearchForBooking() {
        sceneManagerSupplier.get().changeScene("searchBookingView");
    }


    public void sendToCreateTicket() {
        sceneManagerSupplier.get().changeScene("createTicketView");
    }


    public void sendToRegisterCustomer() {
        sceneManagerSupplier.get().changeScene("createCustomerView");
    }

    public void sendToDeleteCustomer() {
        sceneManagerSupplier.get().changeScene("deleteCustomerView");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //what about all the cancel options - take a look at the gui and give feedback
        //also look at who does what and fix the analysis - should the search for... be an option in itself
        //also test visibility of the menu
        //make it dynamic - resizable - either in fxml or css file(make it apply for all files)
        EmployeeType permissions = businessLogicAPI.getLoggedInEmployee();

        for (Menu menu : mainMenuBar.getMenus()) {
            for (MenuItem item : menu.getItems()) {
                item.setVisible(false);
            }
        }

        switch (permissions){
            case SALES_OFFICER:
                createRoute.setVisible(true);
                //editRoute.setVisible(true);
                createFlight.setVisible(true);
                //editFlight.setVisible(true);
                createAirport.setVisible(true);
                //startSalesProcess.setVisible(true);


                searchForFlight.setVisible(true);
                searchForRoute.setVisible(true);
                createTicket.setVisible(true);
            case SALES_MANAGER:
                //financialSheet.setVisible(true);
                //statistics.setVisible(true);
                registerEmployee.setVisible(true);


                searchForFlight.setVisible(true);
                searchForRoute.setVisible(true);
            case SALES_EMPLOYEE:
                createBooking.setVisible(true);
                //editBooking.setVisible(true);
                searchForBooking.setVisible(true);

                registerCustomer.setVisible(true);
                deleteCustomer.setVisible(true);

                purchaseTicket.setVisible(true);
                searchForFlight.setVisible(true);
                searchForRoute.setVisible(true);
                homePage.setVisible(true);
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
                deleteCustomer.setVisible(true);

                financialSheet.setVisible(true);
                statistics.setVisible(true);
                registerEmployee.setVisible(true);
                startSalesProcess.setVisible(true);
                break;
        }

        for (Menu menu : mainMenuBar.getMenus()) {
            boolean hide = true;
            for (MenuItem item : menu.getItems()) {
                if (item.isVisible()) {
                    hide = false;
                    break;
                }
            }
            menu.setVisible(!hide);
        }
    }
}
