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
package platform.services.api.users.roles;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import platform.services.api.commons.enums.Role;
import platform.services.api.commons.testing.BaseEntityTest;
import platform.services.api.users.User;

import static org.assertj.core.api.Assertions.assertThat;

public class UserRoleTest extends BaseEntityTest<UserRole> {

    @BeforeMethod public void beforeEach() {

        baseEntity = new UserRole();

        baseEntity.setUser(User.create());

        setRole();

    }

    @Test public void create() {

        final UserRole role = UserRole.create();

        assertThat(role).isNotNull();

        assertThat(role.getRole()).isNotNull();

    }
    @Test
    public void testToString() {

        assertThat(baseEntity.toString()).isNotEmpty();

    }
    @Test
    public void testGetUser() {

        assertThat(baseEntity.getUser()).isNotNull();

    }
    @Test public void setRole() {

//        assertThat(baseEntity.setRole(Role.ROLE_USER)).isNotNull();

        baseEntity.setRole(Role.ROLE_USER);

        assertThat(baseEntity.getRole()).isNotNull();

        getRole();

    }

    @Test public void getRole() {

        assertThat(baseEntity.getRole()).isNotNull();

    }
    @Test public void setUser() {

        baseEntity.setUser(new User());

        assertThat(baseEntity.getUser()).isNotNull();

    }
}
