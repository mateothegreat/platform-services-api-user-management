

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

package com.streamingplatform.api.security.config;

import com.streamingplatform.api.security.services.AuthenticationService;
import com.streamingplatform.api.sessions.SessionEventListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

import javax.annotation.Resource;
import javax.servlet.http.HttpSessionListener;
import javax.sql.DataSource;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity(debug = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
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
