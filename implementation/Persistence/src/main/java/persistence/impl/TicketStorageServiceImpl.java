package persistence.impl;

import datarecords.TicketData;
import persistence.api.TicketStorageService;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import persistence.api.TicketStorageService;
import persistence.api.exceptions.CustomerException;
import persistence.api.exceptions.PersistanceException;

public class TicketStorageServiceImpl implements TicketStorageService {
    private final DataSource dataSource;

    public TicketStorageServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public TicketData add(TicketData ticketData) throws CustomerException {

        String query = "INSERT INTO tickets (id, flight_id, customer_id, price, seat_id) values (?, ?, ?, ?, ?) returning *";


        try (Connection con = dataSource.getConnection(); PreparedStatement pstm = con.prepareStatement(query)) {

            String T_id = ticketData.id();
            String F_id = ticketData.flightId();
            String C_id = ticketData.customerId();
            int price = ticketData.price();
            String seat = ticketData.seatId();

            pstm.setString(1, T_id);
            pstm.setString(2, F_id);
            pstm.setString(3, C_id);
            pstm.setInt(4, price);
            pstm.setString(5,seat);


            ResultSet result = pstm.executeQuery();

            System.out.println("JUST INSERTED: ");
            while (result.next()) {
                T_id = result.getString("id");
                F_id = result.getString("flight_id");
                C_id = result.getString("customer_id");
                price = result.getInt("price");
                seat = result.getString("seat_id");

                System.out.println("Ticket with id: " + T_id + ", " + F_id + ", " + C_id + ", " + price + ", " + seat);
            }

        } catch (SQLException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getErrorCode());
            System.out.println(ex.getMessage());
            String exception = ex.getMessage();
            char quotationMarks = '"';
            if(exception.contains("Detail: Key (customer_id)=(")
                && exception.contains(") is not present in table " + quotationMarks + "customers" + quotationMarks)){
                throw new CustomerException("Customer_ID not in our Database");
            }
        }
        return ticketData;
    }
}
