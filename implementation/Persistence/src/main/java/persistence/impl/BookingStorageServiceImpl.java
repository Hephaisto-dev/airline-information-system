package persistence.impl;

import datarecords.BookingData;
import datarecords.FlightData;
import persistence.api.BookingStorageService;
import persistence.impl.database.DBProvider;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookingStorageServiceImpl implements BookingStorageService {
    private final DataSource dataSource;

    public BookingStorageServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public BookingData add(BookingData bookingData) {

//this is just to see all values of booking id, empId, flight, Tickets, bookingDate, extras, customerInBooking

        String query = "INSERT INTO bookings(id,employee_id, flight_id,date) values (?,?, ?, ?) returning *";


        try (Connection con = dataSource.getConnection(); PreparedStatement pstm = con.prepareStatement(query)) {

            String id = bookingData.id();
            String empId = bookingData.empId();
            String flight = bookingData.flight().id();
            String bookingdate = bookingData.bookingDate().toString();

            //TODO IMPLEMENT Extras?!
            //TODO IMPLEMENT Customers?!
            //TODO IMPLEMENT Tickets?!

            pstm.setString(1, id);
            pstm.setString(2, empId);
            pstm.setString(3, flight);
            pstm.setString(4, bookingdate);


            ResultSet result = pstm.executeQuery();

            System.out.println("JUST INSERTED: ");
            while (result.next()) {
                id = result.getString("id");
                empId = result.getString("emp_Id");
                flight = result.getString("flight_Id");
                bookingdate = result.getString("booking_Date");

                System.out.println("Booking with id: " + id + ", " + empId + ",id: " + flight + ", " + bookingdate);


            }

        } catch (SQLException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return bookingData;
    }


    @Override
    public Set<BookingData> getAll() {
        DataSource db = DBProvider.getDataSource("jdbc.pg.prod");

        String query = "SELECT * FROM bookings";


        Set<BookingData> bookingData = new HashSet<>();
        try (Connection con = db.getConnection(); PreparedStatement pstm = con.prepareStatement(query)) {
            ResultSet result = pstm.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String empId = result.getString("emp_Id");
                String flight = result.getString("flight_Id");
                String bookingDate = result.getString("booking_Date");

                bookingData.add(new BookingData(Integer.toString(id), empId, new FlightData(flight, null, null, null, null, null, null), null, null, null, null));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookingData;
    }

// This won't be used because specific searching will be done by the managers

//    public BookingData getBooking(String bookingId) {
//        DataSource db = DBProvider.getDataSource("jdbc.pg.prod");
//        BookingData bookingdata= null;
//
//
//        String query = "SELECT * FROM booking_data Where id = (id)VALUES(?)";
//
//
//        try (Connection con = db.getConnection(); PreparedStatement pstm = con.prepareStatement(query)) {
//            int bookingIdInt = Integer.parseInt(bookingId);//this is done because in the database id is auto incremented
//            pstm.setInt(1, bookingIdInt);
//
//            ResultSet result = pstm.executeQuery();
//            while (result.next()) {
//                int id = result.getInt("id");
//                String empId = result.getString("emp_Id");
//                String flight = result.getString("flight_Id");
//                String bookingDate = result.getString("booking_Date");
//                bookingdata = new BookingData(Integer.toString(id),empId,new FlightData(flight,null,null,null,null,null),null,LocalDateTime.parse(bookingDate),null,null);
//
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        return bookingdata;
//
//    }

    @Override
    public boolean remove(String id) {
        boolean confirm;

        DataSource db = DBProvider.getDataSource("jdbc.pg.prod");
        int idToDelete = Integer.parseInt(id);

        String query = "DELETE FROM bookings WHERE id = ?";

        try (Connection con = db.getConnection(); PreparedStatement pstm = con.prepareStatement(query)) {
            pstm.setInt(1, idToDelete);

            int result = pstm.executeUpdate();
            confirm = result != 0;
/*
            while (result.next()) { there is no result so nothing is read

            }
*/

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return confirm;

    }
}
