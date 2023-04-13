package businesslogic.api.booking;

import businesslogic.api.flight.FlightFactory;

import businesslogic.api.manager.BookingManager;
import datarecords.CustomerData;
import datarecords.FlightData;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class BookingCreator {
    private final BookingManager bookingManager;

    public BookingCreator(BookingManager manage) {

        this.bookingManager = manage;    }

    public String createBooking(String id, String empId, FlightData flight, ArrayList<String> Tickets, LocalDateTime bookingDate, ArrayList<String> extras, ArrayList<CustomerData> customersOnBooking) {

// TODO SILL SOME RESTRICTIONS MISSING BECAUSE OF NOT IMPLEMENTED CLASSES

        boolean errors = false;


        StringBuilder stringBuilder = new StringBuilder();


        if (id == null || empId == null || flight == null || Tickets == null || bookingDate == null || customersOnBooking == null)//Extras can be null
        {
            errors = true;
            stringBuilder.append("All fields must be filled in!(except extras)\n");
        }


        if (customersOnBooking.stream().count() == 0){


            errors = true;
            stringBuilder.append("a booking must countain at least 1 person!\n");
        }

        if (Tickets.stream().count() == 0){

            errors = true;
            stringBuilder.append("a error happend while generating tickets!\n");
        }

        try {

        } catch (Exception a) {
            errors = true;
            stringBuilder.append("Error?!\n");
        }


        if (!errors) {
            try {
                Booking booking = BookingFactory.createBooking(id,empId,flight,Tickets,bookingDate,extras,customersOnBooking);

                bookingManager.add(booking);
            } catch (Exception e) {
                return "There seems to be an issue with the database, please try again." + "\n"
                        + "+If the issue persists, contact the IT department";
            }
            return "Booking was successfully created";
        } else {
            stringBuilder.append("Please correct this and try again");
            return stringBuilder.toString();
        }
    }
}
