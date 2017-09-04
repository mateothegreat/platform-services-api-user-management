//
//
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
//package com.streamingplatform.api.users;
//
///*-
// * $$SoftwareLicense
// * Streaming Platform Users API
// * %%
// * Copyright (C) 2017 streamnvr
// * %%
// * __
// *       /\ \__
// *   ____\ \ ,_\  _ __    __     __      ___ ___     ___   __  __   _ __
// *  /',__\\ \ \/ /\`'__\/'__`\ /'__`\  /' __` __`\ /' _ `\/\ \/\ \ /\`'__\
// * /\__, `\\ \ \_\ \ \//\  __//\ \L\.\_/\ \/\ \/\ \/\ \/\ \ \ \_/ |\ \ \/
// * \/\____/ \ \__\\ \_\\ \____\ \__/.\_\ \_\ \_\ \_\ \_\ \_\ \___/  \ \_\
// *  \/___/   \/__/ \/_/ \/____/\/__/\/_/\/_/\/_/\/_/\/_/\/_/\/__/    \/_/
// *
// *
// * This program is free software: you can redistribute it and/or modify
// * it under the terms of the GNU General Public License as
// * published by the Free Software Foundation, either version 3 of the
// * License, or (at your option) any later version.
// *
// * This program is distributed in the hope that it will be useful,
// * but WITHOUT ANY WARRANTY; without even the implied warranty of
// * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// * GNU General Public License for more details.
// *
// * You should have received a copy of the GNU General Public
// * License along with this program.  If not, see
// * <http://www.gnu.org/licenses/gpl-3.0.html>.
// * streaming-platform.com
// */
//
//import com.streamingplatform.api.common.config.*;
//import User;
//import UserService;
//import AuthenticationUtils;
//import com.streamingplatform.integration.utilities.*;
//import RequestClient.*;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.*;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.*;
//import org.springframework.authentication.access.*;
//import org.springframework.authentication.authentication.*;
//import org.springframework.authentication.core.context.*;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.*;
//import org.springframework.web.client.*;
//
//import static org.assertj.core.api.Fail.*;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.core.Is.is;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = UsersApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
//// @ContextConfiguration(classes = UsersApplication.class)
//// @WebAppConfiguration
//// @EnableWebSecurity
//// @AutoConfigureMockMvc
//@Transactional
//public class UserControllerTests {
//
//    private static final String PASSWORD = "password";
//    private static final String USERNAME = "user";
//
//    private Logger Tracing = LogManager.getLogger(UserControllerTests.class);
//
//    private RequestClient requestClient;
//
////    @Autowired
////    private UserRepository userRepository;
//
////    @Autowired
////    private UserController userController;
////
//    @Autowired
//    private UserService service;
//
//    @LocalServerPort
//    private int localServerPort;
//
//    private User user1;
//
//    @Before
//    public void setUp() throws InterruptedException {
//        SecurityContextHolder.clearContext();
//
////        this.requestClient = new RequestClientBuilder(TestingConfig.USER_VALID_USERNAME,
////                TestingConfig.USER_VALID_PASSWORD).build();
//
//        Tracing.fatal("setup");
//
//        user1 = new User();
//
//        user1.setEmail("user1@user1.com");
//        user1.setUsername("user1");
//        user1.setPassword("password");
//        user1.setParentId(0);
//        user1.setStatus(1);
//
//    }
//
//    @Test
//    public void createUser() throws Exception {
//
//
//    }
//
//    @Test
//    public void rejectsMethodInvocationsForNoAuth() {
//
//        try {
//
//            service.findAll();
//
//            fail("Expected a authentication error");
//
//        } catch (AuthenticationCredentialsNotFoundException e) {
//
//            // expected
//
//        }
//
//        try {
//
//            service.save(user1);
//
//            fail("Expected a authentication error");
//
//        } catch (AuthenticationCredentialsNotFoundException e) {
//
//            // expected
//
//        }
//
//        try {
//            service.delete(user1);
//
//            fail("Expected a authentication error");
//
//        } catch (AuthenticationCredentialsNotFoundException e) {
//
//            // expected
//
//        }
//
//    }
//
//    @Test
//    public void rejectsMethodInvocationsForAuthWithInsufficientPermissions() {
//
//        AuthenticationUtils.runAs("system", "system", "ROLE_USER");
//
//        service.findAll();
//
//        try {
//
//            service.save(user1);
//
//            fail("Expected a authentication error");
//
//        } catch (AccessDeniedException e) {
//            // expected
//        }
//        try {
//
//            service.delete(user1);
//
//            fail("Expected a authentication error");
//
//        } catch (AccessDeniedException e) {
//            // expected
//        }
//    }
//
//    @Test
//    public void allowsMethodInvocationsForAuthWithSufficientPermissions() {
//
//        AuthenticationUtils.runAs("system", "system", "ROLE_USER", "ROLE_ADMIN");
//
//        service.findAll();
//        service.save(user1);
//        service.delete(user1);
//
//    }
//
//    @Test
//    public void getUsers_invalidCredentials() throws Exception {
//
//        try {
//
//            RequestClient requestClient = new RequestClientBuilder(TestingConfig.USER_INVALID_USERNAME,
//                    TestingConfig.USER_INVALID_PASSWORD).build();
//
//            ResponseEntity responseEntity = requestClient.getClient()
//                                                         .exchange("http://localhost:" + localServerPort + "/users",
//                                                                 HttpMethod.GET, requestClient.getHttpEntity(),
//                                                                 String.class);
//
//            assertThat(responseEntity.getStatusCode(), is(HttpStatus.UNAUTHORIZED));
//
//        } catch(HttpClientErrorException e) {
//
//            assertThat(e.getStatusCode(), is(HttpStatus.UNAUTHORIZED));
//
//        }
//
//    }
//
//    @Test
//    public void getUsers_validCredentials() throws Exception {
//
//        ResponseEntity responseEntity = requestClient.getClient()
//                                                     .exchange(getUrl("/users"), HttpMethod.GET,
//                                                             requestClient.getHttpEntity(), String.class);
//
//        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
//
//    }
//
//    private String getUrl(String path) {
//
//        return "http://localhost:" + localServerPort + path;
//
//    }
//
//}
