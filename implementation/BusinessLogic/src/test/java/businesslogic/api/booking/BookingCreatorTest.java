package businesslogic.api.booking;

import businesslogic.api.airplane.Airplane;
import businesslogic.api.airplane.AirplaneFactory;
import businesslogic.api.airport.Airport;
import businesslogic.api.customer.Customer;
import businesslogic.api.customer.Price;
import businesslogic.api.customer.PriceImpl;
import businesslogic.api.employee.Employee;
import businesslogic.api.flight.Flight;
import businesslogic.api.flight.FlightCreator;
import businesslogic.api.flight.FlightFactory;
import businesslogic.api.manager.*;
import datarecords.*;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;
import persistence.api.*;
import persistence.api.exceptions.PersistanceException;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BookingCreatorTest {

    private final CustomerStorageService CSSI = data -> data;
    private final BookingStorageService BSSI = data -> data;
    private final TicketStorageService TSSI = data -> data;
    private static final AirplaneStorageService ASSI = data -> data;
    private static AirplaneManager airplaneManager = new AirplaneManager(ASSI);
    final BookingCreator bookingCreator = new BookingCreator(new BookingManager(BSSI), new TicketManager(TSSI),new CustomerManager(CSSI));
    private static List<CustomerData> customersOnBooking = new ArrayList<>();
    private List<CustomerData> noCustomers = new ArrayList<>();
    private String answer;
    private String expectation;
    private static CustomerData MainCus;
    static final Airplane plane = AirplaneFactory.createAirplane(new AirplaneData("ids", "manufacturers", 7, 7, "models", 77));

    //private static final Flight flightData =FlightFactory.createFlight(new FlightData("1", LocalDateTime.now(),LocalDateTime.now(), Duration.ofSeconds(Long.parseLong("123")),"1","2","null"));
    private static final Flight flightData = Mockito.mock(Flight.class);
    @BeforeAll
    static void prepare() throws Exception {
        customersOnBooking.add(new CustomerData("1","pete","peers",LocalDate.of(2002,1,2),"petepeters@gmail.com"));
        customersOnBooking.add(new CustomerData("2","pet","eters",LocalDate.of(2002,1,2),"petepeters@gmail.com"));
        customersOnBooking.add(new CustomerData("3","pe","ters",LocalDate.of(2002,1,2),"petepeters@gmail.com"));
        MainCus = new CustomerData("1","pete","peters",LocalDate.of(2002,1,2),"petepeters@gmail.com");
        Airplane airplane1 = AirplaneFactory.createAirplane(new AirplaneData("1","thisplane",12,12,"cool",12));
        airplaneManager.add(airplane1);


    }

    @ParameterizedTest
    @CsvSource({
            "1,1"
    })
    void createBooking(String id, String EmpId){
        expectation = "Booking was successfully created";


        Mockito.when(flightData.getAirplane()).thenReturn(plane);
        Mockito.when(flightData.getPrice()).thenReturn(new PriceImpl(1000));
        Mockito.when(flightData.bookSeat(2, 'B')).thenReturn("Successfully");



        answer = bookingCreator.createBooking(id,EmpId,flightData,null,LocalDate.now(),null,customersOnBooking,MainCus);

        SoftAssertions.assertSoftly(softly -> softly.assertThat(answer)
                .contains(expectation));;
    }
    @Test
    public void testCreateBooking_EmptyCustomers() {
        // Prepare test data with no customers
        String id = "B001";
        String employeeData = "1";

        List<TicketData> tickets = new ArrayList<>();
        LocalDate bookingDate = LocalDate.now();
        List<String> extras = new ArrayList<>();
        List<CustomerData> customersOnBooking = new ArrayList<>();
        CustomerData mainCustomer = new CustomerData("C001", "John", "Doe", LocalDate.of(1990, 1, 1), "john.doe@example.com");

        Mockito.when(flightData.getAirplane()).thenReturn(plane);

        // Perform the booking
        String result = bookingCreator.createBooking(id, employeeData, flightData, tickets, bookingDate, extras, customersOnBooking, mainCustomer);
        System.out.println(result);
        // Assert the result
        Assertions.assertTrue(result.contains("a booking must countain at least 1 person!"));
        Assertions.assertTrue(result.contains("Please correct this and try again"));
    }
    @Test
    public void testCreateBooking_NullFields() {
        // Prepare test data with some fields set to null
        String id = null;
        String employeeData = "Employee001";
        List<TicketData> tickets = new ArrayList<>();
        LocalDate bookingDate = LocalDate.now();
        List<String> extras = new ArrayList<>();
        List<CustomerData> customersOnBooking = new ArrayList<>();
        CustomerData mainCustomer = new CustomerData("C001", "John", "Doe", LocalDate.of(1990, 1, 1), "john.doe@example.com");

        Mockito.when(flightData.getAirplane()).thenReturn(plane);

        // Perform the booking
        String result = bookingCreator.createBooking(id, employeeData, flightData, tickets, bookingDate, extras, customersOnBooking, mainCustomer);

        // Assert the result
        Assertions.assertTrue(result.contains("All fields must be filled in!"));
        Assertions.assertTrue(result.contains("Please correct this and try again"));
    }
}
