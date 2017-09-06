package platform.services.api.common.authentication;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import org.junit.*;
import org.junit.runner.*;

import platform.platform.api.common.BaseTests;
import platform.services.api.users.UserConfig;
import platform.services.api.common.security.SecurityConfiguration;
import platform.services.api.users.jpa.User;
import platform.services.api.users.services.UserService;

@Log4j2
@Profile("test")
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { SecurityConfiguration.class, UserConfig.class, UserService.class }, loader = AnnotationConfigContextLoader.class)

public class AuthenticatedTest extends BaseTests {

    @Before
    public void setUp() throws Exception {

        log.trace("setUp()");
        Authenticated.runAs("gibson", "password123", AuthenticationAuthorities.ADMIN,AuthenticationAuthorities.USER);

    }

    @Test
    public void runAs() throws Exception {

        log.trace("runAs()");

    }

    @Test
    public void getPrincipal() throws Exception {

        User user = Authenticated.getPrincipal();

        log.trace("getPrincipal(): {}", user.toString());

    }

}
