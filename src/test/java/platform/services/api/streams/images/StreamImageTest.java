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
package platform.services.api.streams.images;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

import platform.services.api.commons.testing.BaseEntityTest;
import platform.services.api.streams.recordings.sequences.images.SequenceImage;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamImageTest extends BaseEntityTest<StreamImage> {

    @Test @BeforeMethod public void beforeEach() {

        baseEntity = StreamImage.create();

        assertThat(SequenceImage.create()).isNotNull();

    }

    @Test public void testCreate() {

        assertThat(StreamImage.create()).isNotNull();

    }
    @Test public void testSetDateCreated() {

        assertThat(baseEntity.setDateCreated(LocalDateTime.now()).getDateCreated()).isNotNull();

    }
    @Test public void testSetDateRelative() {

        assertThat(baseEntity.setDateRelative(LocalDateTime.now()).getDateRelative()).isNotNull();

    }
    @Test public void testSetDescription() {

        assertThat(baseEntity.setDescription("test").getDescription()).isNotNull();

    }
    @Test public void testSetDuration() {

        assertThat(baseEntity.setDuration(1).getDuration()).isNotNull();

    }
    @Test public void testSetImageFormat() {

        assertThat(baseEntity.setImageFormat(StreamImageFormat.JPG.toString()).getImageFormat()).isNotNull();

    }
    @Test public void testSetImageQuality() {

        assertThat(baseEntity.setImageQuality(1).getImageQuality()).isNotNull();

    }
    @Test public void testSetResolutionHeight() {

        assertThat(baseEntity.setResolutionHeight(1).getResolutionHeight()).isNotNull();

    }
    @Test public void testSetResolutionWidth() {

        assertThat(baseEntity.setResolutionWidth(1).getResolutionWidth()).isNotNull();

    }
    @Test public void testSetTitle() {

        assertThat(baseEntity.setTitle("test").getTitle()).isNotNull();

    }

}
