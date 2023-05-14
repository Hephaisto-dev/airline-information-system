package datarecords;


import java.time.LocalDate;
import java.util.List;


public record BookingData(String id, String employeeId, List<String> ticketIds, LocalDate bookingDate,
                          List<String> extraIds, List<String> customerIds) {
}// THIS NEEDS TO BE CHANGED AFTER TICKETDATA IS CREATED!!!!
