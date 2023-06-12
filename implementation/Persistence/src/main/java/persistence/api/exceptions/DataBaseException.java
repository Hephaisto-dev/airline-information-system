package persistence.api.exceptions;

public class DataBaseException extends PersistanceException {
    /**
     * For any issues / SQLExceptions related to DataBase problems (i.e. unavailability)
     *
     * @param message
     */
    public DataBaseException(String message) {
        super(message);
    }
}
