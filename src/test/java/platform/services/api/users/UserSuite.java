package platform.services.api.users;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

//@RunWith(SpringRunner.class)
@RunWith(JUnitPlatform.class)

//@ExtendWith(SpringExtension.class)
@SelectClasses({ UserTest.class, UserServiceTest.class })
//@SelectPackages("platform.services.api.users")
public class UserSuite {

}
