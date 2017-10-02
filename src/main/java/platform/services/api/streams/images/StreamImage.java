package platform.services.api.streams.images;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.time.LocalDateTime;

import platform.services.api.commons.jpa.entities.BaseEntity;
import platform.services.api.streams.StreamResolution;
import platform.services.api.streams.recordings.StreamRecording;

@Entity @Data
@Table(name = "streamimages")
public class StreamImage extends BaseEntity<StreamImage> {

    @ManyToOne
    @JoinColumn(name = "recordingId")
    private StreamRecording recording;

    private LocalDateTime      dateCreated;
    private LocalDateTime      dateRelative;
    private int                duration;
    private StreamImageFormats imageFormat;
    private int                resolutionWidth;
    private int                resolutionHeight;
    private String             title;
    private String             description;

    public static StreamImage create() {

        final StreamImage fixture = new StreamImage();

        fixture.setDateCreated(LocalDateTime.now().minusSeconds(60L));
        fixture.setDateRelative(LocalDateTime.now());
        fixture.setDuration(2);

        fixture.setImageFormat(StreamImageFormats.JPG);

        fixture.resolutionWidth = StreamResolution.PROFILE_1920x1080.getWidth();
        fixture.resolutionHeight = StreamResolution.PROFILE_1920x1080.getHeight();

        return fixture;

    }

}
