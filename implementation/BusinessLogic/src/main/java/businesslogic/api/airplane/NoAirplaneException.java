package businesslogic.api.airplane;

public class NoAirplaneException extends Exception{
    public NoAirplaneException(String message){
        super(message);
    }

    public NoAirplaneException(){}
}
