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

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import platform.services.api.commons.testing.BaseRepositoryTest;
import platform.services.api.users.UserFactory;
import platform.services.api.users.UserFactorySetup;
import platform.services.api.users.UserService;

@UserFactorySetup
public class UserRoleRepositoryTest extends BaseRepositoryTest<UserRoleRepository, UserRole> {

    @Autowired private UserRoleRepository repository;
    @Autowired private UserService        parentService;
    @Autowired private UserFactory        userFactory;

    @BeforeClass public void beforeClass() {

        setFn(UserRole::create);
        setBaseRepository(repository);

    }
    @BeforeMethod @Test public void beforeMethod() {

        persistFixture(UserRole.create()
                               .setUser(userFactory.persistNewUser()));

    }

}
