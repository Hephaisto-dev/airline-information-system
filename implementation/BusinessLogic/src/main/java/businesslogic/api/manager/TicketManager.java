package businesslogic.api.manager;

import businesslogic.api.customer.Ticket;
import businesslogic.impl.ManagerImpl;
import datarecords.TicketData;
import persistence.api.TicketStorageService;

public class TicketManager extends ManagerImpl<Ticket, TicketData> {
    public TicketManager(TicketStorageService ticki){
        super(ticki);
    }
    @Override
    protected Ticket createPersistantDataContainer(TicketData data) {
        return null;
    }
}
