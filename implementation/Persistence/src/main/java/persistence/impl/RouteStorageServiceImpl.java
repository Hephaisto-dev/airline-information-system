package persistence.impl;

import datarecords.RouteData;
import persistence.api.RouteStorageService;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RouteStorageServiceImpl implements RouteStorageService {

    private final DataSource dataSource;

    public RouteStorageServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public RouteData add(RouteData routeData) {

        String query = "INSERT INTO routes (id,price,name) values (?, ?, ?)";
        String query2 = "INSERT INTO flights_for_route (route_id,flight_id,transit_seconds) VALUES (?, ?, ?)";

        try (Connection con = dataSource.getConnection(); PreparedStatement pstm = con.prepareStatement(query);PreparedStatement preparedStatement = con.prepareStatement(query2)) {
            //query 1 for the route table
            String id = routeData.id();
            int price = routeData.price();
            String name = routeData.name();

            pstm.setString(1, id);
            pstm.setInt(2,price);
            pstm.setString(3,name);

            pstm.execute();


            //query2 for the flights_for_route table
            for (Map.Entry<String, Long> entry : routeData.flightIdsAndTransits().entrySet()) {
                preparedStatement.setString(1, id);
                preparedStatement.setString(2, entry.getKey());
                preparedStatement.setLong(3,entry.getValue());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();

        } catch (SQLException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return routeData;
    }

    @Override
    public Set<RouteData> getAll(){
        String query = "SELECT * FROM routes";
        String query2 = "SELECT * FROM flights_for_route where route_id = ?";

        Set<RouteData> routeData = new HashSet<>();
        try(Connection con = dataSource.getConnection();PreparedStatement pstm = con.prepareStatement(query);PreparedStatement pstm2 = con.prepareStatement(query2)){
            ResultSet resultSet = pstm.executeQuery();
            while(resultSet.next()){
                String id = resultSet.getString("id");
                int price = resultSet.getInt("price");
                String name = resultSet.getString("name");

                pstm2.setString(1,id);
                ResultSet resultSet1 = pstm2.executeQuery();
                Map<String,Long> flightIdAndTransit = new HashMap<>();
                while(resultSet1.next()){
                    String flights = resultSet1.getString("flight_id");
                    long timeInSeconds = resultSet1.getLong("transit_seconds");
                    flightIdAndTransit.put(flights,timeInSeconds);
                }
                RouteData route = new RouteData(name,id,flightIdAndTransit,price);
                routeData.add(route);

            }
        }catch (SQLException e){
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
        }
        return routeData;
    }

    @Override
    public boolean remove(String id) {
        String deleteFlightsQuery = "DELETE FROM flights_for_route WHERE route_id = ?";
        String deleteRouteQuery = "DELETE FROM routes WHERE id = ?";

        try (Connection con = dataSource.getConnection();
             PreparedStatement deleteFlightsStmt = con.prepareStatement(deleteFlightsQuery);
             PreparedStatement deleteRouteStmt = con.prepareStatement(deleteRouteQuery)) {

            // Delete entries from flights_for_route table
            deleteFlightsStmt.setString(1, id);
            int flightsDeleted = deleteFlightsStmt.executeUpdate();

            // Delete entry from routes table
            deleteRouteStmt.setString(1, id);
            int routeDeleted = deleteRouteStmt.executeUpdate();

            if (flightsDeleted > 0 && routeDeleted > 0) {
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
}

