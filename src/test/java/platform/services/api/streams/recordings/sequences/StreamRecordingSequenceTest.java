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
package platform.services.api.streams.recordings.sequences;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import platform.services.api.commons.testing.BaseEntityTest;
import platform.services.api.commons.utilities.Randomizers;
import platform.services.api.streams.recordings.StreamRecording;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamRecordingSequenceTest extends BaseEntityTest<StreamRecordingSequence> {

    @BeforeClass public void beforeEach() {

        baseEntity = StreamRecordingSequence.create();

    }

    @Test public void testCreate() {

        assertThat(StreamRecordingSequence.create()).isNotNull();

    }
    @Test public void testSetLocation() {

        assertThat(baseEntity.setLocation("test").getLocation()).isNotNull();

    }
    @Test public void testSetDateEnd() {

        assertThat(baseEntity.setDateEnd(LocalDateTime.now()).getDateEnd()).isNotNull();

    }
    @Test public void testSetDateOffset() {

        assertThat(baseEntity.setDateOffset(ZoneOffset.UTC).getDateOffset()).isNotNull();

    }
    @Test public void testSetDateStart() {

        assertThat(baseEntity.setDateStart(LocalDateTime.now()).getDateStart()).isNotNull();

    }
    @Test public void testSetDuration() {

        assertThat(baseEntity.setDuration(1L).getDuration()).isNotZero();

    }
    @Test public void testSetFilename() {

        baseEntity.setFilename(Randomizers.username());

        assertThat(baseEntity.setFilename(Randomizers.username()).getFilename()).isNotNull();

    }
    @Test public void testSetRecording() {

        assertThat(baseEntity.setRecording(StreamRecording.create()).getRecording()).isNotNull();

    }

}
