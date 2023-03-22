package businesslogic.api.airport;

import businesslogic.api.common.Identifiable;
import businesslogic.api.common.Nameable;
import datarecords.AirportData;

public interface Airport extends Identifiable<Integer>, Nameable {
    String getCity();

    String getCountry();

    AirportData getAirportData();
}
