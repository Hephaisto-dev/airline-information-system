package businesslogic.api.booking;

import businesslogic.api.airplane.Airplane;
import businesslogic.api.airplane.AirplaneFactory;
import businesslogic.api.customer.Customer;
import businesslogic.api.customer.CustomerFactory;
import businesslogic.api.customer.PriceImpl;
import businesslogic.api.flight.Flight;
import businesslogic.api.manager.*;
import datarecords.AirplaneData;
import datarecords.CustomerData;
import datarecords.TicketData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import persistence.api.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingCreatorTest {

    static final Airplane plane = AirplaneFactory.createAirplane(new AirplaneData("ids", "manufacturers", 70, 70, "models", 77));
    private static final AirplaneStorageService ASSI = data -> data;
    private static final Flight flightData = Mockito.mock(Flight.class);
    private static final AirplaneManager airplaneManager = new AirplaneManager(ASSI);
    private static final List<Customer> customersOnBooking = new ArrayList<>();
    private static Customer MainCus;
    private final CustomerStorageService CSSI = data -> data;
    private final BookingStorageService BSSI = data -> data;
    private final TicketStorageService TSSI = data -> data;
    private final EmployeeStorageService ESSI = data -> data;
    final BookingCreator bookingCreator = new BookingCreator(new BookingManager(BSSI), new TicketManager(TSSI), new EmployeeManager(ESSI), new CustomerManager(CSSI));

    @BeforeAll
    static void prepare() throws Exception {
        customersOnBooking.add(CustomerFactory.createCustomer(new CustomerData("1", "pete", "peers", LocalDate.of(2002, 1, 2), "petepeters@gmail.com")));
        customersOnBooking.add(CustomerFactory.createCustomer(new CustomerData("2", "pet", "eters", LocalDate.of(2002, 1, 2), "petepeters@gmail.com")));
        customersOnBooking.add(CustomerFactory.createCustomer(new CustomerData("3", "pe", "ters", LocalDate.of(2002, 1, 2), "petepeters@gmail.com")));
        MainCus = CustomerFactory.createCustomer(new CustomerData("1", "pete", "peters", LocalDate.of(2002, 1, 2), "petepeters@gmail.com"));
        Airplane airplane1 = AirplaneFactory.createAirplane(new AirplaneData("1", "thisplane", 12, 12, "cool", 12));
        airplaneManager.add(airplane1);
    }

    @Test
    void testCreateBooking() {

        String expectation = "Booking was successfully created";
        Mockito.when(flightData.getAirplane()).thenReturn(plane);
        Mockito.when(flightData.getPrice()).thenReturn(new PriceImpl(1000));
        for (int i = 0; i < 25; i++) {
            Mockito.when(flightData.bookSeat(i, 'B')).thenReturn("Seat was successfully booked");

        }


        String answer = bookingCreator.createBooking("1", "1", flightData, null, LocalDate.now(), null, customersOnBooking, MainCus);
        Assertions.assertTrue(answer.contains(expectation));
    }

    @Test
    public void testCreateBookingEmptyCustomers() {
        // Prepare test data with no customers
        String id = "B001";
        String employeeData = "1";

        List<TicketData> tickets = new ArrayList<>();
        LocalDate bookingDate = LocalDate.now();
        List<String> extras = new ArrayList<>();
        List<Customer> customersOnBooking = new ArrayList<>();
        Customer mainCustomer = CustomerFactory.createCustomer(new CustomerData("C001", "John", "Doe", LocalDate.of(1990, 1, 1), "john.doe@example.com"));

        Mockito.when(flightData.getAirplane()).thenReturn(plane);

        // Perform the booking
        String result = bookingCreator.createBooking(id, employeeData, flightData, tickets, bookingDate, extras, customersOnBooking, mainCustomer);
        System.out.println(result);
        // Assert the result
        Assertions.assertTrue(result.contains("a booking must contain at least 1 person!"));
        Assertions.assertTrue(result.contains("Please correct this and try again"));
    }

    @Test
    public void testCreateBookingNullFields() {
        // Prepare test data with some fields set to null
        String employeeData = "Employee001";
        List<TicketData> tickets = new ArrayList<>();
        LocalDate bookingDate = LocalDate.now();
        List<String> extras = new ArrayList<>();
        List<Customer> customersOnBooking = new ArrayList<>();
        Customer mainCustomer = CustomerFactory.createCustomer(new CustomerData("C001", "John", "Doe", LocalDate.of(1990, 1, 1), "john.doe@example.com"));

        Mockito.when(flightData.getAirplane()).thenReturn(plane);

        // Perform the booking
        String result = bookingCreator.createBooking(null, employeeData, flightData, tickets, bookingDate, extras, customersOnBooking, mainCustomer);

        // Assert the result
        Assertions.assertTrue(result.contains("All fields must be filled in!"));
        Assertions.assertTrue(result.contains("Please correct this and try again"));
    }
}
