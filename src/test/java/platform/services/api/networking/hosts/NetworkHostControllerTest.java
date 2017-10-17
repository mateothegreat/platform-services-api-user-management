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
package platform.services.api.networking.hosts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.mvc.TypeReferences.PagedResourcesType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.BeforeClass;

import platform.services.api.commons.configuration.Profiles.ProfileType;
import platform.services.api.commons.jpa.datasources.DataSourceConfig;
import platform.services.api.commons.testing.BaseControllerTest;
import platform.services.api.users.UserAuthIntercept;
import platform.services.api.users.UserFactoryTest;

@UserFactoryTest
@NetworkHostFactorySetup

@ContextConfiguration(classes = {

        DataSourceConfig.class,

        NetworkHostFactory.class,
        UserAuthIntercept.class,
        NetworkHostRepository.class,
        NetworkHostService.class,

})
@ActiveProfiles({ ProfileType.TESTING_LEAN })
public class NetworkHostControllerTest extends BaseControllerTest<NetworkHost> {

    @Autowired private UserAuthIntercept  userAuthIntercept;
    @Autowired private NetworkHostFactory networkHostFactory;

    @BeforeClass public void beforeClass() {

        getRest().setTypeReference(new PagedResourcesType<NetworkHost>() {

        });

        super.beforeClass(NetworkHostController.PATH_BASE, NetworkHost.class, NetworkHost::create);

    }

}
