package platform.services.api.users;

import lombok.extern.log4j.Log4j2;
import net.bytebuddy.utility.RandomString;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.junit.platform.runner.*;
import org.junit.runner.*;

import platform.services.api.UsersConfig;
import platform.services.api.authentication.SecurityConfiguration;
import platform.services.api.commons.testing.BaseTests;
import platform.services.api.commons.testing.EntityRandomizer;
import platform.services.api.commons.utilities.Tracing;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
@Profile("testing")
@Transactional
@RunWith(JUnitPlatform.class)
@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { SecurityConfiguration.class, UsersConfig.class }, loader = AnnotationConfigContextLoader.class)
public class UserServiceTest extends BaseTests {

    protected EntityRandomizer r;


    @Autowired
    private final UserService userService;

    @Autowired
    private UserServiceTest(@Autowired final UserService userService) {

        this.userService = userService;

    }

    @BeforeEach
    public void beforeEach() {


        this.r = new EntityRandomizer();

        assertThat(this.userService).as("UserService bean is null").isNotNull();

    }


    @Test
    public void create() throws Exception {

        final User user   = this.r.get(User.class);
        final User result = this.userService.saveEntity(user);

        baseEntity_isValidAndCompare(user, this.userService.getById(result.getId()), "id");
    }

    @Test
    public void getAll() throws Exception {

        final Page<User> results = this.userService.getAll(PageRequest.of(0, 5));

        assertThat(results.getTotalElements()).isGreaterThan(0L);

        baseEntity_isValid(results.getContent().get(0));
        baseEntity_isValid(results.getContent().get(results.getNumberOfElements() - 1));

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

    @Test
    public void save() throws Exception {

        final User user     = this.userService.saveEntity(this.r.get(User.class));
        final User previous = this.userService.getById(user.getId());

        previous.setPassword(RandomString.make(User.PASSWORD_LEGNTH_MAX));
        previous.setStatus(2L);

        final User current = this.userService.saveEntity(previous);

        baseEntity_isValidAndCompare(previous, current, "id");

    }

    @Test
    public void delete() throws Exception {

        final User user = this.userService.saveEntity(this.r.get(User.class));

        baseEntity_isValid(user);

        assertThat(this.userService.deleteById(user.getId())).isTrue();

    }

    @Test
    public void getById() throws Exception {

        final User user = this.userService.saveEntity(this.r.get(User.class));

        baseEntity_isValid(user);

    }

}
