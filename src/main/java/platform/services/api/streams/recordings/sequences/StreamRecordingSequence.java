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

import com.github.javafaker.Faker;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import platform.services.api.commons.jpa.entities.BaseEntity;
import platform.services.api.commons.utilities.Randomizers;
import platform.services.api.streams.recordings.StreamRecording;

@Entity @Getter
@Table(name = "stream_recording_sequences")
public class StreamRecordingSequence extends BaseEntity<StreamRecordingSequence> {

    private LocalDateTime dateStart;
    private LocalDateTime dateEnd;
    private ZoneOffset    dateOffset;
    private Long          duration;
    private String        filename;
    private String        location;

    @ManyToOne(optional = false)
    @JoinColumn(name = "recordingId")
    private StreamRecording recording;

    public static StreamRecordingSequence create() {

        final StreamRecordingSequence sequence = new StreamRecordingSequence();

        sequence.dateStart = LocalDateTime.now().minusSeconds(60L);
        sequence.dateEnd = LocalDateTime.now();
        sequence.dateOffset = ZoneOffset.UTC;

        sequence.duration = 60L;

        sequence.filename = String.format("%s-%d-%d", Randomizers.uuid(), sequence.dateStart.toEpochSecond(ZoneOffset.UTC), sequence.dateEnd.toEpochSecond(ZoneOffset.UTC));

        sequence.location = new Faker().internet().domainName();

        return sequence;

    }

    public StreamRecordingSequence setDateEnd(final LocalDateTime dateEnd) {

        this.dateEnd = dateEnd;

        return this;

    }
    public StreamRecordingSequence setDateOffset(final ZoneOffset dateOffset) {

        this.dateOffset = dateOffset;

        return this;

    }
    public StreamRecordingSequence setDateStart(final LocalDateTime dateStart) {

        this.dateStart = dateStart;

        return this;

    }
    public StreamRecordingSequence setDuration(final Long duration) {

        this.duration = duration;

        return this;

    }
    public StreamRecordingSequence setFilename(final String filename) {

        this.filename = filename;

        return this;

    }
    public StreamRecordingSequence setLocation(final String location) {

        this.location = location;

        return this;

    }
    public StreamRecordingSequence setRecording(final StreamRecording streamRecording) {

        this.recording = streamRecording;

        return this;

    }

}
