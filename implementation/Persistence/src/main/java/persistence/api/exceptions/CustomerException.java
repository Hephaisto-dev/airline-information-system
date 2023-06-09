package persistence.api.exceptions;

public class CustomerException extends PersistanceException {
    /**
     * For any issues / SQLExceptions related to Customers (i.e. customer tries to do something but isn't saved in DB)
     *
     * @param message
     */
    public CustomerException(String message) {
        super(message);
    }
}
