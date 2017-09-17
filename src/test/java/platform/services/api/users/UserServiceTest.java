package platform.services.api.users;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import platform.services.api.UsersConfig;
import platform.services.api.commons.datasources.DataSourceConfig;
import platform.services.api.commons.testing.BaseRepositoryTest;
import platform.services.api.commons.testing.ComposedJUnit5BootTest;

@Log4j2
@ComposedJUnit5BootTest
@SpringBootConfiguration
@ContextConfiguration(classes = { UsersConfig.class, DataSourceConfig.class }, loader = AnnotationConfigContextLoader.class)
public class UserServiceTest extends BaseRepositoryTest<User> {

    @Autowired
    public UserService userService;

    @BeforeEach
    public void beforeEach() {

        super.beforeEach();

        entityClass = User.class;
        genericService = userService;

    }

    @Test
    public void getUserByUsername() throws Exception {

        final User user   = this.userService.saveEntity(this.r.get(User.class));
        final User result = this.userService.getUserByUsername(user.getUsername());

        baseEntity_isValidAndCompare(user, result);

    }

    @Test
    public void getUserByEmail() throws Exception {

        final User user   = this.userService.saveEntity(this.r.get(User.class));
        final User result = this.userService.getUserByEmail(user.getEmail());

        baseEntity_isValidAndCompare(user, result);

    }

}
