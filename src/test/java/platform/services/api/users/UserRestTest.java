package platform.services.api.users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import lombok.extern.log4j.Log4j2;

import org.junit.jupiter.api.*;

import platform.services.api.UsersConfig;
import platform.services.api.authentication.AuthenticatedRunAsManager;
import platform.services.api.authentication.Authorities;

import static io.restassured.RestAssured.given;

@Log4j2
public class UserRestTest extends BaseControllerTest {

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
               .basic(UsersConfig.USER_VALID_USERNAME,
                      UsersConfig.USER_VALID_PASSWORD)
               .get()
               .then()
               .statusCode(200)
               .and()
               .contentType(ContentType.JSON);

    }

    @Test
    void getAllReturnsPageable200() {

        final Response response = given().when()
                                         .auth()
                                         .basic(UsersConfig.USER_VALID_USERNAME,
                                                UsersConfig.USER_VALID_PASSWORD)
                                         .get("/users");

        final ResponseBody responseBody = response.getBody();

        log.fatal(responseBody.prettyPeek());

//        responseBody.jsonPath().getList("_embedded.users", )
//        ((RestAssuredResponseImpl) responseBody).getBody().jsonPath().getList("_embedded.users", User.class);

//        and().body("_embedded.books", hasSize(3) ).
//                and().body("_embedded.books.isbn", hasItems(  books.stream().map( Book::getIsbn ).toArray() ));

        response.then()
                .statusCode(200)
                .and()
                .contentType(ContentType.JSON);

    }

    @Test
    void getByUsernameReturns200() {

        final Response response = given().when()
                                         .auth()
                                         .basic(UsersConfig.USER_VALID_USERNAME,
                                                UsersConfig.USER_VALID_PASSWORD)
                                         .get("/users?username=testing-user1");

        final ResponseBody responseBody = response.getBody();

        log.trace(response.getBody().print());

        response.then()
                .statusCode(200)
                .and()
                .contentType(ContentType.JSON);

    }

    @Test
    void getByUsernameIs404() {

        final Response response = given().when()
                                         .auth()
                                         .basic(UsersConfig.USER_VALID_USERNAME,
                                                UsersConfig.USER_VALID_PASSWORD)
                                         .get("/users?username=newuser4123123");

        log.trace(response.getBody().prettyPeek());
        log.trace(response.andReturn().getBody().toString());
        log.trace(response.andReturn().getBody().print());
        log.trace(response.andReturn().getBody().prettyPeek());

        response.then().statusCode(404);

    }

    @Test
    void escalateReturns403() {

        AuthenticatedRunAsManager.runAs("gibson", "password123",
                                        Authorities.ROLE_USER);

        final Response response = given().when()
                                         .auth()
                                         .basic(UsersConfig.USER_VALID_USERNAME,
                                                UsersConfig.USER_VALID_PASSWORD)
                                         .get("/users/escalate");

        final ResponseBody responseBody = response.getBody();

        log.fatal(responseBody.prettyPeek());
        response.then()
                .statusCode(403)
                .and()
                .contentType(ContentType.JSON);

    }
}
