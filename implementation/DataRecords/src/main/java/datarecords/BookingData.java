package datarecords;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;

public record BookingData(String id, String empId, FlightData flight, ArrayList<String> Tickets, LocalDateTime bookingDate, ArrayList<String> extras, ArrayList<CustomerData> customerInBooking) {
}// THIS NEEDS TO BE CHANGED AFTER TICKETDATA IS CREATED!!!!
