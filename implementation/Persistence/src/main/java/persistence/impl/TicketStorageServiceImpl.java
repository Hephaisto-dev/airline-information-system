package persistence.impl;

import datarecords.TicketData;
import persistence.api.TicketStorageService;
import persistence.impl.database.DBProvider;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TicketStorageServiceImpl implements TicketStorageService {
    private final DataSource dataSource;

    public TicketStorageServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public TicketData add(TicketData ticketData) {


        DataSource db = DBProvider.getDataSource("jdbc.pg.prod");

        String query = "INSERT INTO tickets (ticket_id, flight_id, customer_id, price) values (?, ?, ?, ?) returning *";


        try (Connection con = db.getConnection(); PreparedStatement pstm = con.prepareStatement(query)) {

            String T_id = ticketData.ticketId();
            String F_id = ticketData.flightId();
            String C_id = ticketData.customerId();
            int price = ticketData.price();

            pstm.setString(1, T_id);
            pstm.setString(2, F_id);
            pstm.setString(3, C_id);
            pstm.setInt(4, price);


            ResultSet result = pstm.executeQuery();

            System.out.println("JUST INSERTED: ");
            while (result.next()) {
                T_id = result.getString("ticket_id");
                F_id = result.getString("flight_id");
                C_id = result.getString("customer_id");
                price = result.getInt("price");

                System.out.println("Customer with id: " + T_id + ", " + F_id + ", " + C_id + ", " + price);
            }

        } catch (SQLException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return ticketData;
    }
}
