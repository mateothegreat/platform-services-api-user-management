package platform.services.api.users;

import lombok.extern.log4j.Log4j2;
import org.apache.catalina.startup.UserConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import platform.services.api.commons.testing.BaseTests;

@Log4j2
@ContextConfiguration(
    classes = { UserConfig.class },
    loader = AnnotationConfigContextLoader.class
)
public class AuthenticatedRunAsManagerTest extends BaseTests {

    @BeforeEach
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
