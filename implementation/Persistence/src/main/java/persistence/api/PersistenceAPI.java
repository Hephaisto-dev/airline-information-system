package persistence.api;

/**
 * @author Informatics Fontys Venlo
 */
public interface PersistenceAPI {

    /**
     * Get CustomerStorageService. Provides a storage object that knows how to
     * store and retrieve customers. Implemented by a default method, to enable
     * creation of customized PersistenceFacade implementations with limited
     * services, for test purposes.
     *
     * @return CustomerStorageService object that knows how to store and
     * retrieve customers.
     */
    CustomerStorageService getCustomerStorageService();

    AirplaneStorageService getAirplaneStorageService();


    AirportStorageService getAirportStorageService();


    FlightStorageService getFlightStorageService();


    BookingStorageService getBookingStorageService();

    EmployeeStorageService getEmployeeStorageService();

    RouteStorageService getRouteStorageService();

    TicketStorageService getTicketStorageService();
    // This interface can be extended with all services that need to be made
    // available to the business logic, e.g. to store Products:
    // 
    // ProductStorageService getProductStorageService( );
}
