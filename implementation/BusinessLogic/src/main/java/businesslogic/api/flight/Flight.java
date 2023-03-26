package businesslogic.api.flight;

import businesslogic.api.airplane.Airplane;
import businesslogic.api.common.PersistantDataContainer;
import businesslogic.api.common.Identifiable;
import businesslogic.api.route.Route;
import datarecords.FlightData;

import java.time.Duration;
import java.time.LocalDateTime;

public interface Flight extends Identifiable<String>, PersistantDataContainer<FlightData> {

    Duration getFlightDuration();

    Airplane getAirplane();

    LocalDateTime getETD();

    LocalDateTime getETA();

    Route getRoute();
}
