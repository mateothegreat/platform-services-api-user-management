package platform.services.api.users;

import org.junit.platform.runner.*;
import org.junit.platform.suite.api.*;
import org.junit.runner.*;

import platform.services.api.commons.testing.BaseControllerTestCase;
import platform.services.api.users.profiles.UserProfileServiceTest;
import platform.services.api.users.roles.UserRoleServiceTest;
import platform.services.api.users.roles.UserRoleTest;
import platform.services.api.users.settings.UserSettingTest;
import platform.services.api.users.profiles.UserProfileTest;

//@RunWith(SpringRunner.class)
@RunWith(JUnitPlatform.class)
@BaseControllerTestCase
//@ExtendWith(SpringExtension.class)
@SelectClasses({
                       UserTest.class,
                       UserRoleTest.class,
                       UserProfileTest.class,
                       UserSettingTest.class,

                       UserProfileServiceTest.class,
                       UserControllerTest.class,
                       UserRoleServiceTest.class,
                       UserServiceTest.class
               })
//@SelectPackages("platform.services.api.users")
public class UserSuite {

}
