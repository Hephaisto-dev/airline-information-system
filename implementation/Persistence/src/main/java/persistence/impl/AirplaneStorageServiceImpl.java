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

public class AirplaneStorageServiceImpl implements AirplaneStorageService {
    private final DataSource dataSource;

    public AirplaneStorageServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public AirplaneData add(AirplaneData customerData) {
        throw new UnsupportedOperationException("Not supported yet.");
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
            throw new RuntimeException(e);
        }
        return airportData;
    }
}
