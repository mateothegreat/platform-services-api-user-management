package platform.services.api.streams.recordings.sequences;

import com.github.javafaker.Faker;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import platform.services.api.commons.jpa.entities.BaseEntity;
import platform.services.api.commons.testing.Randomizers;
import platform.services.api.streams.recordings.StreamRecording;

@Entity
//@Data @ToString
@Table(name = "stream_recording_sequences")
public class StreamRecordingSequence extends BaseEntity<StreamRecordingSequence> {

    private LocalDateTime dateStart;
    private LocalDateTime dateEnd;
    private ZoneOffset    dateOffset;

    private Long   duration;
    private String filename;
    private String location;

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

    public LocalDateTime getDateStart() {

        return dateStart;
    }

    public StreamRecordingSequence setDateStart(final LocalDateTime dateStart) {

        this.dateStart = dateStart;
        return this;
    }

    public LocalDateTime getDateEnd() {

        return dateEnd;
    }

    public StreamRecordingSequence setDateEnd(final LocalDateTime dateEnd) {

        this.dateEnd = dateEnd;
        return this;
    }

    public ZoneOffset getDateOffset() {

        return dateOffset;
    }

    public StreamRecordingSequence setDateOffset(final ZoneOffset dateOffset) {

        this.dateOffset = dateOffset;
        return this;
    }

    public Long getDuration() {

        return duration;
    }

    public StreamRecordingSequence setDuration(final Long duration) {

        this.duration = duration;
        return this;
    }

    public String getFilename() {

        return filename;
    }

    public StreamRecordingSequence setFilename(final String filename) {

        this.filename = filename;
        return this;
    }

    public StreamRecording getRecording() {

        return recording;
    }

    public StreamRecordingSequence setRecording(final StreamRecording streamRecording) {

        this.recording = streamRecording;

        return this;

    }
}
