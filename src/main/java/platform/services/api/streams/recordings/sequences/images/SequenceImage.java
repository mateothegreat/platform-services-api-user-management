package platform.services.api.streams.recordings.sequences.images;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.time.LocalDateTime;

import platform.services.api.streams.images.StreamImage;
import platform.services.api.streams.images.StreamImagePreset;
import platform.services.api.streams.recordings.sequences.StreamRecordingSequence;

@Entity
@Table(name = "stream_recording_sequence_images")
public class SequenceImage extends StreamImage<SequenceImage> {

    @ManyToOne(optional = false)
    @JoinColumn(name = "recordingId")
    private StreamRecordingSequence sequence;

    public static SequenceImage create() {

        final SequenceImage fixture = new SequenceImage();

        fixture.setDateCreated(LocalDateTime.now().minusSeconds(60L));
        fixture.setDateRelative(LocalDateTime.now());
        fixture.setDuration(2);

        fixture.setImageFormat(StreamImagePreset.HD.getFormat().getFormat());
        fixture.setImageQuality(StreamImagePreset.HD.getFormat().getQuality());
        fixture.setResolutionHeight(StreamImagePreset.HD.getResolution().getHeight());
        fixture.setResolutionWidth(StreamImagePreset.HD.getResolution().getWidth());

        return fixture;

    }

}