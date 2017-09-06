package platform.platform.api.users;

import io.restassured.RestAssured;

import org.junit.*;
import org.junit.jupiter.api.*;

public class BaseRestTests {

    @BeforeClass
    void setUp_BeforeClass() {

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
    void setUp_BeforeEeach() {

    }

}
