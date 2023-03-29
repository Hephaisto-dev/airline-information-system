package businesslogic.api.airplane;

import businesslogic.implementation.AirplaneImpl;

public interface AirplaneFactory {
    static Airplane createAirplane(String id, String type, int capacity) {
        return new AirplaneImpl(id, type, capacity);
    }
}
