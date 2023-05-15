package persistence.impl;

import datarecords.BookingData;
import persistence.api.BookingStorageService;
import persistence.impl.database.DBProvider;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
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

//this is just to see all values of booking id, empId, flightIds, ticketIds, bookingDate, extraIds, customerIds

        String query = "INSERT INTO bookings(id,employee_id,date) values (?,?, ?, ?) returning *";


        try (Connection con = dataSource.getConnection(); PreparedStatement pstm = con.prepareStatement(query)) {

            String id = bookingData.id();
            String empId = bookingData.employeeId();
            LocalDate bookingdate = bookingData.bookingDate();

            //TODO IMPLEMENT Extras?!
            //TODO IMPLEMENT Customers?!
            //TODO IMPLEMENT ticketIds?!

            pstm.setString(1, id);
            pstm.setString(2, empId);
            pstm.setDate(3, Date.valueOf(bookingdate));


            ResultSet result = pstm.executeQuery();

            System.out.println("JUST INSERTED: ");
            while (result.next()) {
                id = result.getString("id");
                empId = result.getString("employee_id");
                bookingdate = result.getDate("date").toLocalDate();

                System.out.println("Booking with id: " + id + ", " + empId + ", " + bookingdate);


            }

        } catch (SQLException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return bookingData;
    }


    @Override
    public Set<BookingData> getAll() {
        String query = "SELECT * FROM bookings";


        Set<BookingData> bookingData = new HashSet<>();
        try (Connection con = dataSource.getConnection(); PreparedStatement pstm = con.prepareStatement(query)) {
            ResultSet result = pstm.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String empId = result.getString("employee_id");
                LocalDate bookingDate = result.getDate("date").toLocalDate();

                // TODO get the tickets from the database
                // TODO get the customerIds from the database
                // TODO get the extras from the database
                bookingData.add(new BookingData(Integer.toString(id), empId, new ArrayList<>(), bookingDate, new ArrayList<>(), new ArrayList<>()));
            }
        } catch (SQLException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
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
//                String flightIds = result.getString("flight_Id");
//                String bookingDate = result.getString("booking_Date");
//                bookingdata = new BookingData(Integer.toString(id),empId,new FlightData(flightIds,null,null,null,null,null),null,LocalDateTime.parse(bookingDate),null,null);
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
        boolean confirm = false;

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
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
        }

        return confirm;

    }
}
