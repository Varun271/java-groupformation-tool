package CSCI5308.GroupFormationTool.CourseTest;

import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.Courses.Course;
import CSCI5308.GroupFormationTool.Courses.ICourseUserRelationshipPersistence;
import CSCI5308.GroupFormationTool.Courses.Role;

import java.util.ArrayList;
import java.util.List;

public class CourseUserRelationshipDBMock implements ICourseUserRelationshipPersistence {
    public List<User> findAllUsersWithoutCourseRole(Role role, long courseID) {
        List<User> user_list = new ArrayList<>();
        User u = new User();
        u.setId(1);
        User u2 = new User();
        u2.setId(2);
        user_list.add(u);
        user_list.add(u2);
        return user_list;
    }

    ;

    public List<User> findAllUsersWithCourseRole(Role role, long courseID) {
        List<User> user_list = new ArrayList<>();
        User u = new User();
        u.setId(1);
        User u2 = new User();
        u2.setId(2);
        user_list.add(u);
        user_list.add(u2);
        return user_list;
    }

    ;

    public boolean enrollUser(Course course, User user, Role role) {
        return true;

    }

    ;

    public List<Role> loadUserRolesForCourse(Course course, User user) {
        List<Role> user_role = new ArrayList<>();
        return user_role;
    }

    ;
}
