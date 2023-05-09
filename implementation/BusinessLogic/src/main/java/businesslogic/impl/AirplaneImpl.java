package businesslogic.impl;

import businesslogic.api.airplane.Airplane;
import datarecords.AirplaneData;

public class AirplaneImpl implements Airplane {

    private final AirplaneData airplaneData;

    public AirplaneImpl(String id, String manufacturer, int length, int width, String model, int seats) {
        this.airplaneData = new AirplaneData(id, manufacturer, length, width, model, seats);
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
    public String getManufacturer() {
        return airplaneData.manufacturer();
    }

    @Override
    public String getModel() {
        return airplaneData.model();
    }

    @Override
    public AirplaneData getData() {
        return airplaneData;
    }

    @Override
    public String getName() {
        return airplaneData.id();
    }

    @Override
    public String toString() {
        return "AirplaneImpl{" +
                "airplaneData=" + airplaneData +
                '}';
    }
}
