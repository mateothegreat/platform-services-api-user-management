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

package com.streamingplatform.api.users.common.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
// @EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    private static final String LOGIN_PATH = "/login";
    
    @Autowired
    private CustomUserDetailsService     userDetailsService;
    @Autowired
    private HttpAuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private AuthSuccessHandler           authSuccessHandler;
    @Autowired
    private AuthFailureHandler           authFailureHandler;
    @Autowired
    private HttpLogoutSuccessHandler     logoutSuccessHandler;
    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        
        return super.authenticationManagerBean();
        
    }
    
    @Bean
    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        
        return super.userDetailsServiceBean();
    }
    
    @Bean
    public AuthenticationProvider authenticationProvider() {
        
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        
        return authenticationProvider;
        
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        
        auth.authenticationProvider(authenticationProvider());
        
    }
    
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        
        return super.authenticationManager();
        
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http.csrf()
            .disable()
            .authorizeRequests()
            .antMatchers("/")
            .permitAll()
            .antMatchers("/MyProject/*")
            .permitAll()
            .antMatchers("/favicon.ico")
            .permitAll()
            .antMatchers("/index.html")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .authenticationProvider(authenticationProvider())
            .exceptionHandling()
            .authenticationEntryPoint(authenticationEntryPoint)
            .and()
            .formLogin()
            .permitAll()
            .loginProcessingUrl(LOGIN_PATH)
            .usernameParameter("username")
            .passwordParameter("password")
            .successHandler(authSuccessHandler)
            .failureHandler(authFailureHandler)
            .and()
            .logout()
            .permitAll()
            .logoutRequestMatcher(new AntPathRequestMatcher(LOGIN_PATH, "DELETE"))
            .logoutSuccessHandler(logoutSuccessHandler)
            .and()
            .sessionManagement()
            .maximumSessions(1);
        
        http.authorizeRequests()
            .anyRequest()
            .authenticated();
        
    }
    
}
