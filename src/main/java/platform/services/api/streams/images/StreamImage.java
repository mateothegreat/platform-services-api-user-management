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
