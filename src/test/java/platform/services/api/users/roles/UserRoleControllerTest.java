package platform.services.api.users.roles;

import org.springframework.http.HttpStatus;

import org.junit.jupiter.api.Test;

import platform.services.api.commons.enums.Role;
import platform.services.api.commons.testing.RestAssuredFactory;
import platform.services.api.commons.testing.TestingSpringController;
import platform.services.api.users.UserBaseTest;

@TestingSpringController class UserRoleControllerTest extends UserBaseTest {

    private static final String PATH_BASE      = "/users/roles";
    private static final String PATH_BASE_TEST = "/users/roles/check";

    UserRoleControllerTest() {

        super(UserRole.class, PATH_BASE);

    }

    @Test
    void httpGetAndhasRoleAdmin() {

        RestAssuredFactory.request(PATH_BASE_TEST).get(Role.ROLE_ADMIN.name()).then().statusCode(HttpStatus.OK.value());


    }

    @Test
    void httpGetAndhasRoleUser() {

        RestAssuredFactory.request(PATH_BASE_TEST).get(Role.ROLE_USER.name()).then().statusCode(HttpStatus.OK.value());


    }

    @Test
    void httpGetAndhasRoleEmpty() {

        RestAssuredFactory.request(PATH_BASE_TEST).get(Role.ROLE_EMPTY.name()).then().statusCode(HttpStatus.FORBIDDEN.value());

    }

}
