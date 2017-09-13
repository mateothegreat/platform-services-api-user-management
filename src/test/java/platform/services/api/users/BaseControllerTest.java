package platform.services.api.users;

import io.restassured.RestAssured;

import org.junit.*;
import org.junit.jupiter.api.*;

import platform.services.api.commons.testing.BaseTests;
import platform.services.api.commons.testing.EntityRandomizer;

public class BaseControllerTest extends BaseTests {

    protected EntityRandomizer r;

    @BeforeClass public static void beforeClass() {

        //        String port = System.getProperty("server.port");
        //
        //        if(port == null) {
        //
        //            RestAssured.port = Integer.valueOf(8080);
        //
        //        } else {
        //
        //            RestAssured.port = Integer.valueOf(port);
        //
        //        }

        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/users";

    }

    @BeforeEach
    public void beforeEach() {

        r = new EntityRandomizer();

    }


}
