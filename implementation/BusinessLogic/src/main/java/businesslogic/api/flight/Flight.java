package businesslogic.api.flight;

import businesslogic.api.common.Identifiable;
import businesslogic.api.airplane.Airplane;
import businesslogic.api.route.Route;

import java.time.Duration;
import java.time.LocalDateTime;

public interface Flight extends Identifiable<String> {

    Duration getFlightDuration();

    Airplane getAirplane();

    LocalDateTime getETD();

    LocalDateTime getETA();

    Route getAssociatedRoute();
}
