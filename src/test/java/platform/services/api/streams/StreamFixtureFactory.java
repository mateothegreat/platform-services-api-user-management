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

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import platform.services.api.networking.hosts.NetworkHostFactory;

import static org.assertj.core.api.Assertions.assertThat;

@Service @Getter @Setter

public class StreamFixtureFactory {

    @Autowired
    private StreamService      service;

    @Autowired
    private NetworkHostFactory networkHostFactory;

    public Stream persist() {

        final Stream stream = service.saveAndGetById(Stream.create()
                                                           .setHost(networkHostFactory.persist()));

        assertThat(stream.getUuid()).isNotNull();
        assertThat(stream.getHost()).isNotNull();

        return stream;

    }

}
