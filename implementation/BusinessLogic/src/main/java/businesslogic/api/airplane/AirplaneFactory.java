package businesslogic.api.airplane;

import businesslogic.implementation.AirplaneImpl;

public interface AirplaneFactory {
    static Airplane createAirplane(String id, String type, int length, int width) {
        return new AirplaneImpl(id, type, length, width);
    }

    static Airplane createAirplane(String id) throws NoAirplaneException {
        if (true) {//TODO implement the getting from the persistence / DB
            return new AirplaneImpl(id, "mockplane", 121, 2);
        } else {
            throw new NoAirplaneException();
        }
    }
}
