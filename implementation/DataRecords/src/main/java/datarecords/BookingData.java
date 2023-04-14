package datarecords;


import java.time.LocalDateTime;
import java.util.List;


public record BookingData(String id, String empId, FlightData flight, List<String> Tickets, LocalDateTime bookingDate,
                          List<String> extras, List<CustomerData> customerInBooking) {
}// THIS NEEDS TO BE CHANGED AFTER TICKETDATA IS CREATED!!!!
