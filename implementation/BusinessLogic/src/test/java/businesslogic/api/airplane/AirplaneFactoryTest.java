package businesslogic.api.airplane;

import datarecords.AirplaneData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AirplaneFactoryTest {

    @Test
    void createAirplane() {
        AirplaneData airplaneData = new AirplaneData("id", "type", 1, 2);
        Airplane airplane = AirplaneFactory.createAirplane(airplaneData);
        assertEquals(airplane.getData(), airplaneData);
    }
}