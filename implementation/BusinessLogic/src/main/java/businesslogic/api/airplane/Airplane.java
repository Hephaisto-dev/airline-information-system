package businesslogic.api.airplane;

import businesslogic.api.common.Nameable;
import businesslogic.api.common.PersistantDataContainer;
import datarecords.AirplaneData;

public interface Airplane extends Nameable, PersistantDataContainer<AirplaneData> {

    int getCapacity();
    String getId();
    String getManufacturer();

    int getLength();

    int getWidth();

    String getModel();

}
