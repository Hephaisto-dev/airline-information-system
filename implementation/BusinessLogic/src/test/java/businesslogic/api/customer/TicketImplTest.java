package businesslogic.api.customer;

import businesslogic.api.airplane.Airplane;

import businesslogic.api.airport.Airport;

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


    Airport from = new AirportImpl("FROM", "FROM", "FROM", "FROM");
    Airport to = new AirportImpl("TO", "TO", "TO", "TO");
    //Route route = new RouteImpl(from, to);//Saved for conveniece, if we decide to provide routes somewhere in the Ticket
    LocalDateTime futureFar = LocalDateTime.of(2244,2,1,4,5);
    LocalDateTime futureNear = LocalDateTime.of(2244,2,1,3,4);
    Airplane plane = new AirplaneImpl("PLANEiD", "plane", 123,1);
    Flight flyer = new FlightImpl(from, to, futureNear, futureFar, plane);
    Price cost = new PriceImpl(2000);
    Ticket ticket = new TicketImpl("person", flyer, "15D", cost);



    @Test
    void getTicketID() {
        assertThat(ticket.getId())
                .isEqualTo("Ti_PLANEiD:FROM-TO_1.FEBRUARY.2244_15D");
    }

    @Test
    void getTicketOwner() {
        assertThat(ticket.getTicketOwner())
                .isEqualTo("person");
    }

    @Test
    void getFlight() {
        assertThat(ticket.getFlight())
                .isEqualTo(flyer);
    }

    @Test
    void getSeat() {
        assertThat(ticket.getSeat())
                .isEqualTo("15D");
    }

    @Test
    void getRouteDescription(){
        assertThat(ticket.getRouteDescription())
                .isEqualTo(from.getId() + "-" + to.getId());
    }


    @Test
    void applyVoucher(){
        ticket.applyVoucher(25);
        assertThat(ticket.getPrice().getBackendPrice())
                .isEqualTo(1500);
    }

    @Test
    void applyDiscount(){
        ticket.applyDiscount(25);
        assertThat(ticket.getPrice().getBackendPrice())
                .isEqualTo(1975);
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