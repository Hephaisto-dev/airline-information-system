package persistence.impl;

import datarecords.FlightData;
import persistence.api.FlightStorageService;

import javax.sql.DataSource;
import java.sql.*;
import java.time.Duration;
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
        String query = "INSERT INTO flights (id, airport_from_id, airport_to_id, etd, eta, " +
                "flight_duration, airplane_id) values (?, ?, ?, ?, ?, ?, ?) returning *";


        try (Connection con = dataSource.getConnection(); PreparedStatement pstm = con.prepareStatement(query)) {

            String id = flightData.id();
            String departureAirportId = flightData.departureAirportId();
            String arrivalAirportId = flightData.arrivalAirportId();
            Timestamp etd = Timestamp.valueOf(flightData.etdDateTime());
            Timestamp eta = Timestamp.valueOf(flightData.etaDateTime());
            long flightduration = flightData.flightDuration().getSeconds();
            String airplaneid = flightData.airplaneId();

            pstm.setString(1, id);
            pstm.setString(2, departureAirportId);
            pstm.setString(3, arrivalAirportId);
            pstm.setTimestamp(4, etd);
            pstm.setTimestamp(5, eta);
            pstm.setLong(6, flightduration);
            pstm.setString(7, airplaneid);


            ResultSet result = pstm.executeQuery();

            System.out.println("JUST INSERTED: ");
            while (result.next()) {
                id = result.getString("id");
                departureAirportId = result.getString("airport_from_id");
                arrivalAirportId = result.getString("airport_to_id");
                etd = result.getTimestamp("etd");
                eta = result.getTimestamp("eta");
                flightduration = result.getInt("flight_duration");
                airplaneid = result.getString("airplane_id");

                System.out.println("Customer with id: " + id + ", " + departureAirportId + ", " + arrivalAirportId + ", " + etd + ", " + eta + ", " + flightduration + ", " + airplaneid);
            }

        } catch (SQLException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return flightData;
    }

    @Override
    public Set<FlightData> getAll() {
        String query = "SELECT * FROM flights";

        Set<FlightData> flightData = new HashSet<>();
        try (Connection con = dataSource.getConnection(); PreparedStatement pstm = con.prepareStatement(query)) {
            ResultSet result = pstm.executeQuery();
            while (result.next()) {
                String id = result.getString("id");
                String departureAirportId = result.getString("airport_from_id");
                String arrivalAirportId = result.getString("airport_to_id");
                LocalDateTime etd = result.getTimestamp("etd").toLocalDateTime();
                LocalDateTime eta = result.getTimestamp("eta").toLocalDateTime();
                Duration flightduration = Duration.ofSeconds(result.getLong("flight_duration"));
                String airplaneid = result.getString("airplane_id");

                if (departureAirportId == null) {
                    continue;
                }

                FlightData flight = new FlightData(id, etd, eta, flightduration, airplaneid, departureAirportId, arrivalAirportId);
                flightData.add(flight);
            }
        } catch (SQLException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
        }
        return flightData;
    }


}

