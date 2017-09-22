package platform.services.api.users;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import platform.services.api.UsersConfig;
import platform.services.api.commons.jpa.datasources.DataSourceConfig;
import platform.services.api.commons.testing.TestingSpringService;
import platform.services.api.users.profiles.UserProfile;

@Log4j2
@TestingSpringService
@SpringBootConfiguration
@ContextConfiguration(classes = {

    UsersConfig.class,
    DataSourceConfig.class

}, loader = AnnotationConfigContextLoader.class)
public class UserProfileControllerTest extends UserBaseTest<UserProfile>  {

    private static final String PATH_BASE = "/profiles";

    private static UserBaseTest testFixtures;

    public UserProfileControllerTest() {

        super(UserProfile.class, PATH_BASE);

    }
//
//    @BeforeEach
//    public void beforeEach() {
//
//    }
//
//    @AfterEach
//    public void afterEach() {
//
//    }

}
