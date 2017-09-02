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

package platform.platform.api.users.services;

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

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import platform.services.api.common.utilities.Tracing;
import platform.services.api.users.ApplicationConfig;

//@Profile("test")
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { ApplicationConfig.PLATFORM_SERVICES_API_USERS_JPA })
//@EnableJpaRepositories({ "platform.services.api.*", "platform.services.api.common.jpa.repositories", "platform.services.api.users.jpa", })
//@EntityScan(basePackages = { ApplicationConfig.PLATFORM_SERVICES_API_USERS_JPA, })
//@AutoConfigureTestEntityManager
@ComponentScan({ ApplicationConfig.PLATFORM_SERVICES_API_COMMON, ApplicationConfig.PLATFORM_SERVICES_API_USERS, })
public class TestingConfig {

    public static final String USER_VALID_USERNAME   = "test-user1";
    public static final String USER_VALID_PASSWORD   = "test-password";
    public static final String USER_VALID_EMAIL      = "test-user1@test-user1.com";
    public static final String USER_INVALID_USERNAME = "invalid";
    public static final String USER_INVALID_PASSWORD = "invalid";
    public static final String USER_INVALID_EMAIL    = "invalid@invalid.com";

    //    private UserRepository userRepository;
//    private UserService    userService;

    public TestingConfig() {

        Tracing.trace("TestingConfig: ");
    }
//    public TestingConfig(final UserRepository userRepository, final UserService userService) {
//
//        this.userRepository = userRepository;
//        this.userService = userService;
//
//    }
}
