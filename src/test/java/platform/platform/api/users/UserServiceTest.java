package platform.platform.api.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import org.junit.*;
import org.junit.runner.*;

import platform.platform.api.common.BaseTests;
import platform.services.api.common.jpa.repositories.BaseRepositoryOperations;
import platform.services.api.common.utilities.Tracing;
import platform.services.api.users.jpa.User;
import platform.services.api.users.services.UserService;

import static org.assertj.core.api.Assertions.assertThat;

@Profile("test")
@RunWith(SpringRunner.class)
@EnableTransactionManagement
@Transactional
@ContextConfiguration(classes = { UserConfig.class, UserService.class }, loader = AnnotationConfigContextLoader.class)
public class UserServiceTest extends BaseTests {

    @Autowired private UserService userService;
    private            User        user;

    @Before
    public void setUp() throws Exception {

        setGenericService(userService);

        setUserService(userService);

        user = UserConfig.buildUser();

        final User created = userService.save(user);

        BaseTests.baseEntity_isValid(created);

    }

    @After
    public void tearDown() throws Exception {

        baseEntity_deleteByObj(user);
        baseEntity_getById_doesNotExist(user.getId());

    }

    @Test
    public void getAll() throws Exception {

        final Page<?> results = userService.getAll(BaseRepositoryOperations.pageRequestFactory());

        Tracing.trace("getAll: {}", Tracing.toString(results));

        assertThat(results.getTotalElements()).isGreaterThan(1L);

        BaseTests.baseEntity_isValid((User) results.getContent()
                                                   .get(0));

    }

    @Test
    public void getUserByUsername() throws Exception {

        final User result = userService.getUserByUsername(UserConfig.USER_VALID_USERNAME);

        baseEntity_isValid(user);
        baseEntity_compare(result, user);

    }

    @Test
    public void getUserByEmail() throws Exception {

        final User result = userService.getUserByEmail(UserConfig.USER_VALID_EMAIL);

        baseEntity_isValid(userService.getUserByEmail(UserConfig.USER_VALID_EMAIL));
        baseEntity_compare(result, user);

    }


    @Test
    public void save() throws Exception {

        user.setStatus(5);
        user.setParentId(1L);

        final User result = userService.save(user);

        baseEntity_isValid(userService.getById(user.getId()));
        baseEntity_compare(result, user);

    }

    @Test
    public void getById() throws Exception {

        baseEntity_isValid(userService.getById(user.getId()));

    }

    public UserService getUserService() {

        assertThat(userService).isNotNull();

        return userService;
    }
    public void setUserService(final UserService userService) {

        assertThat(userService).isNotNull();

        this.userService = userService;

    }

//    @Test
//    public void save() throws Exception {
//
//    }
//
//    @Test
//    public void getPermissions() throws Exception {
//
//    }
//
//    @Test
//    public void delete() throws Exception {
//
//    }

}
