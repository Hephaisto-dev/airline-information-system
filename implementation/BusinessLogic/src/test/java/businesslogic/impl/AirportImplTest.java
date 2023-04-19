package businesslogic.impl;

import businesslogic.api.airport.Airport;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.SoftAssertions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.junit.jupiter.api.Assertions.*;

class AirportImplTest {

    private final Airport Airport = new AirportImpl("Id","airportName","cityName","countryName");
    private final Airport Airport2 = new AirportImpl("Id","airportName","cityName","countryName");
    @Test
    void getCity() {
        assertThat(Airport.getCity()).isEqualTo("cityName");
    }

    @Test
    void getCountry() {
        assertThat(Airport.getCountry()).isEqualTo("countryName");
    }

    @Test
    void getData() {
        assertThat(Airport.getData()).isEqualTo(Airport2.getData());
    }

    @Test
    void getId() {
        assertThat(Airport.getId())
                .isEqualTo("Id");
    }

    @Test
    void getName() {
        assertThat(Airport.getName())
                .isEqualTo("airportName");
    }
}