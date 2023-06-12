package businesslogic.api.airplane;

import businesslogic.impl.AirplaneImpl;
import datarecords.AirplaneData;

public interface AirplaneFactory {

    static Airplane createAirplane(String id, String manufacturer, int length, int width, String model, int seats) {
        return new AirplaneImpl(new AirplaneData(id, manufacturer, length, width, model, seats));
    }

    static Airplane createAirplane(AirplaneData airplaneData) {
        return new AirplaneImpl(airplaneData);
    }
}
