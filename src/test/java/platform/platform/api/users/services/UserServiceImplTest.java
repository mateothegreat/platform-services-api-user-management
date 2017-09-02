package platform.platform.api.users.services;

import com.platform.api.common.*;
import com.platform.api.users.*;
import com.streamingplatform.api.common.entities.*;
import com.streamingplatform.api.common.repositories.*;
import com.streamingplatform.api.common.utils.logging.*;
import com.streamingplatform.api.users.entities.*;
import com.streamingplatform.api.users.services.*;
import org.assertj.core.api.*;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.*;
import org.springframework.data.domain.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;
import platform.platform.api.common.*;
import platform.platform.api.users.*;
import platform.api.common.entities.*;
import platform.api.common.repositories.*;
import platform.api.common.utils.logging.*;
import platform.services.api.users.entities.*;
import platform.services.api.users.services.*;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
//@ComponentScan({"com.streamingplatform.api.users"})
//@ContextConfiguration(classes = {
//        UserService.class,
//        DataSourceConfig.class
//}, loader = AnnotationConfigContextLoader.class)
@ContextConfiguration
public class UserServiceImplTest extends BaseTests {
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private UserService userService;
    private User        user;

    @Before
    public void setUp() throws Exception {

        this.genericService = userService;

        user = UserTestUtils.buildUser();

        User created = userService.save(user);

        baseEntity_isValid(created);

    }

    @After
    public void tearDown() throws Exception {

        baseEntity_deleteByObj(user);

        Assertions.assertThat(userService.getUserByEmail(UserTestUtils.USER_VALID_EMAIL)).isNull();

    }

    @Test
    public void getAll() throws Exception {

        Page results = userService.getAll(BaseRepositoryOperations.pageRequestFactory());

        Tracing.trace("getAll: {}", Tracing.toString(results));

        assertThat(results.getTotalElements()).isEqualTo(1);
        assertThat(results.getTotalPages()).isEqualTo(1);

        BaseEntity result = (User) results.getContent()
                                          .get(0);

        baseEntity_isValid(result);
        getEntity_CompareEntity(result, user);

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
