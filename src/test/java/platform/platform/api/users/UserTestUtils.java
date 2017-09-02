package platform.platform.api.users;

import com.streamingplatform.api.users.entities.*;
import platform.services.api.users.entities.*;

public class UserTestUtils {

    public static final String USER_VALID_USERNAME   = "user1";
    public static final String USER_VALID_PASSWORD   = "password";
    public static final String USER_VALID_EMAIL      = "user1@user1.com";
    public static final String USER_INVALID_USERNAME = "invalid";
    public static final String USER_INVALID_PASSWORD = "invalid";
    public static final String USER_INVALID_EMAIL    = "invalid@invalid.com";

    public static User buildUser() {

        User user = new User();

        user.setEmail(USER_VALID_EMAIL);
        user.setUsername(USER_VALID_USERNAME);
        user.setPassword(USER_VALID_PASSWORD);
        user.setParent_id(0);
        user.setStatus(1);

        return user;

    }

}
