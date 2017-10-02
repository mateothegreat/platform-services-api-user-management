package platform.services.api.streams.images;

import platform.services.api.streams.StreamResolution;

public enum StreamImagePreset {

    HD(StreamImageFormat.JPG, StreamResolution.PROFILE_1920x1080);

    private final StreamImageFormat format;
    private final StreamResolution  resolution;

    StreamImagePreset(final StreamImageFormat format, final StreamResolution resolution) {

        this.format = format;
        this.resolution = resolution;

    }

    public StreamImageFormat getFormat() {

        return format;

    }

    public StreamResolution getResolution() {

        return resolution;

    }

}
