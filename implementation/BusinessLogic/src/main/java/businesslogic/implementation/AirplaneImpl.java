package businesslogic.implementation;

import businesslogic.api.airplane.Airplane;
import datarecords.AirplaneData;

public class AirplaneImpl implements Airplane {

    private final AirplaneData airplaneData;

    public AirplaneImpl(String id, String name, int capacity) {
        this.airplaneData = new AirplaneData(id, name, capacity);
    }

    @Override
    public String getId() {
        return airplaneData.id();
    }

    @Override
    public int getCapacity() {
        return airplaneData.capacity();
    }

    @Override
    public AirplaneData getAirplaneData() {
        return airplaneData;
    }

    @Override
    public String getName() {
        return airplaneData.name();
    }

    @Override
    public String toString() {
        return "AirplaneImpl{" +
                "airplaneData=" + airplaneData +
                '}';
    }
}
