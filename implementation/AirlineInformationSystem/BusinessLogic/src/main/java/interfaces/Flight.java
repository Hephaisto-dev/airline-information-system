package interfaces;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public interface Flight {

    String getFlightID();

    int getFlightDuration();

    String departFrom();
    String ArriveIn();

    Airplane getPlane();
    LocalDate getDayOfDeparture();

    LocalTime getTimeOfDeparture();

    LocalDateTime getETDLocalDateTime();

    LocalDate getDayOfArrival();

    LocalTime getTimeOfArrival();
    LocalDateTime getETALocalDateTime();
}
