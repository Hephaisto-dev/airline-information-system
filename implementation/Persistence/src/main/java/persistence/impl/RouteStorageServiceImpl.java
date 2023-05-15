package persistence.impl;

import datarecords.FlightData;
import datarecords.RouteData;
import persistence.api.RouteStorageService;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RouteStorageServiceImpl implements RouteStorageService {

    private final DataSource dataSource;
    protected FlightData flightData;

    public RouteStorageServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public RouteData add(RouteData routeData) {

        String query = "INSERT INTO routes (id, fromm, too) values (?, ?, ?) returning *";


        try (Connection con = dataSource.getConnection(); PreparedStatement pstm = con.prepareStatement(query)) {

            String id = routeData.id();
            String fromm = flightData.departureAirportId();
            String too = flightData.arrivalAirportId();


            pstm.setString(1, id);
            pstm.setString(2, fromm);
            pstm.setString(3, too);


            ResultSet result = pstm.executeQuery();

            System.out.println("JUST INSERTED: ");
            while (result.next()) {
                id = result.getString("id");
                fromm = result.getString("fromm");
                too = result.getString("too");


                System.out.println("Customer with id: " + id + ", " + fromm + ", " + too);
            }

        } catch (SQLException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return routeData;
    }


//    @Override
//    public List<FlightData> getAll() {
//        DataSource db = DBProvider.getDataSource("jdbc.pg.prod");
//
//        String query = "SELECT * FROM flightdata";
//
//
//        List<FlightData> flightData = new ArrayList<>();
//        try (Connection con = db.getConnection(); PreparedStatement pstm = con.prepareStatement(query)) {
//            ResultSet result = pstm.executeQuery();
//            while (result.next()) {
//                String id = result.getString("id");
//                String routedatafrom = result.getString("routedatafrom");
//                String routedatatoo = result.getString("routedatatoo");
//                String etddatetime = result.getString("etddatetime");
//                String etadatetime = result.getString("etadatetime");
//                int flightduration = result.getInt("flightduration");
//                String airplaneid = result.getString("airplaneid");
//                flightData.add(new FlightData(id, new RouteData(new AirportData(routedatafrom, "oui", "non", "Baguette"),
//                        new AirportData(routedatatoo, "yes", "no", "Pudding")),
//                        LocalDateTime.parse(etddatetime), LocalDateTime.parse(etadatetime),
//                        Duration.ofSeconds(flightduration),
//                        new AirplaneData(airplaneid, "name", 10, 20)));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return flightData;
//    }
}

