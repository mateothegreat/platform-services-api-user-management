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

import com.streamingplatform.api.users.controllers.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebAppConfiguration
public class UserControllerUnitTest {
    
    private final Logger LOG = LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    private WebApplicationContext context;
    private MockMvc               mvc;
    
    @Before
    public void setup() {
        
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
        //                             .apply(SecurityMockMvcConfigurers.springSecurity()).build();
        
    }
    
    @Test
    public void getUsers_anonymous() throws Exception {
        
        MockHttpServletResponse mvcResult = mvc.perform(get("/users")).andReturn().getResponse();
        
        System.out.print(mvcResult.toString());
        System.out.print(mvcResult.getStatus());
        
        LOG.error(mvcResult.toString());
        LOG.error("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.error("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.error("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.error("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.error("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.error("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.error("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.error("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.error("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.error("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.error("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.error("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.error("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.error("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.error("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.error("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.error("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.error("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.error("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.error("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.error("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.error("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.error("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.error("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.error("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.debug("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.debug("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.debug("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.debug("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.debug("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.debug("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.info("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.info("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.info("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.info("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.info("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.info("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.info("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.info("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.trace("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.trace("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.trace("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.trace("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.trace("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.trace("EEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRRRRRRRR");
        LOG.error(String.valueOf(mvcResult.getStatus()));
        
        //        .andExpect(authenticated());
        
    }
    
    @Test
    
    public void withHttpBasic() throws Exception {
        
        mvc.perform(get("/").with(httpBasic("user", "password")));
        
    }
    
    @Test
    
    public void unathenticatedTest() throws Exception {
        
        mvc.perform(formLogin().password("invalid")).andExpect(unauthenticated());
        
    }
}
