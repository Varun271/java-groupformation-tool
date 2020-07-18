package CSCI5308.GroupFormationTool.AccessControlTest;

import CSCI5308.GroupFormationTool.AccessControl.IUserPersistence;
import CSCI5308.GroupFormationTool.AccessControl.User;

public class UserDBMock implements IUserPersistence {
    public void loadUserByID(long id, User user) {
        user.setBannerID("B00000000");
        user.setEmail("rhawkey@dal.ca");
        user.setFirstName("Rob");
        user.setLastName("Hawkey");
        user.setID(id);
    }

    public void loadUserByBannerID(String bannerID, User user) {
        user.setBannerID(bannerID);
        user.setEmail("rhawkey@dal.ca");
        user.setFirstName("Rob");
        user.setLastName("Hawkey");
        user.setID(1);
    }

    public boolean createUser(User user) {
        // Not implemented yet, hopefully have time to improve in M2
        return true;
    }

    public boolean updateUser(User user) {
        // Not implemented yet, hopefully have time to improve in M2
        return true;
    }
}
