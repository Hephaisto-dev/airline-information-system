package businesslogic.impl;

import businesslogic.api.airplane.Airplane;
import datarecords.AirplaneData;

public class AirplaneImpl implements Airplane {

    private final AirplaneData airplaneData;

    public AirplaneImpl(String id, String name, int length, int width) {
        this.airplaneData = new AirplaneData(id, name, length, width);
    }

    public AirplaneImpl(AirplaneData airplaneData) {
        this.airplaneData = airplaneData;
    }

    @Override
    public String getId() {
        return airplaneData.id();
    }

    @Override
    public int getCapacity() {
        return airplaneData.length() * airplaneData.width();
    }

    @Override
    public int getLength() {
        return airplaneData.length();
    }

    @Override
    public int getWidth() {
        return airplaneData.width();
    }

    @Override
    public AirplaneData getData() {
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
