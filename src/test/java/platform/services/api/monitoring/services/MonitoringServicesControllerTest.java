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
package platform.services.api.monitoring.services;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.mvc.TypeReferences.PagedResourcesType;
import org.testng.annotations.BeforeClass;

import platform.services.api.commons.testing.BaseControllerTest;
import platform.services.api.networking.hosts.NetworkHost;

@SpringBootTest
public class MonitoringServicesControllerTest extends BaseControllerTest<MonitoringService> {

    @BeforeClass
    public void beforeClass() {

        getRest().setTypeReference(new PagedResourcesType<NetworkHost>() {

        });

        super.beforeClass(MonitoringServicesController.PATH_BASE, MonitoringService.class, MonitoringService::create);

    }

}
