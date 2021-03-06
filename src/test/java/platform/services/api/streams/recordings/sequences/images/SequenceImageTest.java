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
package platform.services.api.streams.recordings.sequences.images;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import platform.services.api.commons.testing.BaseEntityTest;
import platform.services.api.streams.recordings.sequences.StreamRecordingSequence;

import static org.assertj.core.api.Assertions.assertThat;

public class SequenceImageTest extends BaseEntityTest<SequenceImage> {

    @Test @BeforeMethod public void beforeEach() {

        baseEntity = SequenceImage.create();

        assertThat(SequenceImage.create()).isNotNull();

    }

    @Test public void testCreate() {

        assertThat(SequenceImage.create()).isNotNull();

    }
    @Test public void testSetSequence() {

        assertThat(baseEntity.setSequence(StreamRecordingSequence.create()).getSequence()).isNotNull();

    }

}
