package persistence;

import datarecords.BookingData;
import datarecords.FlightData;
import persistence.database.DBProvider;

import javax.sql.DataSource;
import java.sql.*;
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
    public BookingData add(BookingData bookingData){

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
            pstm.setString(3,bookingdate);



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
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bookingData;
    }


    @Override
    public List<BookingData> getAll() {
        DataSource db = DBProvider.getDataSource("jdbc.pg.prod");

        String query = "SELECT * FROM booking_data";


        List<BookingData> bookingData = new ArrayList<>();
        try (Connection con = db.getConnection(); PreparedStatement pstm = con.prepareStatement(query)) {
            ResultSet result = pstm.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String empId = result.getString("emp_Id");
                String flight = result.getString("flight_Id");
                String bookingDate = result.getString("booking_Date");

                bookingData.add(new BookingData(Integer.toString(id),empId,new FlightData(flight,null,null,null,null,null),null,LocalDateTime.parse(bookingDate),null,null));
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
    public boolean cancelBooking(String id){
        boolean confirm = false;

        DataSource db = DBProvider.getDataSource("jdbc.pg.prod");
        int idToDelete = Integer.parseInt(id);

        String query = "DELETE FROM booking_Data WHERE id = (idToDelete)VALUES(?)";

        try (Connection con = db.getConnection(); PreparedStatement pstm = con.prepareStatement(query)) {
            pstm.setInt(1, idToDelete);

            int result = pstm.executeUpdate();
            if(result==0){

                confirm = false;
            }
            else {
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
