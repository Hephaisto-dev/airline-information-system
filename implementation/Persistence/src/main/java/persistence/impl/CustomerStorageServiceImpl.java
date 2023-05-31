package persistence.impl;

import datarecords.CustomerData;
import persistence.api.CustomerStorageService;
import persistence.api.exceptions.DataBaseException;
import persistence.api.exceptions.PersistanceException;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
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
    public CustomerData add(CustomerData customerData) throws PersistanceException {

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
        } catch (SQLException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            throw new DataBaseException(e.getMessage());
        }
        return null;
    }

    @Override
    public Set<CustomerData> getAll() {
        String query = "SELECT * FROM customers";

        Set<CustomerData> customerDatas = new HashSet<>();
        try (Connection con = dataSource.getConnection(); PreparedStatement pstm = con.prepareStatement(query)) {
            ResultSet result = pstm.executeQuery();
            while (result.next()) {
                String id = result.getString("id");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                LocalDate dob = result.getDate("dob").toLocalDate();
                String email = result.getString("email");

                CustomerData customerData = new CustomerData(id, firstName, lastName, dob, email);
                customerDatas.add(customerData);
            }
        } catch (SQLException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
        }
        return customerDatas;
    }

    @Override
    public boolean remove(String id) {
        String query = "DELETE FROM customers WHERE id = ?";
        try (Connection con = dataSource.getConnection(); PreparedStatement pstm = con.prepareStatement(query)) {
            pstm.setString(1, id);
            int i = pstm.executeUpdate();
            return i == 1;
        } catch (SQLException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
