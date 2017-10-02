package platform.services.api.streams;

public class StreamResolution {

    public static final StreamResolution PROFILE_1920x1080 = new StreamResolution(1920, 1080);

    private int width;
    private int height;

    public StreamResolution(final int width, final int height) {

        this.width = width;
        this.height = height;
    }

    public int getWidth() {

        return width;
    }

    public StreamResolution setWidth(final int width) {

        this.width = width;
        return this;
    }

    public int getHeight() {

        return height;
    }

    public StreamResolution setHeight(final int height) {

        this.height = height;
        return this;
    }
}
