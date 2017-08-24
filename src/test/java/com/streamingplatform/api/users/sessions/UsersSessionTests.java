///*
// * Copyright (C) 2017 Matthew Davis <matthew@appsoa.io>
// *
// * This library is free software: you can redistribute it and/or
// * modify it under the terms of the GNU Lesser General Public
// * License as published by the Free Software Foundation; either
// * version 3 of the License, or (at your option) any later version.
// *
// * This library is distributed in the hope that it will be useful,
// * but WITHOUT ANY WARRANTY; without even the implied warranty of
// * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// * Library General Public License for more details.
// *
// * You should have received a copy of the GNU Lesser General Public
// * License along with this library.  If not, see
// * <http://www.gnu.org/licenses/>.
// */
//
//package com.streamingplatform.api.users.sessions;
//
//import com.streamingplatform.api.common.models.json.request.AuthenticationRequest;
//import com.streamingplatform.api.common.models.json.response.AuthenticationResponse;
//import com.streamingplatform.api.users.UsersApplication;
//import com.streamingplatform.api.users.repositories.UsersRepository;
//import org.apache.commons.codec.binary.Base64;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.*;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.web.client.HttpClientErrorException;
//
//import static org.hamcrest.core.Is.is;
//import static org.junit.Assert.assertThat;
//import static org.junit.Assert.fail;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = UsersApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class UsersSessionTests {
//
//    private static Logger log = LogManager.getLogger(UsersSessionTests.class);
//
//    @LocalServerPort
//    public int PORT;
//
//    @Autowired
//    private UsersRepository usersRepository;
//
//    private TestRestTemplate client;
//
//    //    @Autowired
//    private AuthenticationRequest authenticationRequest;
//
//    private String authenticationToken;sqd
//
//    //    @Autowired
//    //    private TokenUtils tokenUtils;
//
//    @Before
//    public void setUp() throws Exception {
//
//        log.trace("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!: " + PORT);
//        client = new TestRestTemplate();
//
//    }
//
//    @Test
//    public void loginTest() {
//
//        try {
//
//            String plainClientCredentials = "user:password";
//            //            String plainClientCredentials  = "user1:user1pass";
//            String base64ClientCredentials = new String(Base64.encodeBase64(plainClientCredentials.getBytes()));
//
//            HttpHeaders headers = new HttpHeaders();
//
//            headers.add("Authorization", "Basic " + base64ClientCredentials);
//
//            headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
//
//            HttpEntity<Object> httpEntity = new HttpEntity<>(authenticationRequest, headers);
//
//            //        HttpEntity<Object> httpEntity = RequestEntityBuilder
//            //            .buildRequestEntityWithoutAuthenticationToken(authenticationRequest);
//
//            //        httpEntity.getHeaders().add("Authorization", "Basic " + base64ClientCredentials);
//
//            ResponseEntity<AuthenticationResponse> responseEntity = client
//                .exchange("http://localhost:" + PORT + "/login",
//                          HttpMethod.POST,
//                          httpEntity,
//                          AuthenticationResponse.class);
//~
//            AuthenticationResponse authenticationResponse = responseEntity.getBody();
//
//            assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
//
//        } catch (HttpClientErrorException e) {
//
//            fail("RequestClient returned HTTP " + e.getStatusCode() + ": " + e.getStatusCode().getReasonPhrase());
//
//        }
//
//        //        try {
//        //            assertThat(this.tokenUtils.getUsernameFromToken(authenticationResponse.getToken()),
//        //                       is(authenticationRequest.getUsername()));
//        //        } catch (Exception e) {
//        //            fail("Should have returned expected username from token");
//        //        }
//
//    }
//
//}
