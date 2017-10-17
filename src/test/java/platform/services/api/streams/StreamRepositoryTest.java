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
package platform.services.api.streams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import platform.services.api.commons.jpa.datasources.DataSourceConfig;
import platform.services.api.commons.testing.BaseRepositoryTest;

@SpringBootTest(classes = { DataSourceConfig.class, StreamRepository.class })
public class StreamRepositoryTest extends BaseRepositoryTest<StreamRepository, Stream> {

    @Autowired
    private StreamRepository repository;

//
//    @Autowired
//    private StreamFixtureFactory factory;

    @BeforeClass
    public void beforeClass() {

        setFn(Stream::create);
        setBaseRepository(repository);

    }

    @BeforeMethod @Test

    public void beforeMethod() {

//        setFixture(factory.persist());
//
//        try {
//
//            setFixture(repository.getById(getFixture().getId()));
//
//            assertThat(getFixture().getFunctions().size()).isEqualTo(2);
//
//        } catch(ValidationError error) {
//
//            error.printStackTrace();
//
//        }

//        functionsRepository.save(StreamFunction.create()
//                                               .setFunction(StreamFunctions.RECORD_ON_TRIGGER).setStream(getFixture()));

    }

}
