package persistence.api;

import datarecords.AirplaneData;
import datarecords.AirportData;
import datarecords.FlightData;

import java.time.LocalDateTime;
import java.util.Set;

public interface FlightStorageService extends StorageService<FlightData> {
    Set<FlightData> getAll(String id, LocalDateTime etd, LocalDateTime eta, AirplaneData airplane, AirportData departureAirport, AirportData arrivalAirport);
}
