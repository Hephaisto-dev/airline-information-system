package persistence.impl;

import datarecords.BookingData;
import persistence.api.BookingStorageService;
import persistence.api.exceptions.ConnectionException;
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

        String query = "INSERT INTO bookings(id,employee_id,date,main_customer,flight_id) values (?,?, ?, ?,?) returning *";
        String query2 = "INSERT INTO customers_bookings(customer_id,booking_id) values(?,?) returning *";

        try(Connection con = dataSource.getConnection();PreparedStatement pstm = con.prepareStatement(query);PreparedStatement pstm2 = con.prepareStatement(query2)){

            String id = bookingData.id();
            String empId = bookingData.employeeId();
            LocalDate bookingdate = bookingData.bookingDate();
            String mainCustomer = bookingData.mainCustomerId();
            String flightId = bookingData.flightId();

            pstm.setString(1, id);
            pstm.setString(2, empId);
            pstm.setDate(3, Date.valueOf(bookingdate));
            pstm.setString(4, mainCustomer);
            pstm.setString(5, flightId);


            ResultSet result = pstm.executeQuery();

            System.out.println("JUST INSERTED: ");
            while (result.next()) {
                id = result.getString("id");
                empId = result.getString("employee_id");
                bookingdate = result.getDate("date").toLocalDate();

                System.out.println("Booking with id: " + id + ", " + empId + ", " + bookingdate);

                for (String c : bookingData.customerIds()) {
                    pstm2.setString(1, c);
                    pstm2.setString(2, id);
                    pstm2.addBatch();
                }
                pstm2.executeBatch();

            }

        } catch (SQLException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }

        return bookingData;
    }


    @Override
    public Set<BookingData> getAll() {
        String query = "SELECT * FROM bookings";
        String query2 = "SELECT * FROM customer_bookings";


        Set<BookingData> bookingData = new HashSet<>();
        try(Connection con = dataSource.getConnection();PreparedStatement pstm = con.prepareStatement(query);PreparedStatement pstm2 = con.prepareStatement(query2)){
            ResultSet result = pstm.executeQuery();
            while (result.next()) {
                String id = result.getString("id");
                String empId = result.getString("employee_id");
                String mainCustomer = result.getString("main_customer");
                LocalDate bookingDate = result.getDate("date").toLocalDate();
                String flightId = result.getString("flight_id");


                bookingData.add(new BookingData(id, empId, new ArrayList<>(), bookingDate, new ArrayList<>(), mainCustomer, flightId));
            }
            ResultSet result2 = pstm2.executeQuery();
            while (result2.next()) {
                String bookingId = result.getString("booking_id");
                String customerId = result.getString("customer_id");
                for(BookingData b: bookingData){

                    if(bookingId==b.id()){
                        b.customerIds().add(customerId);
                    }
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
        }
        return bookingData;
    }





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
