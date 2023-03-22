package businesslogic.api.airplane;

import businesslogic.api.common.Identifiable;
import businesslogic.api.common.Nameable;
import datarecords.AirplaneData;

public interface Airplane extends Identifiable<String>, Nameable {

    int getMaxCapacity();

    AirplaneData getAirplaneData();
}
