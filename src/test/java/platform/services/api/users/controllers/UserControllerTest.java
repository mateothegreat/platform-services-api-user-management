package platform.services.api.users.controllers;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Profile;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import org.junit.*;
import org.junit.runner.*;

import platform.platform.api.common.BaseTests;
import platform.services.api.users.UserConfig;
import platform.services.api.common.jpa.repositories.BaseRepositoryPage;
import platform.services.api.common.request.RequestClient;
import platform.services.api.common.request.RequestClient.RequestClientBuilder;
import platform.services.api.common.request.RequestClientAuth;
import platform.services.api.common.request.RequestClientURL;
import platform.services.api.common.utilities.Tracing;
import platform.services.api.users.Application;
import platform.services.api.users.jpa.User;

@Profile("test")
@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = { DataSourceConfig.class,ApplicationConfig.class }, loader = AnnotationConfigContextLoader.class)
@SpringBootTest(classes = { Application.class }, webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserControllerTest extends BaseTests {

    private RequestClientURL requestClient;
    private User             user;

    @LocalServerPort private int localServerPort;

    private static class BaseRepositoryPageParameterizedTypeReference extends ParameterizedTypeReference<BaseRepositoryPage<User>> {

    }

    @Before public void setUp() throws Exception {

        user = UserConfig.buildUser();

//        requestClient = new RequestClientBuilder(UserConfig.USER_VALID_USERNAME, UserConfig.USER_VALID_PASSWORD).build();

        Tracing.trace("setup");

    }

    @After public void tearDown() throws Exception {

    }

    @Test public void save() throws RestClientException {

//        final RequestClient requestClient = new RequestClientBuilder("user1", "password").build();

//        final ResponseEntity<?> responseEntity = requestClient.getClient()
//                                                           .exchange(
//                                                             getUrl(localServerPort, "/users"),
//                                                             HttpMethod.GET,
//                                                             requestClient.getHttpEntity(), String.class);

//        final ResponseEntity responseEntity = requestClient.getResponseEntity(getUrl(localServerPort, "/users"), HttpMethod.GET);

//        final ResponseEntity client = new RequestClientBuilder("user1", "password", getUrl(localServerPort, "/users"),
//                                                                              HttpMethod.GET, "").build().getResponseEntity(HttpMethod.GET, getUrl(localServerPort, "/users"));
//
//        Tracing.trace("responseEntity: {}", client.toString());
//
//        assertThat(client.getStatusCode()).isEqualTo(HttpStatus.OK);

//        final UriComponents uri = UriComponentsBuilder.newInstance()
//                                                      .scheme("http")
//                                                      .host("localhost")
//                                                      .port(localServerPort)
//                                                      .path("/users")
//                                                      .build()
//                                                      .encode();
//
//        final RequestClientAuth auth = new RequestClientAuth("user1", "password");
//
//        Tracing.trace(auth.toString());

        final ParameterizedTypeReference<BaseRepositoryPage<User>> responseType = new BaseRepositoryPageParameterizedTypeReference();

        final UriComponents uri = UriComponentsBuilder.newInstance()
                                                      .scheme("http")
                                                      .host("localhost")
                                                      .port(localServerPort)
                                                      .path("/users")
                                                      .queryParam("size", 5)
                                                      .buildAndExpand("user1")
                                                      .encode();

        final RequestClient requestClient = new RequestClientBuilder(uri, new RequestClientAuth("user1", "password"),
                MediaType.APPLICATION_JSON, "").build();


//        final ResponseEntity<BaseRepositoryPage<User>> result = requestClient.getClient().exchange(uri.toUri(), HttpMethod.GET, requestClient.getHttpEntity(), responseType);

//        final ResponseEntity<BaseRepositoryPage<User>> result = requestClient.getClient().exchange(uri.toUri(), HttpMethod.GET, requestClient.getHttpEntity(), responseType);

        final ResponseEntity<?> result = requestClient.getClient().exchange(uri.toUri(), HttpMethod.GET, requestClient.getHttpEntity(), Object.class);

        Tracing.trace(result.toString());
//        final ResponseEntity<String> responseEntity = new RequestClientBuilder(,
//                new RequestClientAuth("user1", "password"),
//                MediaType.APPLICATION_JSON, "")
//
//                .build()
//                .exchange(HttpMethod.GET, User[].class);

//        Tracing.trace(responseEntity.toString());
//        Tracing.trace(responseEntity.getBody()
//                                    .toString());

//        PageImpl<User> body = responseEntity.getBody();

//        PageImpl<User> page = new PageImpl<User>(body);

//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

    }

    @Test public void getAll() throws Exception {

    }

    @Test public void getByUsername() throws Exception {

    }

    @Test public void getByEmail() throws Exception {

    }

}
