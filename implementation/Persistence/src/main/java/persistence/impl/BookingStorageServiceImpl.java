package persistence.impl;

import datarecords.BookingData;
import datarecords.CustomerData;
import datarecords.FlightData;
import persistence.api.BookingStorageService;
import persistence.api.CustomerStorageService;
import persistence.impl.database.DBProvider;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
        DataSource db = DBProvider.getDataSource("jdbc.pg.prod");

        String query = "INSERT INTO booking_data(emp_Id, flight_Id,booking_Date) values (?, ?, ?) returning *";


        try (Connection con = db.getConnection(); PreparedStatement pstm = con.prepareStatement(query)) {


            String empId = bookingData.empId();
            String flight = bookingData.flight().id();
            String bookingdate = bookingData.bookingDate().toString();

            //TODO IMPLEMENT Extras?!
            //TODO IMPLEMENT Customers?!
            //TODO IMPLEMENT Tickets?!


            pstm.setString(1, empId);
            pstm.setString(2, flight);
            pstm.setString(3, bookingdate);


            ResultSet result = pstm.executeQuery();

            System.out.println("JUST INSERTED: ");
            while (result.next()) {
                int id = result.getInt("id");
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
    public List<BookingData> getAll() {
        DataSource db = DBProvider.getDataSource("jdbc.pg.prod");

        String query = "SELECT * FROM booking_data";// todo do this <------

        //todo add flightdata to query
        //todo add customerdata to query
        String queryWithCustomers = "select c.id,c.dob,c.email,c.firstname,c.lastname,b.id,b.emp_id,b.flight_id,b. from booking_data b inner join customer_booking cb on b.id = cb.booking_id inner join customerdata c on cb.customer_id = c.id where b.id = id(?);";


        List<BookingData> bookingData = new ArrayList<>();
        try (Connection con = db.getConnection(); PreparedStatement pstm = con.prepareStatement(query)) {
            ResultSet result = pstm.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String empId = result.getString("emp_Id");
                String flight = result.getString("flight_Id");
                String bookingDate = result.getString("booking_Date");

                String customerId = 0;

                if (customerId == Integer.toString(id)) {

                }
                //todo add flight data
                bookingData.add(new BookingData(Integer.toString(id), empId, new FlightData(flight, null, null, null, null, null), null, LocalDateTime.parse(bookingDate), null, null));
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

        String query = "DELETE FROM booking_data WHERE id = ?";

        try (Connection con = db.getConnection(); PreparedStatement pstm = con.prepareStatement(query)) {
            pstm.setInt(1, idToDelete);

            int result = pstm.executeUpdate();
            if (result == 0) {

                confirm = false;
            } else {
                confirm = true;
            }
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

//    @Override//Not the right location
//    public List<CustomerData> getCustomersOnBooking(String bookingId) {
//        DataSource db = DBProvider.getDataSource("jdbc.pg.prod");
//
//        String query = "select c.id,c.dob,c.email,c.firstname,c.lastname from booking_data b inner join customer_booking cb on b.id = cb.booking_id inner join customerdata c on cb.customer_id = c.id where b.id = id(?);";
//
//
//        List<CustomerData> customerData = new ArrayList<>();
//        try (Connection con = db.getConnection(); PreparedStatement pstm = con.prepareStatement(query)) {
//            pstm.setInt(1, Integer.parseInt(bookingId));
//
//            ResultSet result = pstm.executeQuery();
//            while (result.next()) {
//                String id = result.getString("id");
//                String email = result.getString("email");
//                LocalDateTime dob = LocalDateTime.parse(result.getDate("dob"));
//                String firstName = result.getString("email");
//                String lastName = result.getString("email");
//
//                customerData.add(new CustomerData(id,firstName,lastName,dob,email));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return customerData;
//
//    return customerData;
//    }
//}
