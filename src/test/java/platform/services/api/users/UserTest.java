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

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import platform.services.api.commons.enums.Role;
import platform.services.api.commons.security.SecurityCryptor;
import platform.services.api.commons.testing.BaseEntityTest;
import platform.services.api.commons.testing.TestingSpringEntity;
import platform.services.api.commons.utilities.Randomizers;
import platform.services.api.users.profiles.UserProfile;
import platform.services.api.users.roles.UserRole;

import static org.assertj.core.api.Assertions.assertThat;

@TestingSpringEntity
public class UserTest extends BaseEntityTest<User> {

    @BeforeMethod public void beforeEach() {

        baseEntity = UserCompositeGenerator.composedFixtures();

    }

    @Test public void setUsername() {

        baseEntity.setUsername(Randomizers.username());

        getUsername();

    }

    @Test public void getUsername() {

        assertThat(baseEntity.getUsername()).isNotEmpty();

    }

    @Test public void setPassword() {

        baseEntity.setPassword(Randomizers.password());

        getPassword();

    }

    @Test public void getPassword() {

        assertThat(SecurityCryptor.isEncoded(baseEntity.getPassword())).isTrue();

    }

    @Test public void setEmail() {

        baseEntity.setEmail(Randomizers.email());

        getEmail();

    }

    @Test public void getEmail() {

        assertThat(baseEntity.getEmail()).isNotEmpty();

    }

    @Test public void setRoles() {

        baseEntity.getRoles().add(new UserRole().setRole(Role.ROLE_USER));

        getRoles();

    }

    @Test public void getRoles() {

        assertThat(baseEntity.getRoles().size()).isGreaterThanOrEqualTo(1);

    }

    @Test public void setProfiles() {

        baseEntity.getProfiles().add(new UserProfile(Randomizers.avatar()));

        getProfiles();

    }

    @Test public void getProfiles() {

        assertThat(baseEntity.getProfiles().size()).isGreaterThanOrEqualTo(1);

    }

    @Test public void setPasswordNotEncrypted() {

        baseEntity.setPasswordNotEncrypted(Randomizers.password());

        getPasswordNotEncrypted();

    }

    @Test public void getPasswordNotEncrypted() {

        assertThat(baseEntity.getPasswordNotEncrypted()).isNotEmpty();

        assertThat(SecurityCryptor.isEncoded(baseEntity.getPasswordNotEncrypted())).isFalse();

    }

}
