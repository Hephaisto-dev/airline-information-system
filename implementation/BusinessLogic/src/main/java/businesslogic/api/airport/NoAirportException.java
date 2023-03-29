package businesslogic.api.airport;

public class NoAirportException extends Exception {
    public NoAirportException(String message) {
        super(message);
    }

    public NoAirportException() {
    }
}
