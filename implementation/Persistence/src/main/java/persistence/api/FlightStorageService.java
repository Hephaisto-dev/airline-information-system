package persistence.api;

import datarecords.FlightData;

public interface FlightStorageService extends StorageService<FlightData> {
    FlightData add(FlightData flightData);
}
