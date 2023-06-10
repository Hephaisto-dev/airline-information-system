package persistence.api.exceptions;

public class ConnectionException extends PersistanceException {
    /**
     * For any errors related to connectivity problems
     *
     * @param message
     */
    public ConnectionException(String message) {
        super(message);
    }
}
