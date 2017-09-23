package platform.services.api.users;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import org.junit.jupiter.api.Test;

import platform.services.api.commons.enums.Role;
import platform.services.api.commons.testing.EntityRandomizer;
import platform.services.api.commons.testing.Randomizers;
import platform.services.api.commons.testing.RestAssuredFactory;
import platform.services.api.commons.testing.TestingSpringController;

@Log4j2
//@ComposedJUnit5BootTest
//@EnableAutoConfiguration
//@RunWith(SpringRunner.class)
//
//@SpringBootTest(
//    webEnvironment = WebEnvironment.RANDOM_PORT,
//    classes = {
//
//        UsersApplication.class,
//        UsersConfig.class,
//        UserController.class
//
//    })
//
//
//@ContextConfiguration(classes = { UsersApplication.class, UserService.class, SessionConfiguration.class })
@TestingSpringController
public class UserControllerTest extends UserBaseTest {

    private static final String PATH_BASE         = "/users";
    private static final String PATH_GET_FIND_ALL = "/users";
    private static final String PATH_GET_BY_ID    = "/users/{id}";
    private static final String PATH_DELETE_BY_ID = "/users/{id}";
    private static final String PATH_SAVE_BY_ID   = "/users/{id}";

    private static final RoleMethod METHOD_GET_BY_ID    = new RoleMethod(Role.ROLE_USER_GET, HttpMethod.GET, PATH_GET_BY_ID);
    private static final RoleMethod METHOD_DELETE_BY_ID = new RoleMethod(Role.ROLE_USER_DELETE, HttpMethod.GET, PATH_DELETE_BY_ID);
    private static final RoleMethod METHOD_SAVE_BY_ID   = new RoleMethod(Role.ROLE_USER_POST, HttpMethod.GET, PATH_SAVE_BY_ID);

    public UserControllerTest() {

        super(User.class, PATH_BASE);

    }

    @Test public User getByIdReturns200(final Long id) {

        assertThat(id).isNotZero();

        return getAndAssertJSONandStatusCode(String.format("/users/%d", this.getUser().getId()), HttpStatus.OK).as(User.class);

    }

    @Test public void getByIdReturns404() {

        getAndAssertJSONandStatusCode(String.format("/users/%d", Randomizers.id()), HttpStatus.NOT_FOUND);

    }

    @Test public void getByUUIDReturns200() {

        getAndAssertJSONandStatusCode(String.format("/users/%s", this.getUser().getUuid()), HttpStatus.OK);

    }

    @Test public void getByUUIDReturns404() {

        getAndAssertJSONandStatusCode(String.format("/users/%s", Randomizers.uuid()), HttpStatus.NOT_FOUND);

    }

    @Test
    public void findByUsernameReturns200() {

        final ExtractableResponse<Response> response = getAndAssertJSONandStatusCode(String.format("/users?username=%s", this.getUser().getUsername()), HttpStatus.OK);

        final User result = response.body().as(User.class);

        assertThat(result.getId()).isEqualTo(this.getUser().getId());
        assertThat(result.getRoles()).hasSameSizeAs(this.getUser().getRoles());
        assertThat(result.getProfiles()).hasSameSizeAs(this.getUser().getProfiles());

    }

    @Test
    public void findByUsernameReturns404() {

        getAndAssertJSONandStatusCode(String.format("/users?username=%s", EntityRandomizer.username.getRandomValue()), HttpStatus.NOT_FOUND);

    }

    @Test
    public void saveUserReturns200andChangesMatch() {

        final String newEmail = Randomizers.email();
        final User   target   = getByIdReturns200(this.createUserFixture().getId());

        target.setEmail(newEmail);

        final User response = RestAssuredFactory.request()
                                                .body(target)
                                                .post("/users").then()
                                                .statusCode(HttpStatus.OK.value())
                                                .extract()
                                                .as(User.class);

        assertThat(response.getEmail()).isEqualTo(newEmail);

    }

}
