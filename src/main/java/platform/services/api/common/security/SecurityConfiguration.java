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

package platform.services.api.common.security;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

import javax.servlet.http.HttpSessionListener;
import javax.sql.DataSource;

import platform.services.api.common.authentication.AuthenticationEntryPoint;
import platform.services.api.common.sessions.SessionEventListener;
import platform.services.api.users.ApplicationConfig;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity(debug = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
@ComponentScan(basePackages = "platform.services.api.common.authentication")
//@ComponentScan(basePackages = ApplicationConfig.PLATFORM_SERVICES_API)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier(ApplicationConfig.DATA_SOURCE_PLATFORM_BASE_BEAN_NAME)
    private DataSource platformDataSource;

    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;

//    @Autowired
//    public AuthenticationProvider authenticationProvider;

    @Bean
    public static BCryptPasswordEncoder bCryptPasswordEncoder() {

        return new BCryptPasswordEncoder();

    }

    @Bean
    public static ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() {

        return new ServletListenerRegistrationBean<>(new HttpSessionEventPublisher());

    }

    @Bean
    public static HttpSessionListener httpSessionListener() {

        return new SessionEventListener();

    }

    @Bean
    public static HttpSessionStrategy httpSessionStrategy() {

        return new HeaderHttpSessionStrategy();
    }

    @Autowired
    public void configureGlobal(final AuthenticationManagerBuilder auth, final BCryptPasswordEncoder passwordEncoder) throws Exception {

        auth.jdbcAuthentication()
            .dataSource(platformDataSource)
            .usersByUsernameQuery(ApplicationConfig.SELECT_FROM_USER_WHERE_USERNAME)
            .authoritiesByUsernameQuery(ApplicationConfig.SELECT_FROM_USER_ROLES_WHERE_USERNAME)
            .passwordEncoder(passwordEncoder);

//        auth.userDetailsService(authService)

    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {

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

    @Override
    public String toString() {

        return "SecurityConfiguration{" +
                "platformDataSource=" + platformDataSource +
                ", authenticationEntryPoint=" + authenticationEntryPoint +
                '}';
    }
}