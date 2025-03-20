package ie.atu.GroupProject;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtils {

    private static final HikariDataSource DATA_SOURCE;
    private static final Logger LOGGER = LoggerFactory.getLogger(DbUtils.class);
    static {

        Properties dbProps = new Properties();
        // [Michael McDermott] I used AI to assist with loading the properties file here, basically told me
        // it should be in the static method as it should only load once, and that using return is bad practice,
        // instead we need to throw an exception to stop the db from loading
        // if anyone else would like to try implement their own version ive no problem if you want to change anything
        try(InputStream input = DbUtils.class.getResourceAsStream("/db.properties")){
            if(input== null){
                throw new RuntimeException("Unable to find db.properties");
            }
            dbProps.load(input);
        } catch(IOException e){
            e.printStackTrace();
            throw new RuntimeException("Unable to find db.properties");
        }

        try{
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(dbProps.getProperty("db.url"));
            config.setUsername(dbProps.getProperty("db.username"));
            config.setPassword(dbProps.getProperty("db.password"));
            config.setMaximumPoolSize(4);
            DATA_SOURCE = new HikariDataSource(config);
        }catch(Exception e){
            LOGGER.error("Could not initialize Hikari Datasource", e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DATA_SOURCE.getConnection();
    }

    public static void close(){
        if(DATA_SOURCE != null){
            LOGGER.info("Closing Hikari");
            DATA_SOURCE.close();
        }
    }
}