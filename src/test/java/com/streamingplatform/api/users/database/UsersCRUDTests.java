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
//package com.streamingplatform.api.users.database;
//
//import com.streamingplatform.api.users.UsersApplication;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = UsersApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class UsersCRUDTests {
//
//    @LocalServerPort
//    private int localServerPort;
//
//    private static final String USERS_ENDPOINT = "/users";
//    private static       Logger logger         = LogManager.getLogger(UsersCRUDTests.class.getName());
//
//    //    @Autowired
//    //    private TestRestTemplate template;
//
//    @Test
//    public void dummyTest() {
//
//    }
//
//    //    @Test
//    //    public void controllerShouldReturn_401unauthorized() throws Exception {
//    //
//    //        try {
//    //
//    //            HttpHeaders httpHeaders = new HttpHeaders();
//    //            httpHeaders.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
//    //
//    //            HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
//    //
//    //            ResponseEntity<User[]> responseEntity = template
//    //                .exchange(USERS_ENDPOINT, HttpMethod.GET, entity, User[].class);
//    //
//    //            logger.debug(responseEntity.getStatusCode());
//    //            assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
//    //
//    //        } catch (RestClientException e) {
//    //
//    //            logger.debug(e.toString());
//    //            logger.debug(e.getLocalizedMessage());
//    //            logger.debug(e.getMessage());
//    //            //            fail("asdfasdf");
//    //            //            fail(e.getMessage());
//    //            //            fail("RequestClient returned an " + e.getStatusCode() + ":" + e.getStatusText());
//    //
//    //        } catch (HttpMessageNotReadableException e) {
//    //
//    //            logger.debug(e.getMessage());
//    //
//    //        }
//    //
//    //    }
//
//    //    @Test
//    //    public void findAll() throws JSONException {
//    //
//    //        try {
//    //
//    //            HttpHeaders httpHeaders = new HttpHeaders();
//    //            httpHeaders.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
//    //
//    //            HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
//    //
//    //            ResponseEntity<User[]> responseEntity = template
//    //                .exchange(USERS_ENDPOINT, HttpMethod.GET, entity, User[].class);
//    //
//    //            assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//    //
//    //        } catch (HttpClientErrorException e) {
//    //
//    //            fail("RequestClient returned an " + e.getStatusCode() + ":" + e.getStatusText());
//    //
//    //        }
//    //
//    //    }
//
//}
