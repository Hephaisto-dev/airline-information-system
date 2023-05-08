package persistence.impl;

import datarecords.*;
import persistence.api.BookingStorageService;
import persistence.impl.database.DBProvider;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
        DataSource db = DBProvider.getDataSource("jdbc.pg.prod");

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

        String query = "SELECT * FROM everything_for_booking";// todo do this <------


        String queryWithCustomers = "select c .id,c.dob,c.email,c.firstname,c.lastname,b.id,b.emp_id,b.flight_id,b. from booking_data b inner join customer_booking cb on b.id = cb.booking_id inner join customerdata c on cb.customer_id = c.id where b.id = id(?);";

        List<CustomerData> customers = new ArrayList<>();
        Set<BookingData> bookingData = new HashSet<BookingData>();
        try (Connection con = db.getConnection(); PreparedStatement pstm = con.prepareStatement(query)) {
            ResultSet result = pstm.executeQuery();
            while (result.next()) {




                String airplaneId = result.getString("airplaneid");
                String airplaneName = result.getString("airplaneName");
                int airplaneLenght = result.getInt("airplaneLength");
                int airplaneWidth = result.getInt("airplaneWidth");

                LocalDateTime bookingDate = LocalDateTime.parse(result.getString("booking_date"));
                String bookingId = result.getString("bookingid");
                String customerId = result.getString("customerid");

                LocalDate dob = LocalDate.parse(result.getString("dob"));
                String email = result.getString("email");
                String emp_id = result.getString("emp_id");
                LocalDateTime etaDateTime = LocalDateTime.parse(result.getString("etadatetime"));
                LocalDateTime etdDatetime = LocalDateTime.parse(result.getString("etddatetime"));
                String firstName = result.getString("firstname");
                String flightDuration = result.getString("flightduration");
                String flightId = result.getString("flightid");
                String lastName = result.getString("lastname");



                String airportIdFrom = result.getString("airportIdFrom");
               // String airportCityFrom = result.getString("airportCityFrom");
                String airportCountryFrom = result.getString("airportCountryFrom");
                String airportNameFrom = result.getString("airportNameFrom");


                String airportIdTo = result.getString("airportIdTo");
               // String airportCityTo = result.getString("airportCityTo");
                String airportCountryTo = result.getString("airportCountryTo");
                String airportNameTo = result.getString("airportNameTo");

                String bookingIdInUse="0";
                String selectedCustomerId="0";
                FlightData selectedFlight=null;
                AirportData selectedAirportFrom=null;
                AirportData selectedAirportTo=null;
                CustomerData selectedCustomer=null;

                if(bookingIdInUse=="0"){
                    bookingIdInUse=bookingId;
                }
                if(bookingIdInUse==bookingId){

                    if(selectedCustomerId==customerId){
                    customers.add(new CustomerData(customerId,firstName,lastName,dob,email));
                    }
                    selectedFlight =
                            new FlightData(flightId,
                            new RouteData(
                            new AirportData(airportIdFrom,airportNameFrom,null,airportCountryFrom),
                            new AirportData(airportIdTo,airportNameTo,null,airportCountryTo), null), etdDatetime, etaDateTime, Duration.parse(flightDuration),
                            new AirplaneData(airplaneId,airplaneName,airplaneLenght,airplaneWidth));






                }
                else{

                    bookingData.add(new BookingData(bookingId, emp_id, selectedFlight, null/*TODO not yet implemented*/, bookingDate, null, customers));

                }
                bookingIdInUse = bookingId;
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
