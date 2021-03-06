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
package platform.services.api.users;

import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import platform.services.api.commons.jpa.datasources.DataSourceConfig;
import platform.services.api.organizations.OrganizationService;
import platform.services.api.users.profiles.UserProfileService;
import platform.services.api.users.roles.UserRoleService;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented

@Test
@SpringBootTest(classes = {

        DataSourceConfig.class,

        OrganizationService.class,

        UserAuthIntercept.class,
        UserFactory.class,

        UserService.class,
        UserRoleService.class,
        UserProfileService.class,
        UserAuthIntercept.class

})
public @interface UserFactoryTest {

}
