

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

package platform.api;

/*-
 * $$SoftwareLicense
 * Streaming Platform Users API
 * %%
 * Copyright (C) 2017 streamnvr
 * %%
 * __
 *       /\ \__
 *   ____\ \ ,_\  _ __    __     __      ___ ___     ___   __  __   _ __
 *  /',__\\ \ \/ /\`'__\/'__`\ /'__`\  /' __` __`\ /' _ `\/\ \/\ \ /\`'__\
 * /\__, `\\ \ \_\ \ \//\  __//\ \L\.\_/\ \/\ \/\ \/\ \/\ \ \ \_/ |\ \ \/
 * \/\____/ \ \__\\ \_\\ \____\ \__/.\_\ \_\ \_\ \_\ \_\ \_\ \___/  \ \_\
 *  \/___/   \/__/ \/_/ \/____/\/__/\/_/\/_/\/_/\/_/\/_/\/_/\/__/    \/_/
 * 
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * streaming-platform.com
 */

import com.streamingplatform.api.authentication.*;
import com.streamingplatform.api.sessions.*;
import org.apache.logging.log4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.autoconfigure.security.*;
import org.springframework.boot.web.servlet.*;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.*;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.method.configuration.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.session.*;
import org.springframework.session.web.http.*;
import platform.api.authentication.*;
import platform.api.sessions.*;

import javax.annotation.*;
import javax.servlet.http.*;
import javax.sql.*;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity(debug = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
@ComponentScan(basePackages = "com.streamingplatform")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    
    private static final Logger log = LogManager.getLogger(SecurityConfiguration.class);
    private AuthenticationProvider authenticationProvider;
    
    @Qualifier("platformBaseDataSource")
    @Autowired
    private DataSource platformDataSource;
    
    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;
    
    @Resource(name = "authenticationService")
    private AuthenticationService authenticationService;


    @Bean
    public static ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() {
        
        return new ServletListenerRegistrationBean<>(new HttpSessionEventPublisher());
        
    }
    
    @Bean
    public BCryptPasswordEncoder bcryptEncoder() {
        
        return new BCryptPasswordEncoder();
        
    }
    
    @Bean
    public HttpSessionListener httpSessionListener() {
        
        return new SessionEventListener();
        
    }
    
    @Bean
    public HttpSessionStrategy httpSessionStrategy() {
        
        return new HeaderHttpSessionStrategy();
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, AuthenticationService authenticationService,
                                BCryptPasswordEncoder bCryptPasswordEncoder) throws Exception {
        
        // auth.inMemoryAuthentication()
        //     .withUser("user")
        //     .password("password")
        //     .roles("USER");
        
        auth.jdbcAuthentication()
            .dataSource(platformDataSource)
            .usersByUsernameQuery("select username,password, status from user where username=?")
            .authoritiesByUsernameQuery("select username, role from user_roles where username=?");
        auth.userDetailsService(authenticationService)
            .passwordEncoder(bCryptPasswordEncoder);
        
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http.authorizeRequests()
            .anyRequest()
            .authenticated();
        
        // http.requestCache()
        //     .requestCache(new NullRequestCache());
        
        http.httpBasic()
            .authenticationEntryPoint(authenticationEntryPoint);
        
        http.logout()
            .disable();
        
        http.csrf()
            .disable();
        
        http.formLogin()
            .disable();
        
        http.anonymous()
            .disable();
        
    }
    
}
