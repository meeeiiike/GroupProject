package ie.atu.GroupProject;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.sql.Connection;
import java.sql.SQLException;

public class DbUtils {
    private static final HikariDataSource DATA_SOURCE;
    //private static final LOGGER LOGGER = LoggerFactory.getLogger(DbUtils.class);
    private static final String URL = "jdbc:mysql://localhost:3306/sms";
    private static final String USERNAME= "root";
    private static final String PASSWORD = "password";


    static {
        try{
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(URL);
            config.setUsername(USERNAME);
            config.setPassword(PASSWORD);
            config.setMaximumPoolSize(4);
            DATA_SOURCE = new HikariDataSource(config);
        }catch(Exception e){
            //LOGGER.error("Could not initialize Hikari Datasource" + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DATA_SOURCE.getConnection();
    }

    public static void close(){
        if(DATA_SOURCE != null){
            //LOGGER.info("Closing Hikari");
            DATA_SOURCE.close();
        }
    }
}

