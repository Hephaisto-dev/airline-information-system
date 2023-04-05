package persistence;

import datarecords.FlightData;
import datarecords.RouteData;
import persistence.database.DBProvider;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FlightStorageServiceImpl implements FlightStorageService {
    @Override
    public FlightData add(FlightData flightData) {


        DataSource db = DBProvider.getDataSource("jdbc.pg.prod");

        String query = "INSERT INTO flightdata (id, routedatafrom, routedatatoo, etddatetime, etadatetime, flightduration, airplaneid) values (?, ?, ?, ?, ?, ?, ?) returning *";


        try (Connection con = db.getConnection(); PreparedStatement pstm = con.prepareStatement(query)) {

            String id = flightData.id();
            RouteData routeData = flightData.routeData();
            String routedatafrom = routeData.from().id();
            String routedatatoo = routeData.to().id();
            String etddatetime = flightData.etaDateTime().toString();
            String etadatetime = flightData.etdDateTime().toString();
            long seconds = flightData.flightDuration().getSeconds();
            long flightduration = seconds;
            String airplaneid = flightData.airplane().id();

            pstm.setString(1, id);
            pstm.setString(2, routedatafrom);
            pstm.setString(3, routedatatoo);
            pstm.setString(4, etddatetime);
            pstm.setString(5, etadatetime);
            pstm.setLong(6, flightduration);
            pstm.setString(7, airplaneid);


            ResultSet result = pstm.executeQuery();

            System.out.println("JUST INSERTED: ");
            while (result.next()) {
                id = result.getString("id");
                routedatafrom = result.getString("routedatafrom");
                routedatatoo = result.getString("routedatatoo");
                etddatetime = result.getString("etddatetime");
                etadatetime = result.getString("etadatetime");
                flightduration = result.getInt("flightduration");
                airplaneid = result.getString("airplaneid");

                System.out.println("Customer with id: " + id + ", " + routedatafrom + ", " + routedatatoo + ", " + etddatetime + ", " + etadatetime + ", " + flightduration + ", " + airplaneid);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flightData;
    }
}

