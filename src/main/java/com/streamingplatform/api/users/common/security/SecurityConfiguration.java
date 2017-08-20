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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    
    private final Logger LOG = LoggerFactory.getLogger(SecurityConfiguration.class);
    
    private final DataSource platformBaseDataSource;
    
    @Autowired
    public SecurityConfiguration(final javax.sql.DataSource platformBaseDataSource) {
        
        this.platformBaseDataSource = platformBaseDataSource;
        
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        
        LOG.trace("configure(AuthenticationManagerBuilder auth)");
        
        //            .authoritiesByUsernameQuery(rolesQuery)
        auth.jdbcAuthentication()
            .dataSource(platformBaseDataSource)
            .passwordEncoder(new BCryptPasswordEncoder())
            .usersByUsernameQuery("select username,password,1 from user where username=?");
        
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        
        LOG.trace("configure(WebSecurity web)");
        
        web.ignoring()
           .antMatchers("/resources/**");
        
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        LOG.trace("configure(HttpSecurity http)");
        
        // http.authorizeRequests()
        //     .antMatchers("/")
        //     .permitAll()
        //     .antMatchers("/login")
        //     .permitAll()
        //     .antMatchers("/registration")
        //     .permitAll()
        //     .antMatchers("/admin/**")
        //     .hasAuthority("ADMIN")
        //     .anyRequest()
        //     .authenticated()
        //     .and()
        //     .csrf()
        //     .disable()
        //     .formLogin()
        //     .loginPage("/login")
        //     .failureUrl("/login?error=true")
        //     .defaultSuccessUrl("/admin/home")
        //     .usernameParameter("username")
        //     .passwordParameter("password")
        //     .and()
        //     .logout()
        //     .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        //     .logoutSuccessUrl("/")
        //     .and()
        //     .exceptionHandling()
        //     .accessDeniedPage("/access-denied");
        
        http.authorizeRequests()
            .antMatchers("/login")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic()
            .and()
            .logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .and()
            .csrf()
            .disable()
            .exceptionHandling();
        
        //        http.authorizeRequests()
        //            .antMatchers("/public").permitAll()
        //            .anyRequest().authenticated()
        //            .and()
        //            .formLogin()
        //            .permitAll()
        //            .and()
        //            .logout()
        //            .permitAll();
        
    }
    
}
