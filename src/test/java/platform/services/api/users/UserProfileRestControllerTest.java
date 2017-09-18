package platform.services.api.users;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import org.junit.jupiter.api.BeforeEach;

import platform.services.api.UsersConfig;
import platform.services.api.commons.testing.BaseRestRepositoryTest;
import platform.services.api.commons.testing.ComposedJUnit5BootTest;

@Log4j2
@ComposedJUnit5BootTest
@SpringBootConfiguration
@ContextConfiguration(classes = { UsersConfig.class, DataSourceConfig.class }, loader = AnnotationConfigContextLoader.class)
public class UserProfileRestControllerTest extends BaseRestRepositoryTest {

    @Autowired public UserProfileRestController controller;

    @BeforeEach
    public void beforeEach() {

        super.beforeEach();

    }

}
