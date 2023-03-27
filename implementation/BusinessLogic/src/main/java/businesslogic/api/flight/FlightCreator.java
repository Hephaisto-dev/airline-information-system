package businesslogic.api.flight;

import businesslogic.api.airplane.Airplane;
import businesslogic.api.airplane.AirplaneFactory;
import businesslogic.api.airport.Airport;
import businesslogic.api.airport.AirportFactory;
import businesslogic.api.manager.FlightManager;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class FlightCreator {
    private final FlightManager flightManager;

    public FlightCreator(FlightManager manage){
        this.flightManager = manage;
    }

    public String createFlight(String departPlace, String arrivePlace, String departLDT, String arriveLDT, String planeName){
        boolean errors = false;
        String errorMessages = "";
        Airport departPort = null;
        Airport arrivePort = null;
        LocalDateTime dLTD = null;
        LocalDateTime aLTD = null;
        Airplane plane = null;

        try{
            departPort = AirportFactory.createAirport(departPlace);//placeholder while we wait for better persistence
        }catch(Exception e){//placeholder for Exceptions saying sth about it being wrong
            errors = true;
            errorMessages += "Departure Airport does not exist in our database" + "\n";
        }
        try{
            arrivePort = AirportFactory.createAirport(arrivePlace);//placeholder while we wait for better persistence
        }catch(Exception e){//placeholder for Exceptions saying sth about it being wrong
            errors = true;
            errorMessages += "Arrival Airport does not exist in our database" + "\n";
        }
        try{
            dLTD = LocalDateTime.parse(departLDT);
        }catch(DateTimeParseException dtpe) {
            errors = true;
            errorMessages += "Departure Time is not entered correctly" + "\n";
        }
        try{
            aLTD = LocalDateTime.parse(arriveLDT);
        }catch(DateTimeParseException dtpe){
            errors = true;
            errorMessages += "Arrival Time is not entered correctly" + "\n";
        }
        try{
            plane = AirplaneFactory.createAirplane(planeName.toLowerCase().replace(' ', '-'),
                    planeName, 150);//placeholder while we wait for better persistence
        }catch(Exception e){//placeholder for Exceptions saying sth about it being wrong
            errors = true;
            errorMessages += "An airplane with the provided ID does not exist in our database" + "\n";
        }


        if(!errors){

            try{
                Flight flight = FlightFactory.createFlight(departPort,arrivePort,dLTD,aLTD,plane);
                flightManager.add(flight);
            }catch(Exception e){
                return "Flight was successfully created";//DELTE WHEN ACTUAL IMPL OF .add() method has occurred
                /*
                e.printStackTrace();
                //figuring out what kind of exception we're dealing with here in order for this to be more precisely handled
                return "There seems to be an issue with the database, please try again." + "\n"
                        + "+If the issue persists, contact the IT department";*/
            }
            return "Flight was successfully created";
        }else{
            errorMessages += "Please correct this and try again";
            return errorMessages;
        }
    }
}
