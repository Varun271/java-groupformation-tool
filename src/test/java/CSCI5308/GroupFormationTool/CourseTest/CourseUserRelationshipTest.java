package CSCI5308.GroupFormationTool.CourseTest;

import CSCI5308.GroupFormationTool.Courses.Role;
import org.junit.jupiter.api.Test;

public class CourseUserRelationshipTest {

    @Test
    public void findAllUsersWithoutCourseRoleTest() {
        CourseUserRelationshipDBMock courseUserRelationshipDBMock = new CourseUserRelationshipDBMock();
        int courseID = 1;
        courseUserRelationshipDBMock.findAllUsersWithCourseRole(Role.STUDENT, courseID);

    }
}
