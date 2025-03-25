import ie.atu.GroupProject.StudentManagementCreate;
import ie.atu.GroupProject.StudentManagementUpdate;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class create {
    @Test
    void testInsertDepartmentSuccess() throws SQLException {
        String name = "TestAtuSuccess";
        StudentManagementCreate.setDepartmentInput(name);
    }
}
