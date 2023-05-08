package businesslogic.api.airport;

import businesslogic.api.common.Nameable;
import businesslogic.api.common.PersistantDataContainer;
import datarecords.AirportData;

public interface Airport extends Nameable, PersistantDataContainer<AirportData> {

    String getCountry();

}
