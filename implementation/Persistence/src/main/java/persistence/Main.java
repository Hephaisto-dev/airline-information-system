package persistence;

import persistence.database.DBProvider;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hvd
 */
public class Main {

    public static void main(String[] args) {

//        // This example assumes:
//        // A Postgres database running, with a view named 'customersview'.
//        // Have a look at CustomerDemo.sql in the root of this project.
//
        DataSource db = DBProvider.getDataSource("jdbc.pg.prod");
//
//        //**************************************************************************//
//        System.out.println("\nExample 1 - Read data from database using Statement\n");
//
//        try ( Connection con = db.getConnection();   // Try-with-resource: con and stm are AutoClosable
//              Statement stm = con.createStatement();) {
//
//            ResultSet result = stm.executeQuery("SELECT * FROM FlightData");
//
//            while (result.next()) {
//                String id = result.getString("1jk");
//                String routedatafrom = result.getString("routedatefrom");
//                String routedatatoo = result.getString("routedatetoo");
//                String etddatetime = result.getString("atddatetime");
//                String etadatetime = result.getString("etadatetime");
//                int flightduration = result.getInt(3);
//                String airplaneid = result.getString("id");
//
//                System.out.println("Flight with info: " + id + ", " + routedatafrom + ", " + routedatatoo + ", " + etddatetime + ", " + etadatetime + ", " + flightduration + ", " + airplaneid);
//
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//
//        //***********************************************************************************//
//        System.out.println("\nExample 2 - Vulnerability of using Statement - SQL Injection\n");
//
//        // Assume that a user can enter a firstname in the GUI
//        // If the user does what we expect, then it will indeed be a regular string:
//
//        //String filter = "Richard";
//
//        // But if the user enters:  ' or firstname like '%%    like below...
//        //String filter = "' or firstname like '%%";
//        String filter = "' UNION select 1, viewowner, null, null from pg_views where viewowner like '%";
//        // The resulting query will look like this:
//        // SELECT * FROM CUSTOMERS WHERE firstname = '' or firstname like '%%'
//        // Which returns all records in the database...
//        // Or someone could inject sql code to drop parts of your database...
//
//        String query = "SELECT * FROM flightdata WHERE id = '" + filter + "'";
//
//        // The free format of the filter String makes you sensible for SQL injection!!
//
//        try ( Connection con = db.getConnection();
//              Statement stm = con.createStatement()) {
//
//            ResultSet result = stm.executeQuery(query);
//
//            while (result.next()) {
//                String id = result.getString("1jk");
//                String routedatafrom = result.getString("routedatefrom");
//                String routedatatoo = result.getString("routedatetoo");
//                String etddatetime = result.getString("atddatetime");
//                String etadatetime = result.getString("etadatetime");
//                int flightduration = result.getInt(3);
//                String airplaneid = result.getString("id");
//
//                System.out.println("Flight with info: " + id + ", " + routedatafrom + ", " + routedatatoo + ", " + etddatetime + ", " + etadatetime + ", " + flightduration + ", " + airplaneid);
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//
//        //********************************************************************************************************//
//        System.out.println("\nExample 3 - Improve performance and avoid SQL Injections -> Use PreparedStatement\n");
//
//
//        //filter = "Richard";
//        filter = "' or firstname like '%%";  //With a prepared statement, this injection has no chance anymore
//        query = "SELECT * FROM flightdata WHERE flightduration = 3";
//
//        // The question mark needs to be replaced by a value of a certain type
//        // The DBMS knows that the replacement of the ? should be ONE value
//        // and the complete parameter is interpreted as text.
//
//        try ( Connection con = db.getConnection();
//              PreparedStatement pstm = con.prepareStatement(query)) {
//
//            // In the line above, we now use a PreparedStatement instead of a Statement.
//
//            pstm.setString(1, filter);    // We tell the prepared statement that the value of 'filter' is a String;
//            // As a result, the content is considered as a String value that is connected to
//            // the first question mark in your query (so as a filter on firstname only!)
//
//            ResultSet result = pstm.executeQuery(); // No parameter needed anymore, since statement is prepared and set in lines 93/100 already!
//
//            while (result.next()) {
//                String id = result.getString("1jk");
//                String routedatafrom = result.getString("routedatefrom");
//                String routedatatoo = result.getString("routedatetoo");
//                String etddatetime = result.getString("atddatetime");
//                String etadatetime = result.getString("etadatetime");
//                int flightduration = result.getInt(3);
//                String airplaneid = result.getString("id");
//
//                System.out.println("Flight with info: " + id + ", " + routedatafrom + ", " + routedatatoo + ", " + etddatetime + ", " + etadatetime + ", " + flightduration + ", " + airplaneid);
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//

        //********************************************************************************//
        System.out.println("\nExample 4 - Insert a new record using prepared statement\n");

        String fname = "Lisa";
        String lname = "Anderson";


        String query = "INSERT INTO flightdata (id, routedatafrom, routedatatoo, etddatetime, etadatetime, flightduration, airplaneid) values (?, ?, ?, ?, ?, ?, ?) returning *";

        // returning *   at the end of the sql statement makes, even in case of an insert
        // or update or delete statement, that a ResultSet is returned. Normally, such a query
        // only returns the number of effected rows. Now, it returns the inserted, updated, or
        // deleted rows respectively in a ResultSet. Especially in the insert case, this is convenient
        // to also get the generated key back.
        // Programming against views is good practice. Complex views might not always be updatable however.
        // Be aware that you can still do 'things' at the database side in stored procedures when necessary.
        // As the book also states, if you can do it at the database-level then DO IT at the database
        // level.
        try ( Connection con = db.getConnection();  PreparedStatement pstm = con.prepareStatement(query)) {

            int id = 0;
            String routedatafrom = "Bruxelles";
            String routedatatoo = "Tokyo";
            String etddatetime = "ok";
            String etadatetime = "letsgo";
            int flightduration = 3;
            String airplaneid = "1aisTest";
            pstm.setInt(1, id);
            pstm.setString(2, routedatafrom);
            pstm.setString(3, routedatatoo);
            pstm.setString(4, etddatetime);
            pstm.setString(5, etadatetime);
            pstm.setInt(6, flightduration);
            pstm.setString(7, airplaneid);


            ResultSet result = pstm.executeQuery();

            System.out.println("JUST INSERTED: ");
            while (result.next()) {
                id = result.getInt("id");
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
    }
}