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
package platform.services.api.streams.recordings;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import platform.services.api.commons.jpa.entities.BaseEntity;
import platform.services.api.streams.Stream;
import platform.services.api.streams.StreamResolution;
import platform.services.api.streams.recordings.sequences.StreamRecordingSequence;

@Entity @Getter
@Table(name = "stream_recordings")
public class StreamRecording extends BaseEntity<StreamRecording> {

    private LocalDateTime dateStart;
    private LocalDateTime dateEnd;
    private Long          duration;
    private int           segmentLength;
    private int           resolutionWidth;
    private int           resolutionHeight;
    private int           bitrate;
    private int           bitrateAverage;
    private int           bitrateMax;
    private int           crf;
    private StreamFPS     fps;
    private StreamCodec   codec;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "streamId")
    @JsonIgnore
    private Stream stream;

    @JsonIgnore
    @OneToMany(mappedBy = "recording", fetch = FetchType.EAGER)
    private Set<StreamRecordingSequence> sequences = new HashSet<>(0);

    public static StreamRecording create() {

        final StreamRecording fixture = new StreamRecording();

        fixture.setDateStart(LocalDateTime.now().minusSeconds(60L));
        fixture.setDateEnd(LocalDateTime.now());
        fixture.setDuration(60L);

        fixture.resolutionWidth = StreamResolution.PROFILE_1920x1080.getWidth();
        fixture.resolutionHeight = StreamResolution.PROFILE_1920x1080.getHeight();

        fixture.bitrate = 1200;
        fixture.bitrateAverage = 1200;
        fixture.bitrateMax = 1200;

        fixture.crf = 15;
        fixture.fps = StreamFPS.FPS_15;
        fixture.codec = StreamCodec.H264;

        return fixture;

    }
    public LocalDateTime getDateEnd() {

        return dateEnd;
    }
    public LocalDateTime getDateStart() {

        return dateStart;

    }
    public Long getDuration() {

        return duration;
    }
    public Set<StreamRecordingSequence> getSequences() {

        return sequences;

    }
    public Stream getStream() {

        return stream;
    }
    public StreamRecording setDateEnd(final LocalDateTime dateEnd) {

        this.dateEnd = dateEnd;
        return this;
    }
    public StreamRecording setDateStart(final LocalDateTime dateStart) {

        this.dateStart = dateStart;

        return this;

    }
    public StreamRecording setDuration(final Long duration) {

        this.duration = duration;
        return this;
    }
    public StreamRecording setSequences(final Set<StreamRecordingSequence> sequences) {

        this.sequences = sequences;

        return this;

    }
    public StreamRecording setStream(final Stream stream) {

        this.stream = stream;

        return this;

    }

}
