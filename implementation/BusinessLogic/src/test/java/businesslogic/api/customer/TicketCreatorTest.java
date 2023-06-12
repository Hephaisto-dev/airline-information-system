package businesslogic.api.customer;

import businesslogic.api.airplane.Airplane;
import businesslogic.api.flight.Flight;
import datarecords.TicketData;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import persistence.api.exceptions.CustomerException;
import persistence.impl.TicketStorageServiceImpl;

class TicketCreatorTest {

    private TicketCreator creator;
    private TicketCreator noCustomerCreator;
    private PriceImpl cost1 = new PriceImpl(1000);
    @Mock
    private TicketStorageServiceImpl TSS;
    @Mock
    private TicketStorageServiceImpl NoCustomerTSS;
    @Mock
    private Flight flyer;
    @Mock
    private Airplane planeMock;

    private TicketData ticketInfo = new TicketData("MockPlane1A", "MockPlane", "Customer", 49, "4D");

    @BeforeEach
    public void initMock() throws Exception {
        //It doesn't throw an Exception due to mocking, but Java is a whiny bitch
        MockitoAnnotations.openMocks(this);
        Mockito.when(TSS.add(new TicketData("MockPlane1A", "MockPlane", "Customer", 49, "4D")))
                .thenReturn(ticketInfo);
        Mockito.when(NoCustomerTSS.add(new TicketData("MockPlane3C", "MockPlane", "Customer", 1000, "3C")))
                .thenThrow(new CustomerException("Customer_ID not in our Database"));
        Mockito.when(flyer.bookSeat(1, 'A')).thenReturn("successfully");
        Mockito.when(flyer.bookSeat(141, 'B')).thenReturn("Failure");
        Mockito.when(flyer.bookSeat(3, 'C')).thenReturn("successfully");
        Mockito.when(flyer.getId()).thenReturn("MockPlane");
        Mockito.when(flyer.getAirplane()).thenReturn(planeMock);
        Mockito.when(planeMock.getLength()).thenReturn(12);
        Mockito.when(planeMock.getWidth()).thenReturn(6);
        Mockito.when(flyer.getPrice()).thenReturn(cost1);
        creator = new TicketCreator(TSS);
        noCustomerCreator = new TicketCreator(NoCustomerTSS);
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
    void createTicket(String CHAR, String NUM, String cus, String discount, String voucher, String expectation) {

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(creator.createTicket(flyer, NUM, CHAR, cus, discount, voucher))
                    .contains(expectation);
        });
    }

    @Test
    void noCustomer() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(noCustomerCreator.createTicket(flyer, "3", "C", "Customer", "0", "0"))
                    .contains("not present in database");
        });
    }

    @Test
    void createEmpty() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(creator.createTicket(null, null, null, null, null, null))
                    .contains("Please");
        });
    }
}