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

package platform.platform.api.users;

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

import platform.services.api.common.utilities.Tracing;
import platform.services.api.users.ApplicationConfig;
import platform.services.api.users.jpa.User;

@Configuration
@EnableJpaRepositories(basePackages = { ApplicationConfig.PLATFORM_SERVICES_API_USERS_JPA })
@ComponentScan({ ApplicationConfig.PLATFORM_SERVICES_API_COMMON, ApplicationConfig.PLATFORM_SERVICES_API_USERS, })
public class UserConfig {

    public static final Long USER_VALID_ID        = null;
    public static final Long USER_VALID_PARENT_ID = 1L;

    public static final Long USER_VALID_STATUS = 1L;
    ;

    public static final String USER_VALID_EMAIL            = "test-user1@test-user1.com";
    public static final String USER_VALID_USERNAME         = "test-user1";
    public static final String USER_VALID_PASSWORD         = "test-password";
    public static final String USER_VALID_PASSWORD_ENCODED = "$2a$10$atc5W7EVviaucgev1/LgWu3fIcOH0S9dYPzX0cUgYQE6fHIshL4.q";
    public static final Long   USER_INVALID_ID             = 0L;
    public static final Long   USER_INVALID_PARENT_ID      = -1L;
    public static final int    USER_INVALID_STATUS         = -1;
    public static final String USER_INVALID_EMAIL          = "invalid@invalid.com";
    public static final String USER_INVALID_USERNAME       = "invalid";
    public static final String USER_INVALID_PASSWORD       = "invalid";

    public UserConfig() {

        Tracing.trace("TestingConfig: ");

    }

    public static User buildUser() {

        final User user = new User();

//        user.setId(USER_VALID_ID);
        user.setParentId(USER_VALID_PARENT_ID);
        user.setStatus(USER_VALID_STATUS);
        user.setEmail(USER_VALID_EMAIL);
        user.setUsername(USER_VALID_USERNAME);
        user.setPassword(USER_VALID_PASSWORD);

        return user;

    }

    public static User buildRandomized() {

//        RandomStringUtils
//        User user = new User();

        return null;

    }

}
