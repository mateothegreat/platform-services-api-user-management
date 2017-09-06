package platform.platform.api.users;

import io.restassured.http.ContentType;
import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import lombok.extern.log4j.Log4j2;

import org.junit.jupiter.api.*;

import platform.services.api.users.UserConfig;

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
               .basic(UserConfig.USER_VALID_USERNAME, UserConfig.USER_VALID_PASSWORD)
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
                                         .basic(UserConfig.USER_VALID_USERNAME, UserConfig.USER_VALID_PASSWORD)
                                         .get("/users");

        ResponseBody responseBody = response.getBody();

        log.fatal(responseBody.prettyPeek());
        log.fatal(responseBody.prettyPrint());
        log.fatal(responseBody.print());


//        responseBody.jsonPath().getList("_embedded.users", )
//        ((RestAssuredResponseImpl) responseBody).getBody().jsonPath().getList("_embedded.users", User.class);



//        and().body("_embedded.books", hasSize(3) ).
//                and().body("_embedded.books.isbn", hasItems(  books.stream().map( Book::getIsbn ).toArray() ));


        response.then()
                .statusCode(200)
                .and()
                .contentType(ContentType.JSON);

    }

}
