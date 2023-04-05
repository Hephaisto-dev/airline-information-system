package businesslogic.api.airplane;

import businesslogic.api.common.Nameable;
import businesslogic.api.common.PersistantDataContainer;
import businesslogic.api.common.StringIdentifiable;
import datarecords.AirplaneData;

public interface Airplane extends StringIdentifiable, Nameable, PersistantDataContainer<AirplaneData> {

    int getCapacity();
    int getLength();
    int getWidth();
}
