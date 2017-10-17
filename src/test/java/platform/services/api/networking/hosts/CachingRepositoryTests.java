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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

import platform.services.api.commons.jpa.datasources.DataSourceConfig;

@Test
@Transactional
@SpringBootTest(classes = { DataSourceConfig.class, NetworkHostRepository.class })
public  class CachingRepositoryTests extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired NetworkHostRepository repository;
    @Autowired CacheManager          cacheManager;

    @Test
    public void cachesValuesReturnedForQueryMethod() {

        NetworkHost host = repository.save((NetworkHost) NetworkHost.create().setHostname("host1"));

//        assertThat(repository.findByHostname("host1")).isEqualTo(host);
//
//        // Verify entity cached
//        Cache cache = cacheManager.getCache("byHostname");
//        assertThat(cache.get("host1").get()).isEqualTo(host);
    }
}
