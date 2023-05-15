package businesslogic.api.airplane;

import businesslogic.impl.AirplaneImpl;
import datarecords.AirplaneData;

public interface AirplaneFactory {

    static Airplane createAirplane(String id, String manufacturer, int length, int width, String model, int seats) throws NoAirplaneException {
        // TODO: Implement the logic to retrieve airplane data from the persistence/DB
        if (airplaneDataExists()) {
            return new AirplaneImpl(new AirplaneData(id, manufacturer, length, width, model, seats));
        } else {
            throw new NoAirplaneException();
        }
    }

    static Airplane createAirplane(AirplaneData airplaneData) {
        return new AirplaneImpl(airplaneData);
    }

    private static boolean airplaneDataExists() {
        // TODO: Implement the logic to check if airplane data exists in the persistence/DB
        return true;
    }
}
