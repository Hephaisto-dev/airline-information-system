package datarecords;


import java.time.LocalDate;
import java.util.List;


public record BookingData(String id, String employeeId, List<String> ticketIds, LocalDate bookingDate,
                          List<String> extraIds, String mainCustomerId,String flightId) {
}
