package businesslogic.api.customer;

import datarecords.TicketData;

public interface TicketFactory {
    static Ticket createTicket(TicketData tick){
        return new TicketImpl(tick);
    }
}
