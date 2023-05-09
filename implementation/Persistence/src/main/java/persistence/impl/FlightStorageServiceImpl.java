package persistence.impl;

import datarecords.AirplaneData;
import datarecords.AirportData;
import datarecords.FlightData;
import persistence.api.FlightStorageService;
import persistence.impl.database.DBProvider;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FlightStorageServiceImpl implements FlightStorageService {
    private final DataSource dataSource;

    public FlightStorageServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public FlightData add(FlightData flightData) {

        String query = "INSERT INTO flights (id, airport_from_id, airport_to_id, etd_date_time, eta_date_time, " +
                "flight_duration, airplane_id) values (?, ?, ?, ?, ?, ?, ?) returning *";


        try (Connection con = dataSource.getConnection(); PreparedStatement pstm = con.prepareStatement(query)) {

            String id = flightData.id();
            String routedatafrom = flightData.departure().id();
            String routedatatoo = flightData.arrival().id();
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
                routedatafrom = result.getString("airport_from_id");
                routedatatoo = result.getString("airport_to_id");
                etddatetime = result.getString("etd_date_time");
                etadatetime = result.getString("eta_date_time");
                flightduration = result.getInt("flight_duration");
                airplaneid = result.getString("airplane_id");

                System.out.println("Customer with id: " + id + ", " + routedatafrom + ", " + routedatatoo + ", " + etddatetime + ", " + etadatetime + ", " + flightduration + ", " + airplaneid);
            }

        } catch (SQLException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return flightData;
    }

//    public Set<FlightData> getAll(String id, LocalDateTime etd, LocalDateTime eta, AirplaneData airplane, AirportData departureAirport, AirportData arrivalAirport) {
//        DataSource db = DBProvider.getDataSource("jdbc.pg.prod");
//
//        String query = "SELECT * FROM flights";
//
//        Set<FlightData> flightData = new HashSet<>();
//        try (Connection con = db.getConnection(); PreparedStatement pstm = con.prepareStatement(query)) {
//            ResultSet result = pstm.executeQuery();
//            while (result.next()) {
//                String flightId = result.getString("id");
//                LocalDateTime flightEtd = result.getObject("etd_date_time", LocalDateTime.class);
//                LocalDateTime flightEta = result.getObject("eta_date_time", LocalDateTime.class);
//                Duration flightDuration = (Duration) result.getObject("duration");
//                String flightAirplane = result.getString("airplane");
//                String flightDepartureAirport = result.getString("departureAirport");
//                String flightArrivalAirport = result.getString("arrivalAirport");
//
//                if ((id == null || id.equals(flightId)) &&
//                        (etd == null || etd.equals(flightEtd)) &&
//                        (eta == null || eta.equals(flightEta)) &&
//                        (airplane == null || airplane.id().equals(flightAirplane)) &&
//                        (departureAirport == null || departureAirport.name().equals(flightDepartureAirport)) &&
//                        (arrivalAirport == null || arrivalAirport.name().equals(flightArrivalAirport))) {
//                    flightData.add(new FlightData(flightId, flightEtd, flightEta, flightDuration, airplane, departureAirport, arrivalAirport));
//                }
//            }
//        } catch (SQLException e) {
//            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
//        }
//        return flightData;
//    }



    @Override
    public Set<FlightData> getAll() {
        DataSource db = DBProvider.getDataSource("jdbc.pg.prod");

        String query = "SELECT * FROM flights";


        Set<FlightData> flightData = new HashSet<>();
        try (Connection con = db.getConnection(); PreparedStatement pstm = con.prepareStatement(query)) {
            ResultSet result = pstm.executeQuery();
            while (result.next()) {
                String flightId = result.getString("id");
                String flightEtd = result.getString("etd_date_time");
                String flightEta = result.getString("eta_date_time");
                int flightDuration = result.getInt("flight_duration");
                String flightAirplane = result.getString("airplane_id");
                String flightDepartureAirport = result.getString("airport_from_id");
                String flightArrivalAirport = result.getString("airport_to_id");
                flightData.add(new FlightData(flightId, LocalDateTime.parse(flightEta), LocalDateTime.parse(flightEtd), null, new AirplaneData(flightAirplane, null, 0, 0, null, 0), new AirportData(null, flightDepartureAirport, null), new AirportData(null, flightArrivalAirport, null)));
            }
        } catch (SQLException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
        }
        return flightData;
    }
}

