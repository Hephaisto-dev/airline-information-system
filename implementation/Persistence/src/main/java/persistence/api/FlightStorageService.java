package persistence.api;

import datarecords.FlightData;
import persistence.StorageService;

public interface FlightStorageService extends StorageService<FlightData> {
    FlightData add(FlightData flightData);
}
