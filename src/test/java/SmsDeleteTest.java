import ie.atu.GroupProject.DbUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmsDeleteTest {

    @Test
    void testDeleteDepartmentSuccess(){
        int departmentID = 1;
        try(Connection con = DbUtils.getConnection()){
            PreparedStatement stmt = con.prepareStatement("DELETE FROM department WHERE department_id =" + departmentID);

            int rowsAffected = stmt.executeUpdate();

            assertEquals(1, rowsAffected);
        } catch (SQLException e){
            System.out.println("Database Error.");
            e.printStackTrace();
        }
    }

    @Test
    void testDeleteDepartmentFailure(){
        int departmentID = 0;
        try (Connection con = DbUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("DELETE FROM department WHERE department_id = " + departmentID);

            int rowsAffected = stmt.executeUpdate();

            assertEquals(0, rowsAffected);
        } catch (SQLException e) {
            System.out.println("Database Error.");
            e.printStackTrace();
        }
    }

    @Test
    void testDeleteStudentSuccess(){
        int studentID = 1;
        try(Connection con = DbUtils.getConnection()){
            PreparedStatement stmt = con.prepareStatement("DELETE FROM student WHERE student_id =" + studentID);

            int rowsAffected = stmt.executeUpdate();

            assertEquals(1, rowsAffected);
        } catch (SQLException e){
            System.out.println("Database Error.");
            e.printStackTrace();
        }
    }

    @Test
    void testDeleteStudentFailure(){
        int studentID = 0;
        try (Connection con = DbUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("DELETE FROM student WHERE student_id = " + studentID);

            int rowsAffected = stmt.executeUpdate();

            assertEquals(0, rowsAffected);
        } catch (SQLException e) {
            System.out.println("Database Error.");
            e.printStackTrace();
        }
    }
}
