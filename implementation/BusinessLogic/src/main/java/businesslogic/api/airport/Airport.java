package businesslogic.api.airport;

import businesslogic.api.common.Nameable;
import businesslogic.api.common.PersistantDataContainer;
import businesslogic.api.common.StringIdentifiable;
import datarecords.AirportData;

public interface Airport extends Nameable, PersistantDataContainer<AirportData> {
    String getCity();

    String getCountry();

}
