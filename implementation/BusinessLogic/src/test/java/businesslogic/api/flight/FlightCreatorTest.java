package businesslogic.api.flight;

import businesslogic.api.airplane.Airplane;
import businesslogic.api.airplane.AirplaneFactory;
import businesslogic.api.airport.Airport;
import businesslogic.api.airport.AirportFactory;
import businesslogic.api.airport.NoAirportException;
import businesslogic.api.manager.FlightManager;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import persistence.api.FlightStorageService;

import java.time.LocalDateTime;
import java.util.HashMap;

class FlightCreatorTest {


    static HashMap<String, Airport> AirportHash = new HashMap<>();
    static Airport port1;
    static Airport port2;
    static Airport port3;//This one is to be a wrong Airport, once we know
    // how to do that
    static HashMap<String, LocalDateTime> LDTHash = new HashMap<>();
    static LocalDateTime LDT1 = LocalDateTime.of(2024, 2, 2, 1, 23, 45);
    static LocalDateTime LDT2 = LocalDateTime.of(2024, 2, 2, 2, 2, 2);
    static LocalDateTime LDT3 = LocalDateTime.of(2024, 3, 4, 5, 6, 7);
    static LocalDateTime LDT4 = LocalDateTime.of(2020, 2, 2, 2, 2, 2);
    static LocalDateTime nullTime = null;
    static HashMap<String, Airplane> PlaneHash = new HashMap<>();
    static Airplane plane1 = AirplaneFactory.createAirplane("Fly", "me", 123, 1);
    static Airplane plane2 = AirplaneFactory.createAirplane("Flighter", "planeType", 150, 1);//needs to be faulty plane

    static {
        try {
            port1 = AirportFactory.createAirport("DUS");
        } catch (NoAirportException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        try {
            port2 = AirportFactory.createAirport("NYC");
        } catch (NoAirportException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        try {
            port3 = AirportFactory.createAirport("WRONG");
        } catch (NoAirportException e) {
            throw new RuntimeException(e);
        }
    }

    private final FlightStorageService FSSI = data -> data;
    private final FlightManager FM = new FlightManager(FSSI);
    FlightCreator flightCreator = new FlightCreator(FM);
    // later

    @BeforeAll
    static void prepareHashMaps() {
        AirportHash.put("works1", port1);
        AirportHash.put("works2", port2);
        AirportHash.put("notwork", port3);
        LDTHash.put("early", LDT1);
        LDTHash.put("middle", LDT2);
        LDTHash.put("late", LDT3);
        LDTHash.put("nuTime", nullTime);
        LDTHash.put("pastTime", LDT4);
        PlaneHash.put("workingPlane", plane1);
        PlaneHash.put("faultyPlane", plane2);
    }

    @ParameterizedTest
    @CsvSource({

            "FROM,TO,2020-02-02T02:02:02,2020-02-02T03:02:01,plane,Ensure that the flight times aren't in the past",
            //correct
            "FROM,TO,2023-12-12T12:12:12,2023-12-11T11:11:11,plane,Time of departure must be before time of arrival",
            //correct
            "FROM,TO,2023-12-12T12:12:12,2023-12-12T15:15:15,plane,Flight was successfully created", //correct
            "FROM,TO,2021-12-12T12:12:12,2023-12-12T15:15:15,plane,Departure time must be in the present/future",
            "FROM,TO,2023-12-12T12:12:12,2021-12-12T15:15:15,plane,Arrival time must be in the present/future",
            "FROM,TO,2023-12-1212:12:12,2023-12-1215:15:15,plane,Arrival Time is not entered correctly",
            //",TO,2023-12-12T12:12:12,2023-12-12T15:15:15,plane,No departure destination was provided", -> line 87
            // to 91 i cannot do sorry
            //"FROM,,2023-12-12T12:12:12,2023-12-12T15:15:15,plane,No arrival destination was provided",
            //"FROM,TO,,2023-12-12T15:15:15,plane,No departure time was provided",
            //"FROM,TO,2023-12-12T12:12:12,,plane,No arrival time was provided",
            //"FROM,TO,2023-12-12T12:12:12,2023-12-12T15:15:15,,No plane was provided",

            //also tests about the different types of data that can be processed

    })
    void createFlight(String place1, String place2, String time1, String time2, String plane, String expectation) {
        String answer = flightCreator.createFlight(place1, place2, time1, time2, plane);
        SoftAssertions.assertSoftly(softly -> softly.assertThat(answer)
                .contains(expectation));
    }

    @ParameterizedTest
    @CsvSource({
            "port1,port2,early,late,plane1,Flight was successfully created",
            "port1,port2,late,early,plane1,departure must be before time of arrival",
            //"port3,port2,early,normal,plane1,Departure airport does not exist",
            //"port1,port3,early, normal,plane1,Arrival airport does not exist",
            "port1,port2,nuTime,late,plane1,Departure Time is not entered",
            "port1,port2,early,nuTime,plane1,Arrival Time is not entered",
            "port1,port2,pastTime,early,plane1,times aren't in the past",
            "port1,port2,early,pastTime,plane1,times aren't in the past"
            //"port1,port2,early,late,plane2,provided ID does not exist in our database"
    })
//Commented out Tests are ready, but the implementation is lagging behind. Once it isn't anymore, we can use them
    void createFlightOverload(String place1, String place2, String time1, String time2, String plane,
                              String expectation) {
        String answer = flightCreator.createFlight(
                AirportHash.get(place1),
                AirportHash.get(place2),
                LDTHash.get(time1),
                LDTHash.get(time2),
                PlaneHash.get(plane)
        );
        SoftAssertions.assertSoftly(softly -> softly.assertThat(answer)
                .contains(expectation));
    }
}