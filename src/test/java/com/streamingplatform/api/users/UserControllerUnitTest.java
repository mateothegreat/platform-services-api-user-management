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

package com.streamingplatform.api.users;

import com.streamingplatform.api.users.common.utils.logging.Log;
import com.streamingplatform.api.users.controllers.UserController;
import com.streamingplatform.api.users.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Base64Utils;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
// @WebAppConfiguration
// @ComponentScan("com.streamingplatform")
@SpringBootTest(classes = UsersApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
// @ContextConfiguration(classes = UsersApplication.class)
// @WebAppConfiguration
public class UserControllerUnitTest {
    
    @Autowired
    private UserController        userController;
    @Autowired
    private UserRepository        userRepository;
    @Autowired
    private WebApplicationContext context;
    private MockMvc               mvc;
    
    @Before
    public void setup() {
        
        mvc = MockMvcBuilders.webAppContextSetup(context)
                             .build();
        
    }
    
    // @Test
    // public void getUsers_anonymous() throws Exception {
    //
    //     mvc.perform(get("/users"))
    //        .andExpect(unauthenticated());
    //
    // }
    
    @Test
    public void withHttpBasic() throws Exception {
        
        // mvc.perform(get("/").with(httpBasic("jlong", "dabc125")));
        
        Log.getLogger(this)
           .error("DASFASDFASFDASDFASDFASDF");
        
        mvc.perform(get("/users").header(HttpHeaders.AUTHORIZATION,
                                         "Basic " + Base64Utils.encodeToString("jlong:abc125".getBytes())))
           .andExpect(status().isOk());
        
    }
    
    // @Test
    // public void logoutTest() throws Exception {
    //
    //     mvc.perform(logout())
    //        .andExpect(unauthenticated());
    //
    // }
}
