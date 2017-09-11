package platform.services.api.users;

import lombok.extern.log4j.Log4j2;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import org.junit.*;
import org.junit.runner.*;

import platform.services.api.UsersConfig;
import platform.services.api.authentication.SecurityConfiguration;
import platform.services.api.commons.testing.BaseTests;
import platform.services.api.commons.testing.EntityRandomizer;
import platform.services.api.commons.utilities.Tracing;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
@Profile("testing")
@RunWith(SpringRunner.class)
@Transactional
//@ComponentScan({ "platform.services.api.*", "platform.services.api.authentication", "platform.services.api.users" })
@ContextConfiguration(classes = {

    SecurityConfiguration.class,
    UsersConfig.class,

}, loader = AnnotationConfigContextLoader.class)

public class UserServiceTest extends BaseTests {

    @Autowired protected UserService userService;

    protected EntityRandomizer r;

    @Before
    public void setUp() throws Exception {

        //    AuthenticatedRunAsRole.runAs(
        //        "gibson", "password123", AuthenticationAuthorities.ADMIN,
        // AuthenticationAuthorities.USER);

        this.r = new EntityRandomizer();

        assertThat(this.userService).isNotNull();

        this.userService = this.userService;
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

        Tracing.trace("getAll: {}", Tracing.toString(results));

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
