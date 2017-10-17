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

import platform.services.api.commons.enums.Status;
import platform.services.api.commons.jpa.entities.BaseEntity;
import platform.services.api.commons.utilities.Randomizers;

public class UserFixtureFactory {

    public static BaseEntity<User> createFixture() {

        return new User().setUsername(Randomizers.username())
                         .setPasswordNotEncrypted(Randomizers.password())
                         .setEmail(Randomizers.email())
//                         .setParentId(Randomizers.id())
                         .setStatus(Status.ACTIVE_TESTING);
//
//        fixture.addRole(new UserRole(Role.ROLE_ADMIN));
//        fixture.addRole(new UserRole(Role.ROLE_USER));
//
//        fixture.addProfile(new UserProfile(Randomizers.avatar()));
//        fixture.addProfile(new UserProfile(Randomizers.avatar()));

    }
}
