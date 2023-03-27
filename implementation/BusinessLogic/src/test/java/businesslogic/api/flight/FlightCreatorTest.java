package businesslogic.api.flight;

import businesslogic.api.manager.FlightManager;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import persistence.FlightStorageServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class FlightCreatorTest {


    private FlightStorageServiceImpl FSSI = new FlightStorageServiceImpl();
    private FlightManager FM = new FlightManager(FSSI);
    FlightCreator flightCreator = new FlightCreator(FM);

    @ParameterizedTest
    @CsvSource({
            "FROM,TO,2020-02-02T02:02:02,2020-02-02T03:02:01,plane,Flight was successfully created",
            "a,b,c,d,e,f"
    })
    void createFlight(String place1, String place2, String time1, String time2, String plane, String expectation) {
        String answer = flightCreator.createFlight(place1, place2, time1,time2,plane);
        SoftAssertions.assertSoftly(softly->{
            softly.assertThat(answer)
                    .isNotEqualTo("wrongness");
        });
    }
}