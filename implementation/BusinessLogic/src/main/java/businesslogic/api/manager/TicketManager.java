package businesslogic.api.manager;

import businesslogic.api.customer.Ticket;
import businesslogic.api.customer.TicketFactory;
import businesslogic.impl.ManagerImpl;
import datarecords.TicketData;
import persistence.api.StorageService;
import persistence.api.TicketStorageService;

public class TicketManager extends ManagerImpl<Ticket, TicketData> {


    private final StorageService storageService;

    public TicketManager(StorageService storageService) {
        super(storageService);
        this.storageService = storageService;
        forceUpdate();
    }
    /*public TicketManager(TicketStorageService ticki){
        super(ticki);
    }*/
    @Override
    protected Ticket createPersistantDataContainer(TicketData data) {
        return TicketFactory.createTicket(data);
    }
    public StorageService getStorageService(){
        return this.storageService;
    }
}
