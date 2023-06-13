package businesslogic.impl;

import businesslogic.api.BusinessLogicAPI;
import businesslogic.api.BusinessLogicFactory;
import businesslogic.api.employee.EmployeeType;
import businesslogic.api.manager.*;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import persistence.api.*;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BusinessLogicAPIImplTest {
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
    @Mock
    private RouteStorageService routeStorageService;
    private BusinessLogicAPI businessLogicAPI;

    @BeforeAll
    public void initMocks() {
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
        when(routeStorageService.getAll()).thenReturn(new HashSet<>());
        businessLogicAPI = BusinessLogicFactory.getImplementation();
    }

    @Test
    void getAirplaneManager() {
        assertNotNull(businessLogicAPI.getAirplaneManager());
    }

    @Test
    void getAirportManager() {
        assertNotNull(businessLogicAPI.getAirportManager());
    }

    @Test
    void getCustomerManager() {
        assertNotNull(businessLogicAPI.getCustomerManager());
    }

    @Test
    void getFlightManager() {
        assertNotNull(businessLogicAPI.getFlightManager());
    }

    @Test
    void getBookingManager() {
        assertNotNull(businessLogicAPI.getBookingManager());
    }

    @Test
    void getEmployeeManager() {
        assertNotNull(businessLogicAPI.getEmployeeManager());
    }

    @Test
    void getTicketManager() {
        assertNotNull(businessLogicAPI.getTicketManager());
    }

    @Test
    void getRouteManager() {
        assertNotNull(businessLogicAPI.getRouteManager());
    }

    @Test
    void loggedInEmployee() {
        businessLogicAPI.setLoggedInEmployee(EmployeeType.SALES_EMPLOYEE);
        assertEquals(businessLogicAPI.getLoggedInEmployee(), EmployeeType.SALES_EMPLOYEE);
    }

    @Test
    void getManager() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(businessLogicAPI.getManager(AirplaneManager.class)).isNotNull();
            softly.assertThat(businessLogicAPI.getManager(AirportManager.class)).isNotNull();
            softly.assertThat(businessLogicAPI.getManager(CustomerManager.class)).isNotNull();
            softly.assertThat(businessLogicAPI.getManager(FlightManager.class)).isNotNull();
            softly.assertThat(businessLogicAPI.getManager(BookingManager.class)).isNotNull();
            softly.assertThat(businessLogicAPI.getManager(EmployeeManager.class)).isNotNull();
            softly.assertThat(businessLogicAPI.getManager(RouteManager.class)).isNotNull();
        });
    }
}