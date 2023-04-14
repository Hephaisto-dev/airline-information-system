package persistence.impl.database;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author hvd
 */
public class DBProvider {

    static final Map<String, DataSource> cache = new HashMap<>();

    public static DataSource getDataSource(final String sourceName) {

        return cache.computeIfAbsent(sourceName,
                (s) -> {
                    Properties props = properties();

                    PGSimpleDataSource source = new PGSimpleDataSource();

                    String prefix = sourceName + ".";

                    String[] serverNames = {props.getProperty(prefix + "dbhost")};

                    source.setServerNames(serverNames);
                    source.setPortNumbers(new int[]{Integer.parseInt(props.getProperty(prefix + "port"))});
                    source.setUser(props.getProperty(prefix + "username"));
                    source.setDatabaseName(props.getProperty(prefix + "dbname"));
                    source.setPassword(props.getProperty(prefix + "password"));
                    source.setCurrentSchema(props.getProperty(prefix + "schema"));

                    return source;
                }
        );
    }

    static Properties properties() {
        Properties properties = new Properties();
        try (InputStream fis = DBProvider.class.getResourceAsStream("application.properties")) {
            properties.load(fis);
        } catch (IOException exception) {
            Logger.getLogger(DBProvider.class.getName()).log(
                    Level.INFO,
                    "attempt to read file from well known location failed'",
                    exception);
        }
        return properties;
    }

}