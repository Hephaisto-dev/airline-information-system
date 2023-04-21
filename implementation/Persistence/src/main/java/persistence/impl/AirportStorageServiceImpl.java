package persistence.impl;

import datarecords.AirportData;
import persistence.api.AirportStorageService;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AirportStorageServiceImpl implements AirportStorageService {
    private final DataSource dataSource;

    public AirportStorageServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public AirportData add(AirportData airportData) {
//        throw new UnsupportedOperationException("Not supported yet.");
        String query = "INSERT INTO airports(id, name, city, country) values (?, ?, ?, ?) returning *";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(query)){

            String id = airportData.id();
            String name = airportData.name();
            String city = airportData.city();
            String country = airportData.country();

            stmt.setString(1,id);
            stmt.setString(2,name);
            stmt.setString(3,city);
            stmt.setString(4,country);

            ResultSet results = stmt.executeQuery();

            System.out.println("INSERTED: ");

            while(results.next()){

                id = results.getString("id");
                name = results.getString("name");
                city = results.getString("city");
                country = results.getString("country");

                System.out.println("Airport with id: " + id + ", name: " + name + ", city: " + city + ", country: " + country);

            }
        }catch(SQLException e){
            Logger.getLogger(AirportStorageServiceImpl.class.getName()).log(Level.SEVERE,null,e);
        }
        return airportData;
    }
    @Override
    public Set<AirportData> getAll(){

        String query = "SELECT * FROM airports";
        Set<AirportData> airportData = new HashSet<>();
        try(Connection con = dataSource.getConnection(); PreparedStatement stmt = con.prepareStatement(query)){
            ResultSet result = stmt.executeQuery();
            while(result.next()){
                String id = result.getString("id");
                String name = result.getString("name");
                String city = result.getString("city");
                String country = result.getString("country");

                airportData.add(new AirportData(id,name,city,country));

            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return airportData;
    }
    public AirportData createAirport(String airportId){
        AirportData airportData = null;
        String query = "SELECT * FROM airports where id = ?";
                //airportId = airport.Id";

        try(Connection con = dataSource.getConnection(); PreparedStatement stmt = con.prepareStatement(query)){
            stmt.setString(1,airportId);

            ResultSet result = stmt.executeQuery();
            while(result.next()){
                String name = result.getString("name");
                String city = result.getString("city");
                String country = result.getString("country");
                airportData = new AirportData(airportId,name,city,country);
            }
        }catch(SQLException e){
            throw new RuntimeException();

        }
        return airportData;
    }
}
