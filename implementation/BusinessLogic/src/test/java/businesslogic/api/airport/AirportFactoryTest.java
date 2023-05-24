package businesslogic.api.airport;

import datarecords.AirportData;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AirportFactoryTest {

    @Test
    void createAirportWithData() {
        AirportData airportData = new AirportData("id", "name", "country");
        Airport airport = AirportFactory.createAirport(airportData);
        assertEquals(airport.getData(), airportData);
    }

    @Test
    void createAirportWithParameters() {
        Airport airport = AirportFactory.createAirport("id", "name", "country");
        SoftAssertions.assertSoftly(
                softly -> {
                    softly.assertThat(airport.getId())
                            .isEqualTo("id");
                    softly.assertThat(airport.getName())
                            .isEqualTo("name");
                    softly.assertThat(airport.getCountry())
                            .isEqualTo("country");
                }
        );
    }
}