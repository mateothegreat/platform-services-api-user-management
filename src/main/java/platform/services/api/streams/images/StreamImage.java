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

import lombok.Getter;

import javax.persistence.MappedSuperclass;

import java.time.LocalDateTime;

import platform.services.api.commons.jpa.entities.BaseEntity;

@MappedSuperclass @Getter
public class StreamImage<E extends BaseEntity> extends BaseEntity<E> {

    private LocalDateTime dateCreated;
    private LocalDateTime dateRelative;
    private int           duration;
    private String        imageFormat;
    private int           imageQuality;
    private int           resolutionWidth;
    private int           resolutionHeight;
    private String        title;
    private String        description;

    public static StreamImage create() {

        final StreamImage fixture = new StreamImage();

        fixture.setDateCreated(LocalDateTime.now().minusSeconds(60L));
        fixture.setDateRelative(LocalDateTime.now());
        fixture.setDuration(2);

        fixture.setImageFormat(StreamImagePreset.HD.getFormat().getFormat());
        fixture.setImageQuality(StreamImagePreset.HD.getFormat().getQuality());
        fixture.setResolutionHeight(StreamImagePreset.HD.getResolution().getHeight());
        fixture.setResolutionWidth(StreamImagePreset.HD.getResolution().getWidth());

        return fixture;

    }

    public StreamImage setDateCreated(final LocalDateTime dateCreated) {

        this.dateCreated = dateCreated;

        return this;

    }
    public StreamImage setDateRelative(final LocalDateTime dateRelative) {

        this.dateRelative = dateRelative;

        return this;

    }
    public StreamImage setDescription(final String description) {

        this.description = description;

        return this;

    }
    public StreamImage setDuration(final int duration) {

        this.duration = duration;

        return this;

    }
    public StreamImage setImageFormat(final String imageFormat) {

        this.imageFormat = imageFormat;

        return this;

    }
    public StreamImage setImageQuality(final int imageQuality) {

        this.imageQuality = imageQuality;

        return this;

    }
    public StreamImage setResolutionHeight(final int resolutionHeight) {

        this.resolutionHeight = resolutionHeight;

        return this;

    }
    public StreamImage setResolutionWidth(final int resolutionWidth) {

        this.resolutionWidth = resolutionWidth;

        return this;

    }
    public StreamImage setTitle(final String title) {

        this.title = title;

        return this;

    }

}
