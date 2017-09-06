package platform.platform.api.users;

import io.restassured.http.ContentType;
import io.restassured.internal.http.Status;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;

import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

@Log4j2
public class UserRestTest extends BaseRestTests {

    @Test
    void getBasePathWithNoAuthentication() {

        given().when()
               .get()
               .then()
               .statusCode(401)
               .and()
               .contentType(ContentType.JSON);

    }

    @Test
    void getAll() {

        final Response response = get("/users");

        log.trace(response);

        assert Status.SUCCESS.matches(200);

//        assertThat(response.getStatusCode()).isEqualTo(Response.)

    }


}
