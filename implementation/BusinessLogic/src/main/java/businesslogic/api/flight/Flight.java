package businesslogic.api.flight;

import businesslogic.api.airplane.Airplane;
import businesslogic.api.common.PersistantDataContainer;
import businesslogic.api.common.StringIdentifiable;
import businesslogic.api.route.Route;
import datarecords.FlightData;

import java.time.Duration;
import java.time.LocalDateTime;

public interface Flight extends StringIdentifiable, PersistantDataContainer<FlightData> {

    Duration getFlightDuration();

    Airplane getAirplane();

    LocalDateTime getETD();

    LocalDateTime getETA();

    Route getRoute();

    String bookSeat(int column, String row);
    String cancelBookedSeat(String target);
}
