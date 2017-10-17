/**
 * ====
 *     Copyright 2017 Pivotal Software, Inc.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 * ====
 *
 * Copyright 2017 Pivotal Software, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package platform.services.api;

import org.springframework.context.annotation.Configuration;

@SuppressWarnings("StringConcatenation")

@Configuration
//@ComponentScan(basePackages = {
//
//        UsersConfig.PLATFORM_SERVICES_API_USERS,
//        UsersConfig.PLATFORM_SERVICES_API_USERS_AUTHENTICATION,
//        UsersConfig.PLATFORM_SERVICES_API_COMMONS
//
//})
public class UsersConfig {

    public static final String PLATFORM_SERVICES_API_COMMONS              = "platform.services.api.commons";
    public static final String PLATFORM_SERVICES_API_USERS_AUTHENTICATION = "platform.services.api.users.authentication";
    public static final String PLATFORM_SERVICES_API_USERS                = "platform.services.api.users";
    public static final String PLATFORM_SERVICES_API_STREAMS              = "platform.services.api.streams.streams";

    public static final String REQUEST_PATH                 = "/users";
    public static final String REQUEST_PATH_SETTINGS        = REQUEST_PATH + "/{userId:^[0-9]+$}/settings";
    public static final String REQUEST_PATH_SETTINGS_ENTITY = REQUEST_PATH_SETTINGS + "/{settingId:^[0-9]+$}";

    public static final String TESTING_USERNAME = "test";
    public static final String TESTING_PASSWORD = "asdfasdf";
}
