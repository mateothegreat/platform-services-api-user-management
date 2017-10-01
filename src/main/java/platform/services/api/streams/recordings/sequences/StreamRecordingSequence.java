package platform.services.api.streams.recordings.sequences;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import platform.services.api.commons.jpa.entities.BaseEntity;
import platform.services.api.commons.testing.Randomizers;
import platform.services.api.streams.recordings.StreamRecording;

@Entity @Data @ToString
@Table(name = "stream_recording_sequences")
public class StreamRecordingSequence extends BaseEntity<StreamRecordingSequence> {

    private LocalDateTime dateStart;
    private LocalDateTime dateEnd;
    private ZoneOffset    dateOffset;

    private Long   duration;
    private String filename;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "parentId")
    private StreamRecording recording;

    public static StreamRecordingSequence create() {

        final StreamRecordingSequence sequence = new StreamRecordingSequence();

        sequence.dateStart = LocalDateTime.now().minusSeconds(60L);
        sequence.dateEnd = LocalDateTime.now();
        sequence.dateOffset = ZoneOffset.UTC;

        sequence.duration = 60L;

        sequence.filename = String.format("%s-%d-%d", Randomizers.uuid(), sequence.dateStart.toEpochSecond(ZoneOffset.UTC), sequence.dateEnd.toEpochSecond(ZoneOffset.UTC));

        return sequence;

    }

}
