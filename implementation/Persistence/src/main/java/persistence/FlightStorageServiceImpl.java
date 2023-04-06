package persistence;

import datarecords.AirplaneData;
import datarecords.AirportData;
import datarecords.FlightData;
import datarecords.RouteData;
import persistence.database.DBProvider;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FlightStorageServiceImpl implements FlightStorageService {



    @Override
    public FlightData add(FlightData flightData) {


        DataSource db = DBProvider.getDataSource("jdbc.pg.prod");

        String query = "INSERT INTO flightdata (id, routedatafrom, routedatatoo, etddatetime, etadatetime, " +
                "flightduration, airplaneid) values (?, ?, ?, ?, ?, ?, ?) returning *";


        try (Connection con = db.getConnection(); PreparedStatement pstm = con.prepareStatement(query)) {

            String id = flightData.id();
            RouteData routeData = flightData.routeData();
            String routedatafrom = routeData.from().id();
            String routedatatoo = routeData.to().id();
            String etddatetime = flightData.etaDateTime().toString();
            String etadatetime = flightData.etdDateTime().toString();
            long flightduration = flightData.flightDuration().getSeconds();
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

    @Override
    public List<FlightData> getAll() {
        DataSource db = DBProvider.getDataSource("jdbc.pg.prod");

        String query = "SELECT * FROM flightdata";


        List<FlightData> flightData = new ArrayList<>();
        try (Connection con = db.getConnection(); PreparedStatement pstm = con.prepareStatement(query)) {
            ResultSet result = pstm.executeQuery();
            while (result.next()) {
                String id = result.getString("id");
                String routedatafrom = result.getString("routedatafrom");
                String routedatatoo = result.getString("routedatatoo");
                String etddatetime = result.getString("etddatetime");
                String etadatetime = result.getString("etadatetime");
                int flightduration = result.getInt("flightduration");
                String airplaneid = result.getString("airplaneid");
                flightData.add(new FlightData(id, new RouteData(new AirportData(routedatafrom, "oui", "non", "Baguette"),
                        new AirportData(routedatatoo, "yes", "no", "Pudding")),
                        LocalDateTime.parse(etddatetime), LocalDateTime.parse(etadatetime),
                        Duration.ofSeconds(flightduration),
                        new AirplaneData(airplaneid, "name", 10, 20)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flightData;
    }
}

