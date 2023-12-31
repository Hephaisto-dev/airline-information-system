package persistence.impl;

import persistence.api.*;
import persistence.impl.database.DBProvider;

import javax.sql.DataSource;

/**
 * Actual creator of storage services.
 *
 * @author Informatics Fontys Venlo
 */
public enum PersistenceAPIImpl implements PersistenceAPI {
    INSTANCE;
    private final DataSource dataSource = DBProvider.getDataSource("jdbc.pg.prod");
    private final CustomerStorageService customerStorageService = new CustomerStorageServiceImpl(dataSource);
    private final AirplaneStorageService airplaneStorageService = new AirplaneStorageServiceImpl(dataSource);
    private final AirportStorageService airportStorageService = new AirportStorageServiceImpl(dataSource);
    private final FlightStorageService flightStorageService = new FlightStorageServiceImpl(dataSource);
    private final BookingStorageService bookingStorageService = new BookingStorageServiceImpl(dataSource);
    private final EmployeeStorageService employeeStorageService = new EmployeeStorageServiceImpl(dataSource);

    private final RouteStorageService routeStorageService = new RouteStorageServiceImpl(dataSource);
    private final TicketStorageService ticketStorageService = new TicketStorageServiceImpl(dataSource);

    @Override
    public CustomerStorageService getCustomerStorageService() {
        return customerStorageService;
    }

    @Override
    public AirplaneStorageService getAirplaneStorageService() {
        return airplaneStorageService;
    }

    @Override
    public AirportStorageService getAirportStorageService() {
        return airportStorageService;
    }

    @Override
    public BookingStorageService getBookingStorageService() {
        return bookingStorageService;
    }

    @Override
    public EmployeeStorageService getEmployeeStorageService() {
        return employeeStorageService;
    }

    @Override
    public TicketStorageService getTicketStorageService() {
        return ticketStorageService;
    }

    @Override
    public FlightStorageService getFlightStorageService() {
        return flightStorageService;
    }

    @Override
    public RouteStorageService getRouteStorageService() {
        return routeStorageService;
    }
}
