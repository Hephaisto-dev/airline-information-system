package persistence.api.exceptions;

public class FlightException extends PersistanceException {
    /**
     * For any issues / SQLExceptions related to Flights
     *
     * @param message
     */
    public FlightException(String message) {
        super(message);
    }
}
