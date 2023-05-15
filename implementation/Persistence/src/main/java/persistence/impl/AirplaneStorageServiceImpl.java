package persistence.impl;

import datarecords.AirplaneData;
import persistence.api.AirplaneStorageService;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AirplaneStorageServiceImpl implements AirplaneStorageService {
    private final DataSource dataSource;

    public AirplaneStorageServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public Set<AirplaneData> getAll() {
        String query = "SELECT * FROM airplanes";
        Set<AirplaneData> airportData = new HashSet<>();
        try (Connection con = dataSource.getConnection(); PreparedStatement stmt = con.prepareStatement(query)) {
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                String id = result.getString("id");
                String manufacturer = result.getString("manufacturer");
                int length = result.getInt("length");
                int width = result.getInt("width");
                String model = result.getString("model");
                int seats = result.getInt("seats");
                airportData.add(new AirplaneData(id, manufacturer, length, width, model, seats));
            }
        } catch (SQLException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
        }
        return airportData;
    }

    @Override
    public AirplaneData add(AirplaneData airplaneData) {

        String query = "INSERT INTO airplanes (id, manufacturer, length, width, model, seats) values (?, ?, ?, ?, ?, ?) returning *";


        try (Connection con = dataSource.getConnection(); PreparedStatement pstm = con.prepareStatement(query)) {

            String id = airplaneData.id();
            String manufacturer = airplaneData.manufacturer();
            int length = airplaneData.length();
            int width = airplaneData.width();
            String model = airplaneData.model();
            int seats = airplaneData.seats();

            pstm.setString(1, id);
            pstm.setString(2, manufacturer);
            pstm.setInt(3, length);
            pstm.setInt(4, width);
            pstm.setString(5, model);
            pstm.setInt(6, seats);



            ResultSet result = pstm.executeQuery();

            System.out.println("JUST INSERTED: ");
            while (result.next()) {
                id = result.getString("id");
                manufacturer = result.getString("manufacturer");
                length = result.getInt("length");
                width = result.getInt("width");
                model = result.getString("model");
                seats = result.getInt("seats");

                System.out.println("Customer with id: " + id + ", " + manufacturer + ", " + length + ", " + width + ", " + model + ", " + seats);
            }

        } catch (SQLException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return airplaneData;
    }
}
