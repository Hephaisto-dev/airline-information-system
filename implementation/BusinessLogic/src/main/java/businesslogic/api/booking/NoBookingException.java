package businesslogic.api.booking;

public class NoBookingException extends Exception {
    public NoBookingException(String message) {
        super(message);
    }

    public NoBookingException() {
    }
}

