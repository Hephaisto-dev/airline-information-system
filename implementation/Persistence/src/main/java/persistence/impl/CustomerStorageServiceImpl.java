package persistence.impl;

import datarecords.CustomerData;
import persistence.api.CustomerStorageService;

import javax.sql.DataSource;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

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
                Date dateOfBirth = result.getDate("dob");
                String email = result.getString("email");

                customerDatas.add(new CustomerData(id, firstName, lastName, dateOfBirth.toLocalDate(), email));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerDatas;
    }
}
