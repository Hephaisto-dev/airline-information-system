package businesslogic.api.customer;

import businesslogic.api.airplane.Airplane;
import businesslogic.api.flight.Flight;
import businesslogic.implementation.AirplaneImpl;
import businesslogic.implementation.AirportImpl;
import businesslogic.implementation.FlightImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class TicketImplTest {


    @Mock
    Flight flew;

    AirportImpl from = new AirportImpl("FROM", "FROM", "FROM", "FROM");
    AirportImpl to = new AirportImpl("TO", "TO", "TO", "TO");
    //Route route = new RouteImpl(from, to);//Saved for conveniece, if we decide to provide routes somewhere in the Ticket
    LocalDateTime futureFar = LocalDateTime.of(2244, 2, 1, 4, 5);
    LocalDateTime futureNear = LocalDateTime.of(2244, 2, 1, 3, 4);
    Airplane plane = new AirplaneImpl("PLANEiD", "plane", 123, 1);

    Flight flyer = new FlightImpl(from, to, futureNear, futureFar, plane);
    TicketImpl Ticket = new TicketImpl("person", flyer, "15D");


    @Test
    void getTicketID() {
        assertThat(Ticket.getTicketID())
                .isEqualTo("Ti_PLANEiD:FROM-TO_1.FEBRUARY.2244_15D");
    }

    @Test
    void getTicketOwner() {
        assertThat(Ticket.getTicketOwner())
                .isEqualTo("person");
    }

    @Test
    void getFlight() {
        assertThat(Ticket.getFlight())
                .isEqualTo(flyer);
    }

    @Test
    void getSeat() {
        assertThat(Ticket.getSeat())
                .isEqualTo("15D");
    }

    @Test
    void getRouteDescription() {
        assertThat(Ticket.getRouteDescription())
                .isEqualTo(from.getId() + "-" + to.getId());
    }

    /*
    Mockito.when(flew.getId()).thenReturn("PLANEiD");
        Mockito.when(flew.getRoute().getFrom().getId()).thenReturn("FROM");
        Mockito.when(flew.getRoute().getTo().getId()).thenReturn("TO");
        Mockito.when(flew.getETD().getDayOfMonth()).thenReturn(1);
        Mockito.when(flew.getETD().getMonth().toString()).thenReturn("Feb");
        Mockito.when(flew.getETD().getYear()).thenReturn(2244);
     */
}