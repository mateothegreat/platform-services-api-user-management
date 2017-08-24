

/*
 * Copyright (C) 2017 Matthew Davis <matthew@appsoa.io>
 *
 * This library is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library.  If not, see
 * <http://www.gnu.org/licenses/>.
 */

package com.streamingplatform.api.users.sessions;

import com.streamingplatform.api.common.config.TestingConfig;
import com.streamingplatform.api.users.UsersApplication;
import com.streamingplatform.integration.utilities.RequestClient;
import com.streamingplatform.integration.utilities.RequestClient.RequestClientBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UsersApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
// @ContextConfiguration(classes = UsersApplication.class)
// @WebAppConfiguration
// @EnableWebSecurity
// @AutoConfigureMockMvc
public class UserControllerUnitTest {
    
    private static final String PASSWORD = "password";
    private static final String USERNAME = "user";
    
    private Logger logger = LogManager.getLogger(UserControllerUnitTest.class);
    
    private RequestClient requestClient;
    
    @LocalServerPort
    private int localServerPort;
    
    @Before
    public void setUp() throws InterruptedException {
        
        this.requestClient = new RequestClientBuilder(TestingConfig.USER_VALID_USERNAME,
                                                      TestingConfig.USER_VALID_PASSWORD).build();
        
        logger.trace("setup");
        // Thread.sleep(5000);
    }
    
    // @Test
    // public void getUsers_invalidCredentials() throws Exception {
    //
    //     try {
    //
    //         RequestClient requestClient = new RequestClientBuilder(TestingConfig.USER_INVALID_USERNAME,
    //                                                                TestingConfig.USER_INVALID_PASSWORD).build();
    //
    //         ResponseEntity responseEntity = requestClient.getClient()
    //                                                      .exchange("http://localhost:" + localServerPort + "/users",
    //                                                                HttpMethod.GET, requestClient.getHttpEntity(),
    //                                                                String.class);
    //
    //         assertThat(responseEntity.getStatusCode(), is(HttpStatus.UNAUTHORIZED));
    //
    //     } catch(HttpClientErrorException e) {
    //
    //         assertThat(e.getStatusCode(), is(HttpStatus.UNAUTHORIZED));
    //
    //     }
    //
    // }
    
    @Test
    public void getUsers_validCredentials() throws Exception {
        
        ResponseEntity responseEntity = requestClient.getClient()
                                                     .exchange(getUrl("/users"), HttpMethod.GET,
                                                               requestClient.getHttpEntity(), String.class);
        
        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
        
    }
    //
    // @Test
    // public void getUsersFindAll() throws Exception {
    //
    //     mockMvc.perform(get("/users").accept(MediaType.APPLICATION_JSON))
    //            .andExpect(status().isOk())
    //            .andExpect(authenticated());
    //
    // }
    
    // @Test
    // public void logoutTest() throws Exception {
    //
    //     mvc.perform(logout())
    //        .andExpect(unauthenticated());
    //
    // }
    
    private String getUrl(String path) {
        
        return "http://localhost:" + localServerPort + path;
        
    }
    
}
