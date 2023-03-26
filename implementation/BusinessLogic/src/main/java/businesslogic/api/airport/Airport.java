package businesslogic.api.airport;

import businesslogic.api.common.PersistantDataContainer;
import businesslogic.api.common.Identifiable;
import businesslogic.api.common.Nameable;
import datarecords.AirportData;

public interface Airport extends Identifiable<String>, Nameable, PersistantDataContainer<AirportData> {
    String getCity();

    String getCountry();
}
