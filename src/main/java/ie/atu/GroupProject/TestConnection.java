package ie.atu.GroupProject;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {

        // Now this is all we actually need for this class, way way way better
        // we can implement using dbUtils on our all other classes that involve loading db.properties and getting a connection to our database!
        try(Connection con = DbUtils.getConnection()){
            System.out.println("Connected!");
        } catch(SQLException e){
            e.printStackTrace();
            System.out.println("Could not Connect");
        }
    }
}
