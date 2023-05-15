package businesslogic.api.customer;

import businesslogic.api.airplane.Airplane;
import businesslogic.api.airport.AirportFactory;
import businesslogic.api.airport.NoAirportException;
import businesslogic.api.flight.Flight;
import businesslogic.impl.AirplaneImpl;
import businesslogic.impl.FlightImpl;
import datarecords.FlightData;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import persistence.impl.TicketStorageServiceImpl;

class TicketCreatorTest {

    @Mock
    private TicketStorageServiceImpl TSS;
    @Mock
    private FlightImpl flyer;
    //private FlightImpl flight = new FlightImpl();

    private final String from = "DEPART";
    private final String to = "ARRIVE";
    private final LocalDateTime ldtd2 = LocalDateTime.of(2012, 12, 15, 12, 34);
    private final LocalDateTime ldta2 = LocalDateTime.of(2012, 12, 15, 15, 45);
    private final Airplane plane2 = new AirplaneImpl("Identification", "please", 123, 6);
    private Flight flightTwo;


    private TicketCreator Creator = new TicketCreator(TSS);
    private PriceImpl cost1 = new PriceImpl(1000);
    private List lister = new ArrayList();

    @BeforeEach
    public void initMock() throws NoAirportException {
        try{
            flightTwo = new FlightImpl(AirportFactory.createAirport(from),
                    AirportFactory.createAirport(to), ldtd2, ldta2, plane2);
        }catch(Exception e){

        }
        /*
        Mockito.when(flyer.bookSeat(1, 'A')).thenReturn("successfully");
        Mockito.when(flyer.bookSeat(141,'B')).thenReturn("Failure");
        Mockito.when(flyer.getAirplane().getLength()).thenReturn(12);
        Mockito.when(flyer.getAirplane().getWidth()).thenReturn(6);
        Mockito.when(flyer.getPrice()).thenReturn(cost1);*/
    }

    @ParameterizedTest
    @CsvSource({
            "A,1,Customer,2,50,Ticket booked",
            "AB,1,Customer,2,50,single letter",
            "a,1,Customer,2,50,Please designate",
            "A,2.50,Customer,2,50,without decimal",
            "A,2,Customer,2.50,50,non-decimal number",
            "A,2,Customer,2,2.50,non-decimal number"
    })
    void createTicket(String CHAR, String NUM, String cus, String discount, String voucher,String expectation) {

        SoftAssertions.assertSoftly(softly->{
            softly.assertThat(Creator.createTicket(flightTwo, CHAR, NUM, cus, discount, voucher))
                    .contains(expectation);
            /*softly.assertThat(Creator.createTicket(flight, CHAR, NUM, cus, discount, voucher))
                    .contains(expectation);*/
        });
    }

    @Test
    void createEmpty(){
        SoftAssertions.assertSoftly(softly->{
            softly.assertThat(Creator.createTicket(null, null, null, null, null,null))
                    .contains("Please");
        });
    }


    @Test
    void testCreateTicket() {
    }
}