package persistence.api;

import datarecords.FlightData;
import datarecords.TicketData;

public interface TicketStorageService extends StorageService<TicketData>{
    TicketData add(TicketData ticketData);
}
