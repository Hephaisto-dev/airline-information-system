package businesslogic.api.flight;

import businesslogic.api.airplane.Airplane;
import businesslogic.api.common.PersistantDataContainer;
import businesslogic.api.route.Route;
import datarecords.FlightData;

import java.time.Duration;
import java.time.LocalDateTime;

public interface Flight extends PersistantDataContainer<FlightData> {

    Duration getFlightDuration();

    Airplane getAirplane();

    LocalDateTime getETD();

    LocalDateTime getETA();

    Route getRoute();

    FlightStatus getFlightStatus();

    void changeStatus(FlightStatus newStatus);

    String bookSeat(int row, char column);

    String cancelBookedSeat(String targetID);
}
