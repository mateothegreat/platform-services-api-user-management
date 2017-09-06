package platform.platform.api.users;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import org.junit.*;
import org.junit.runner.*;

import platform.platform.api.common.BaseTests;
import platform.services.api.common.authentication.Authenticated;
import platform.services.api.common.authentication.AuthenticationAuthorities;
import platform.services.api.common.jpa.repositories.BaseRepositoryOperations;
import platform.services.api.common.utilities.Tracing;
import platform.services.api.users.UserConfig;
import platform.services.api.users.jpa.User;
import platform.services.api.users.services.UserService;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
@Profile("test")
@RunWith(SpringRunner.class)
//@EnableTransactionManagement
//@Transactional
@ContextConfiguration(classes = { UserConfig.class, UserService.class }, loader = AnnotationConfigContextLoader.class)
public class UserServiceTest extends BaseTests<User> {

    @Autowired
    protected UserService      userService;
    protected EntityRandomizer r;
    protected User             setUp_created_User;

    @Before public void setUp() throws Exception {

        Authenticated.runAs("gibson", "password123", AuthenticationAuthorities.ADMIN, AuthenticationAuthorities.USER);

        r = new EntityRandomizer();

        setGenericService(userService);
        setUserService(userService);

        final User user = r.get(User.class);

        setUp_created_User = userService.saveEntity(user);

        baseEntity_isValid(setUp_created_User);
        baseEntity_isValid(userService.getById(setUp_created_User.getId()));

    }

    @Test
    public void create() throws Exception {

        final User user   = r.get(User.class);
        final User result = userService.saveEntity(user);

        baseEntity_isValid(user);
        baseEntity_isValid(result);

        baseEntity_isValidAndCompare(user, userService.getById(result.getId()));

    }

    @After public void tearDown() throws Exception {

//        baseEntity_deleteByObj(user);
//        baseEntity_getById_doesNotExist(user.getId());

    }

    @Test public void getAll() throws Exception {

        final Page<?> results = userService.getAll(BaseRepositoryOperations.pageRequestFactory());

        Tracing.trace("getAll: {}", Tracing.toString(results));

        assertThat(results.getTotalElements()).isGreaterThan(0L);

        baseEntity_isValid((User) results.getContent()
                                         .get(0));

    }

    @Test public void getUserByUsername() throws Exception {

        final User result = userService.getUserByUsername(UserConfig.USER_VALID_USERNAME);

        baseEntity_isValid(result);

    }

    @Test public void getUserByEmail() throws Exception {

        final User result = userService.getUserByEmail(UserConfig.USER_VALID_EMAIL);

        baseEntity_isValid(userService.getUserByEmail(UserConfig.USER_VALID_EMAIL));

    }

    @Test public void save() throws Exception {

        final User exists = userService.getUserByUsername(setUp_created_User.getUsername());
        final User result;

        if(exists == null) {

            result = userService.saveEntity((User) setUp_created_User);

        } else {

            baseEntity_isValid(exists);
            ;

            result = userService.saveEntity((User) setUp_created_User);

        }

        baseEntity_isValid(result);
        ;

        baseEntity_isValidAndCompare(result, exists);

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void getById() throws Exception {

        baseEntity_isValid(userService.getById(setUp_created_User.getId()));

    }

    public UserService getUserService() {

        assertThat(userService).isNotNull();

        return userService;

    }

    public void setUserService(final UserService userService) {

        assertThat(userService).isNotNull();

        this.userService = userService;

    }

}
