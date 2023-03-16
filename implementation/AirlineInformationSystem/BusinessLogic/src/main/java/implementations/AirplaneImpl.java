package implementations;

import interfaces.Airplane;

public class AirplaneImpl implements Airplane {

    private String planeID;
    private String planeType;
    private int maxCapacity;

    public AirplaneImpl(String id, String type, int capacity){
        this.planeID = id;
        this.planeType = type;
        this.maxCapacity = capacity;
    }

    @Override
    public String getPlaneID() {
        return this.planeID;
    }

    @Override
    public String getPlaneType() {
        return this.planeType;
    }

    @Override
    public int getMaxCapacity() {
        return this.maxCapacity;
    }
}
