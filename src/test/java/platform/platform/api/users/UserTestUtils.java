package platform.platform.api.users;

import platform.platform.api.users.services.TestingConfig;
import platform.services.api.users.jpa.User;

public class UserTestUtils {

    public static User buildUser() {

        final User user = new User();

        user.setEmail(TestingConfig.USER_VALID_EMAIL);
        user.setUsername(TestingConfig.USER_VALID_USERNAME);
        user.setPassword(TestingConfig.USER_VALID_PASSWORD);
        user.setParent_id(0);
        user.setStatus(1);

        return user;

    }

}
