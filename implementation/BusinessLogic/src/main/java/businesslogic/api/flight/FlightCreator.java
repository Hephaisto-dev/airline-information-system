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
                Flight flight = FlightFactory.createFlight(new FlightData(id, dLTD, aLTD, Duration.between(dLTD, aLTD), plane.getId(), departPort.getId(), arrivePort.getId()));
                flightManager.add(flight);
            }
            //TODO throw exceptions in FlightManager
            catch (Exception e) {
                e.printStackTrace();
                //TODO: Identify and handle Exceptions properly
            }
            return "Flight was successfully created";
        } else {
            stringBuilder.append("Please correct this and try again");
            return stringBuilder.toString();
        }
    }
}
