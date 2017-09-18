package platform.services.api.users;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import org.junit.jupiter.api.Test;

import platform.services.api.UsersApplication;
import platform.services.api.UsersConfig;
import platform.services.api.commons.jpa.enums.Role;
import platform.services.api.commons.testing.BaseControllerTest;
import platform.services.api.commons.testing.ComposedJUnit5BootTest;
import platform.services.api.users.authentication.AuthenticatedRunAsManager;
import platform.services.api.users.authentication.Authorities;

@Log4j2
@ComposedJUnit5BootTest
@SpringBootConfiguration
@ContextConfiguration(classes = { UsersConfig.class, UsersApplication.class }, loader = AnnotationConfigContextLoader.class)
public class UserControllerTest extends BaseControllerTest {

    public static void main(final String[] args) {

        SpringApplication.run(UsersApplication.class, args);

    }

    @Test
    void getBasePathWithNoAuthenticationReturns401() {

        given().when()
               .get()
               .then()
               .statusCode(401);

    }

    @Test
    void getBasePathWithAuthReturns200() {

        given().when()
               .auth()
               .basic(UsersConfig.USER_VALID_USERNAME, UsersConfig.USER_VALID_PASSWORD)
               .get()
               .then()
               .statusCode(200)
               .and()
               .contentType(ContentType.JSON);

    }

    @Test
    void getAllReturnsPageable200() {

        given().when()
               .auth()
               .basic(UsersConfig.USER_VALID_USERNAME, UsersConfig.USER_VALID_PASSWORD)
               .get("/users").then()
               .statusCode(200)
               .and()
               .contentType(ContentType.JSON);

    }

    @Test
    void getByUsernameReturns200() {

        given().when()
               .auth()
               .basic(UsersConfig.USER_VALID_USERNAME, UsersConfig.USER_VALID_PASSWORD)
               .get("/users?username=testing-user1").then()
               .statusCode(200)
               .and()
               .contentType(ContentType.JSON);

    }

    @Test
    void getByUsernameIs404() {

        given().when()
               .auth()
               .basic(UsersConfig.USER_VALID_USERNAME, UsersConfig.USER_VALID_PASSWORD)
               .get("/users?username=newuser4123123")
               .then()
               .statusCode(404);

    }

    @Test
    void escalateReturns200() {

        AuthenticatedRunAsManager.runAs("gibson", Role.ROLE_USER);

        given().when()
               .auth()
               .basic(UsersConfig.USER_VALID_USERNAME,
                      UsersConfig.USER_VALID_PASSWORD)
               .get("/users/escalate").then().statusCode(200);

    }

}
