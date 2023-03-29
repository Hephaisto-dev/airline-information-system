package businesslogic.api.airport;

import businesslogic.api.airplane.NoAirplaneException;

public class NoAirportException extends Exception{
    public NoAirportException(String message){
        super(message);
    }
    public NoAirportException(){}
}
