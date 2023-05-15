package persistence.impl;

import datarecords.CustomerData;
import persistence.api.CustomerStorageService;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class knows everything about storing and retrieving customers from
 * the database. At the moment only returns dummy object with an id that is set.
 * Normally it will connect to a database and do all the handling.
 *
 * @author Informatics Fontys Venlo
 */
public class CustomerStorageServiceImpl implements CustomerStorageService {
    private final DataSource dataSource;

    public CustomerStorageServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public CustomerData add(CustomerData customerData) {

        String query = "INSERT INTO customers values (?,?,?,?,?)";


        try (Connection con = dataSource.getConnection(); PreparedStatement pstm = con.prepareStatement(query)) {
            pstm.setString(1, customerData.id());
            pstm.setString(2, customerData.firstName());
            pstm.setString(3, customerData.lastName());
            pstm.setDate(4, Date.valueOf(customerData.dob()));
            pstm.setString(5, customerData.email());

            int i = pstm.executeUpdate();
            if (i == 1) {
                return customerData;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public CustomerData getCustomer(String customer_Id) {
        //DataSource db = DBProvider.getDataSource("jdbc.pg.prod");//other solution
        String query = "SELECT * FROM bookings WHERE id = ?";
        CustomerData customer = null;

        try (Connection con = dataSource.getConnection(); PreparedStatement pstm = con.prepareStatement(query)) {
            pstm.setString(1, customer_Id);
            ResultSet result = pstm.executeQuery();
            System.out.println("JUST RECEIVED: ");
            String id = "";
            String fName = "";
            String lName = "";
            LocalDate lDate = null;
            String mail = "";
            while (result.next()) {
                id = result.getString("id");
                fName = result.getString("emp_Id");
                lName = result.getString("flight_Id");
                Date dobSQL = result.getDate("booking_Date");
                mail = result.getString("email");
                lDate = dobSQL.toLocalDate();
                System.out.println("Customer with id: " + id + ", " + fName + ",id: " + lName + ", " + lDate + ", " + mail);
            }
            customer = new CustomerData(id, fName, lName, lDate, mail);

        } catch (SQLException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return customer;
    }
    /*
    alternative: CustomerManager.getById(customerId);
     */
}
