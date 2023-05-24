package businesslogic.api.flight;

import businesslogic.api.airplane.Airplane;
import businesslogic.api.airport.Airport;
import businesslogic.api.manager.FlightManager;
import datarecords.FlightData;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class FlightCreator {
    private final FlightManager flightManager;

    public FlightCreator(FlightManager manage) {
        this.flightManager = manage;
    }

    public String createFlight(Airport departPort, Airport arrivePort, String departLDT, String arriveLDT,
                               Airplane plane) {
        LocalDateTime dLTD = null;
        LocalDateTime aLTD = null;
        StringBuilder stringBuilder = new StringBuilder();


        if (departPort == null) {
            stringBuilder.append("Departure Airport does not exist\n");
        }
        if (arrivePort == null) {
            stringBuilder.append("Arrival Airport does not exist\n");
        }
        try {
            dLTD = LocalDateTime.parse(departLDT);
        } catch (DateTimeParseException dtpe) {
            stringBuilder.append("Departure Time is not entered correctly\n");
        }
        try {
            aLTD = LocalDateTime.parse(arriveLDT);
        } catch (DateTimeParseException dtpe) {
            stringBuilder.append("Arrival Time is not entered correctly\n");
        }
        if (aLTD != null && dLTD != null) {
            if (!aLTD.isAfter(dLTD)) {
                stringBuilder.append("Time of departure must be before time of arrival\n");
            }
            if (aLTD.isBefore(LocalDateTime.now()) || dLTD.isBefore(LocalDateTime.now())) {
                stringBuilder.append("Ensure that the flight times aren't in the past\n");
            }
            if (aLTD.isBefore(LocalDateTime.now())) {
                stringBuilder.append("Arrival time must be in the present/future\n");
            }
            if (dLTD.isBefore(LocalDateTime.now())) {
                stringBuilder.append("Departure time must be in the present/future\n");
            }
        }

        if (plane == null) {
            stringBuilder.append("No plane was provided\n");
        }

        if (stringBuilder.isEmpty()) {
            try {
                String id = "FL_" + departPort.getName() + "-" + arrivePort.getName() + "_" + dLTD + "_" + plane.getId();
                Flight flight = FlightFactory.createFlight(new FlightData(id,dLTD, aLTD, Duration.between(dLTD, aLTD), plane.getId(),departPort.getId(), arrivePort.getId()));
                flightManager.add(flight);
            }
            //TODO throw exceptions in FlightManager
            catch (Exception e){
                e.printStackTrace();
                //TODO: Identify and handle Exceptions properly
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
                String id = "FL_" + departPort.getName() + "-" + arrivePort.getName() + "_" + dLTD + "_" + plane.getId();
                Flight flight = FlightFactory.createFlight(new FlightData(id, dLTD, aLTD, Duration.between(dLTD, aLTD), plane.getId(), departPort.getId(), arrivePort.getId()));
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
