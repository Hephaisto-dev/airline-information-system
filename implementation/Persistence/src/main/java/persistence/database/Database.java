package persistence.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    public static void main(String[] args) {

        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres", "postgres", "mypassword");

            if (connection != null) {
                System.out.println("Connection is OK");
            } else {
                System.out.println("Connection failed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
