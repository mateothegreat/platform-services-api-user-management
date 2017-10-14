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

package platform.services.api.users.authentication;

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
 * streaming-main.platform.com
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

import platform.services.api.commons.configuration.CommonsConfig;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
@ComponentScan(basePackages = {

        CommonsConfig.PLATFORM_SERVICES_API_COMMONS_JPA_DATASOURCES,
        CommonsConfig.PLATFORM_SERVICES_API_USERS_AUTHENTICATION

})
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final DataSource                       platformDataSource;
    private final AuthenticationEntryPoint         authenticationEntryPoint;
    private final UserAuthenticationDetailsService userAuthenticationDetailsService;

    @Autowired public SecurityConfiguration(final  DataSource platformDataSource,
                                            final AuthenticationEntryPoint authenticationEntryPoint,
                                            final UserAuthenticationDetailsService userAuthenticationDetailsService) {

        this.platformDataSource = platformDataSource;
        this.authenticationEntryPoint = authenticationEntryPoint;
        this.userAuthenticationDetailsService = userAuthenticationDetailsService;

    }

//    @Bean public static ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() {
//
//        return new ServletListenerRegistrationBean<>(new HttpSessionEventPublisher());
//
//    }
//    @Bean public static HttpSessionListener httpSessionListener() {
//
//        return new HttpSessionEventListener();
//
//    }
//    @Bean public static HttpSessionStrategy httpSessionStrategy() {
//
//        return new HeaderHttpSessionStrategy();
//    }

    @Bean public DaoAuthenticationProvider authenticationProvider() {

        final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setForcePrincipalAsString(true);
        authProvider.setUserDetailsService(userAuthenticationDetailsService);
        authProvider.setPasswordEncoder(encoder());

        return authProvider;

    }

    @Autowired public void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication()
            .dataSource(platformDataSource)
            .usersByUsernameQuery(CommonsConfig.SELECT_FROM_USER_WHERE_USERNAME)
            .authoritiesByUsernameQuery(CommonsConfig.SELECT_FROM_USER_ROLES_WHERE_USERNAME)
            .passwordEncoder(encoder());

        auth.authenticationProvider(authenticationProvider());

        auth.userDetailsService(userAuthenticationDetailsService);

    }

    @Bean public PasswordEncoder encoder() {

        return new BCryptPasswordEncoder(11);
    }
//
//    @Bean public AuthenticationProvider runAsAuthenticationProvider() {
//
//        final RunAsImplAuthenticationProvider authProvider = new RunAsImplAuthenticationProvider();
//
//        authProvider.setKey("ROLE_INTEGRATION");
//
//        return authProvider;
//
//    }

    @Override protected void configure(final HttpSecurity http) throws Exception {

        http.authorizeRequests()
            .anyRequest()
            .authenticated();

        http.authenticationProvider(authenticationProvider())
            .httpBasic()
            .authenticationEntryPoint(authenticationEntryPoint);

        http.authorizeRequests()
            .antMatchers("/favicon.ico", "/browser/**")
            .anonymous();

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.logout()
            .disable();

        http.csrf()
            .disable();

        http.formLogin()
            .disable();

        http.anonymous()
            .disable();

/*        http.authorizeRequests()
            .anyRequest()
            .anonymous();*/

    }

}
