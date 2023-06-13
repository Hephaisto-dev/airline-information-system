package businesslogic.api.route;

public class IncorrectTimeException extends Exception {
    public IncorrectTimeException(String message) {
        super("The transit time has to be " + message + "!");
    }
}
