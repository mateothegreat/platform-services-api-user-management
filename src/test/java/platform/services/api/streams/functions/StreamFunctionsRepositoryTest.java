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
package platform.services.api.streams.functions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import platform.services.api.commons.jpa.datasources.DataSourceConfig;
import platform.services.api.commons.testing.BaseRepositoryTest;
import platform.services.api.commons.validation.ValidationError;
import platform.services.api.streams.Stream;
import platform.services.api.streams.StreamFixtureFactory;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {

        DataSourceConfig.class,

        StreamFixtureFactory.class,

        StreamFunctions.class,
        StreamFunctionsRepository.class,
        StreamFunctionsService.class

})
public class StreamFunctionsRepositoryTest extends BaseRepositoryTest<StreamFunctionsRepository, StreamFunction> {

    @Autowired private StreamFunctionsRepository repository;
    @Autowired private StreamFunctionsService    service;
    @Autowired private StreamFixtureFactory      factory;

    @BeforeClass @Test public void beforeClass() {

        setBaseRepository(repository);

    }

    @BeforeMethod @Test
    public void beforeMethod() {

        try {

            final Stream stream = factory.persist();

            service.save(StreamFunction.create()
                                       .setFunction(StreamFunctions.MONITOR)
                                       .setStream(stream));

            setFixture(repository.getById(getFixture().getId()));

            assertThat(getFixture().getUuid()).isNotNull();

        } catch(ValidationError error) {

            error.printStackTrace();

        }

//        functionsRepository.save(StreamFunction.create()
//                                               .setFunction(StreamFunctions.RECORD_ON_TRIGGER).setStream(getFixture()));

    }
}
