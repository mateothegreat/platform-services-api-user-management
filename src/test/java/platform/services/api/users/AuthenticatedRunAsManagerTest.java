package platform.services.api.users;

import lombok.extern.log4j.Log4j2;
import org.apache.catalina.startup.UserConfig;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import org.junit.*;
import org.junit.runner.*;

import platform.services.api.authentication.SecurityConfiguration;
import platform.services.api.commons.BaseTests;

@Log4j2
@Profile("test")
@RunWith(SpringRunner.class)
@ContextConfiguration(
        classes = { SecurityConfiguration.class, UserConfig.class, UserService.class },
        loader = AnnotationConfigContextLoader.class
)
public class AuthenticatedRunAsManagerTest extends BaseTests {

    @Before
    public void setUp() throws Exception {

        log.trace("setUp()");
        //        Authenticated.runAs("gibson", "password123",
        // AuthenticationAuthorities.ADMIN,AuthenticationAuthorities.USER);

    }

    @Test
    public void runAs() throws Exception {

        log.trace("runAs()");
    }

    @Test
    public void getPrincipal() throws Exception {

        //    final User user = Authenticated.getPrincipal();

        //    log.trace("getPrincipal(): {}", user.toString());
    }
}
