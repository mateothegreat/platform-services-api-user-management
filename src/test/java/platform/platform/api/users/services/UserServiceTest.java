package platform.platform.api.users.services;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import platform.platform.api.common.BaseTests;
import platform.platform.api.users.UserTestUtils;
import platform.services.api.common.jpa.repositories.BaseRepositoryOperations;
import platform.services.api.common.utilities.Tracing;
import platform.services.api.users.jpa.User;
import platform.services.api.users.services.UserService;

import static org.assertj.core.api.Assertions.assertThat;

//@ActiveProfiles("test")
@Profile("test")
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestingConfig.class, loader = AnnotationConfigContextLoader.class)
public class UserServiceTest extends BaseTests {

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private UserService userService;

    private User user;

    @Before
    public void setUp() throws Exception {

        this.setGenericService(userService);

        user = UserTestUtils.buildUser();

        final User created = userService.save(user);

        this.baseEntity_isValid(created);

    }

    @After
    public void tearDown() throws Exception {

        this.baseEntity_deleteByObj(user);

        assertThat(userService.getUserByEmail(TestingConfig.USER_VALID_EMAIL)).isNull();

    }

    @Test
    public void getAll() throws Exception {

        final Page<?> results = userService.getAll(BaseRepositoryOperations.pageRequestFactory());

        Tracing.trace("getAll: {}", Tracing.toString(results));

        assertThat(results.getTotalElements()).isGreaterThan(1);
        assertThat(results.getTotalPages()).isEqualTo(1);

        this.baseEntity_isValid((User) results.getContent()
                                              .get(0));

    }

//    @Test
//    public void findAll1() throws Exception {
//
//    }

//    @Test
//    public void getUserByUsername() throws Exception {
//
//        baseEntity_isValid(userService.getUserByUsername(UserTestUtils.USER_VALID_USERNAME));
//
//    }
//    @Test
//    public void getUserByEmail() throws Exception {
//
//        baseEntity_isValid(userService.getUserByEmail(UserTestUtils.USER_VALID_EMAIL));
//
//    }

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
