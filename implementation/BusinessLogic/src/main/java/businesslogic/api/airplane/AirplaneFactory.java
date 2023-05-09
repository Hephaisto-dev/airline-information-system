package businesslogic.api.airplane;

import businesslogic.impl.AirplaneImpl;
import datarecords.AirplaneData;

public interface AirplaneFactory {

    static Airplane createAirplane(String id, String manufacturer, int length, int width, String model, int seats) throws NoAirplaneException {
        if (true) {//TODO implement the getting from the persistence / DB
            return new AirplaneImpl(id, manufacturer, length, width, model, seats);
        } else {
            throw new NoAirplaneException();
        }
    }

    static Airplane createAirplane(AirplaneData airplaneData) {
        return new AirplaneImpl(airplaneData);
    }
}
