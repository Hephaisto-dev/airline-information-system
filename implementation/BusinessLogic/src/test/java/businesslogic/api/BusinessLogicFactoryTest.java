package businesslogic.api;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import persistence.api.*;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class BusinessLogicFactoryTest {
    @Mock
    private PersistenceAPI persistenceAPI;
    @Mock
    private AirportStorageService airportStorageService;
    @Mock
    private AirplaneStorageService airplaneStorageService;
    @Mock
    private BookingStorageService bookingStorageService;
    @Mock
    private CustomerStorageService customerStorageService;
    @Mock
    private EmployeeStorageService employeeStorageService;
    @Mock
    private FlightStorageService flightStorageService;
    @Mock
    private TicketStorageService ticketStorageService;

    @Test
    void getImplementation() {
        MockitoAnnotations.openMocks(this);
        when(persistenceAPI.getAirportStorageService()).thenReturn(airportStorageService);
        when(persistenceAPI.getAirplaneStorageService()).thenReturn(airplaneStorageService);
        when(persistenceAPI.getBookingStorageService()).thenReturn(bookingStorageService);
        when(persistenceAPI.getCustomerStorageService()).thenReturn(customerStorageService);
        when(persistenceAPI.getEmployeeStorageService()).thenReturn(employeeStorageService);
        when(persistenceAPI.getFlightStorageService()).thenReturn(flightStorageService);
        when(persistenceAPI.getTicketStorageService()).thenReturn(ticketStorageService);
        when(airportStorageService.getAll()).thenReturn(new HashSet<>());
        when(airplaneStorageService.getAll()).thenReturn(new HashSet<>());
        when(bookingStorageService.getAll()).thenReturn(new HashSet<>());
        when(customerStorageService.getAll()).thenReturn(new HashSet<>());
        when(employeeStorageService.getAll()).thenReturn(new HashSet<>());
        when(flightStorageService.getAll()).thenReturn(new HashSet<>());
        when(ticketStorageService.getAll()).thenReturn(new HashSet<>());
        assertNotNull(BusinessLogicFactory.getImplementation());
    }
}