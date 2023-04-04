package businesslogic.api.flight;

import businesslogic.api.airplane.Airplane;
import businesslogic.api.airplane.AirplaneFactory;
import businesslogic.api.airplane.NoAirplaneException;
import businesslogic.api.airport.Airport;
import businesslogic.api.airport.AirportFactory;
import businesslogic.api.airport.NoAirportException;
import businesslogic.api.manager.FlightManager;
import persistence.NoDBConnectionException;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class  FlightCreator {
    private final FlightManager flightManager;

    public FlightCreator(FlightManager manage) {
        this.flightManager = manage;
    }

    public String createFlight(String departPlace, String arrivePlace, String departLDT, String arriveLDT,
                               String planeName) {
        boolean errors = false;
        Airport departPort = null;
        Airport arrivePort = null;
        LocalDateTime dLTD = null;
        LocalDateTime aLTD = null;
        Airplane plane = null;
        StringBuilder stringBuilder = new StringBuilder();


        try {
            departPort = AirportFactory.createAirport(departPlace);
        } catch (NoAirportException a) {
            errors = true;
            stringBuilder.append("Departure Airport does not exist in our database\n");
        }
        try {
            arrivePort = AirportFactory.createAirport(arrivePlace);
        } catch (NoAirportException a) {
            errors = true;
            stringBuilder.append("Arrival Airport does not exist in our database\n");
        }
        try {
            dLTD = LocalDateTime.parse(departLDT);
        } catch (DateTimeParseException dtpe) {
            errors = true;
            stringBuilder.append("Departure Time is not entered correctly\n");
        }
        try {
            aLTD = LocalDateTime.parse(arriveLDT);
        } catch (DateTimeParseException dtpe) {
            errors = true;
            stringBuilder.append("Arrival Time is not entered correctly\n");
        }
        if (aLTD != null && dLTD != null) {
            if (!aLTD.isAfter(dLTD)) {
                errors = true;
                stringBuilder.append("Time of departure must be before time of arrival\n");
            }
            if (aLTD.isBefore(LocalDateTime.now()) || dLTD.isBefore(LocalDateTime.now())) {
                errors = true;
                stringBuilder.append("Ensure that the flight times aren't in the past\n");
            }
            if(aLTD.isBefore(LocalDateTime.now())){
                errors = true;
                stringBuilder.append("Arrival time must be in the present/future");
            }
            if(dLTD.isBefore(LocalDateTime.now())){
                errors = true;
                stringBuilder.append("Departure time must be in the present/future");
            }
        }
        try {
            plane = AirplaneFactory.createAirplane(planeName);
            //-------------------Martin--------------
            if(plane.getName().equals(null)) {
                errors = true;
                stringBuilder.append("No plane was provided");
            }
            //---------------------------------------
        } catch (NoAirplaneException na) {
            errors = true;
            stringBuilder.append("An airplane with the provided ID does not exist in our database\n");
        }


        if (!errors) {
            try {
                Flight flight = FlightFactory.createFlight(departPort, arrivePort, dLTD, aLTD, plane);
                flightManager.add(flight);
            } catch (NoDBConnectionException e) {
                return "There seems to be an issue with the database, please try again." + "\n"
                        + "+If the issue persists, contact the IT department";
            }
            return "Flight was successfully created";
        } else {
            stringBuilder.append("Please correct this and try again");
            return stringBuilder.toString();
        }
    }

    public String createFlight(Airport departPlace, Airport arrivePlace, LocalDateTime departLDT,
                               LocalDateTime arriveLDT, Airplane planeName) {
        boolean errors = false;
        String errorMessages = "";
        Airport departPort = null;
        Airport arrivePort = null;
        LocalDateTime dLTD = null;
        LocalDateTime aLTD = null;
        Airplane plane = null;

        try {
            departPort = departPlace;
        } catch (Exception e) {//placeholder for Exceptions saying sth about it being wrong
            errors = true;
            errorMessages += "Departure Airport does not exist in our database" + "\n";
        }
        try {
            arrivePort = arrivePlace;
        } catch (Exception e) {//placeholder for Exceptions saying sth about it being wrong
            errors = true;
            errorMessages += "Arrival Airport does not exist in our database" + "\n";
        }
        try {
            dLTD = departLDT;
            if (dLTD == null) {
                throw new NullPointerException();
            }
        } catch (Exception e) {
            errors = true;
            errorMessages += "Departure Time is not entered correctly" + "\n";
        }
        try {
            aLTD = arriveLDT;
            if (aLTD == null) {
                throw new NullPointerException();
            }
        } catch (Exception e) {
            errors = true;
            errorMessages += "Arrival Time is not entered correctly" + "\n";
        }
        if (!errorMessages.contains("Time is not entered correctly")) {
            if (!aLTD.isAfter(dLTD)) {
                errors = true;
                errorMessages += "Time of departure must be before time of arrival" + "\n";
            }
            if (aLTD.isBefore(LocalDateTime.now()) || dLTD.isBefore(LocalDateTime.now())) {
                errors = true;
                errorMessages += "Ensure that the flight times aren't in the past" + "\n";
            }
        }
        try {
            plane = planeName;
        } catch (Exception e) {//placeholder for Exceptions saying sth about it being wrong
            errors = true;
            errorMessages += "An airplane with the provided ID does not exist in our database" + "\n";
        }


        if (!errors) {

            try {
                Flight flight = FlightFactory.createFlight(departPort, arrivePort, dLTD, aLTD, plane);
                flightManager.add(flight);
            } catch (Exception e) {
                return "Flight was successfully created";//DELTE WHEN ACTUAL IMPL OF .add() method has occurred
                /*
                e.printStackTrace();
                //figuring out what kind of exception we're dealing with here in order for this to be more precisely
                handled
                return "There seems to be an issue with the database, please try again." + "\n"
                        + "+If the issue persists, contact the IT department";*/
            }
            return "Flight was successfully created";
        } else {
            errorMessages += "Please correct this and try again";
            return errorMessages;
        }
    }
}
