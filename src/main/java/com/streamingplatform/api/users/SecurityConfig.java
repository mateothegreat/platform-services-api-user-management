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

import com.streamingplatform.api.users.common.security.CustomUserDetailsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    private static final Logger log = LogManager.getLogger(SecurityConfig.class);
    private AuthenticationProvider authenticationProvider;
    
    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;
    
    @Resource(name = "customUserDetailsService")
    private CustomUserDetailsService customUserDetailsService;
    
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(BCryptPasswordEncoder bCryptPasswordEncoder,
                                                               CustomUserDetailsService customUserDetailsService) {
        
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        
        daoAuthenticationProvider.setUserDetailsService(customUserDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder);
        
        log.trace("daoAuthenticationProvider");
        
        return daoAuthenticationProvider;
        
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        log.trace("configure");
        
        http.authorizeRequests()
            .anyRequest()
            .authenticated();
        
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
    
    @Autowired
    @Qualifier("daoAuthenticationProvider")
    public void setAuthenticationProvider(AuthenticationProvider authenticationProvider) {
        
        log.trace("setAuthenticationProvider: " + authenticationProvider.getClass()
                                                                        .getName());
        
        this.authenticationProvider = authenticationProvider;
        
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        
        auth.authenticationProvider(authenticationProvider);
        auth.userDetailsService(customUserDetailsService);
        
    }
    
}
