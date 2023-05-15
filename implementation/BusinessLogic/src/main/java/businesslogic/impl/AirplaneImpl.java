package businesslogic.impl;

import businesslogic.api.airplane.Airplane;
import datarecords.AirplaneData;

public class AirplaneImpl implements Airplane {

    private final AirplaneData airplaneData;


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

//    @Override
//    public String toString() {
//        return getName();
//    }
//    //Generate this code with the IDE!
}
