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
public class UserRestTest extends BaseRestTests {

    @Test
    void getBasePathWithNoAuthentication() {

        given().when()
               .get()
               .then()
               .statusCode(401);

    }

    @Test
    void getBasePathWithAuthentication() {

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
    void getAll() {

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
    void getByUsername_matchUsername() {

        final Response response = given().when()
                                         .auth()
                                         .basic(UsersConfig.USER_VALID_USERNAME,
                                                UsersConfig.USER_VALID_PASSWORD)
                                         .get("/users?username=testing-user1");

        final ResponseBody responseBody = response.getBody();

        log.fatal(responseBody.prettyPeek());

        response.then()
                .statusCode(200)
                .and()
                .contentType(ContentType.JSON);

    }

    @Test
    void getByUsername_failUsername() {

//        AuthenticatedRunAsManager.runAs("gibson", "password123",
//                                        Authorities.ROLE_ADMIN, Authorities.ROLE_USER);

        final Response response = given().when()
                                         .auth()
                                         .basic(UsersConfig.USER_VALID_USERNAME,
                                                UsersConfig.USER_VALID_PASSWORD)
                                         .get("/users?username=newuser4");

        response.then()
                .statusCode(403)
                .and()
                .contentType(ContentType.JSON);

    }

    @Test
    void escalate_fail() {

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
