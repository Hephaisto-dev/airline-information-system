package businesslogic.api.airplane;

import businesslogic.implementation.AirplaneImpl;

public interface AirplaneFactory {
    static Airplane createAirplane(String id, String type, int capacity) {
        return new AirplaneImpl(id, type, capacity);
    }

    static Airplane createAirplane(String id) throws NoAirplaneException {
        if (true) {//TODO implement the getting from the persistence / DB
            return new AirplaneImpl(id, "mockplane", 121);
        } else {
            throw new NoAirplaneException();
        }
    }
}
