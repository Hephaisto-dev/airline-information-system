package businesslogic.implementation;

import businesslogic.api.airplane.Airplane;

public class AirplaneImpl implements Airplane {

    private final String planeID;
    private final String planeType;
    private final int maxCapacity;

    public AirplaneImpl(String id, String type, int capacity) {
        this.planeID = id;
        this.planeType = type;
        this.maxCapacity = capacity;
    }

    @Override
    public String getId() {
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

    @Override
    public String toString() {
        return "AirplaneImpl{" +
                "planeID='" + planeID + '\'' +
                ", planeType='" + planeType + '\'' +
                ", maxCapacity=" + maxCapacity +
                '}';
    }
}
