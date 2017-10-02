package platform.services.api.streams.images;

import org.springframework.lang.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * a
 *
 * @author yomateod
 */
public enum StreamImageFormat {

    JPG("jpg", 85);

    private static final Map<String, StreamImageFormat> mappings = new HashMap<>(10);

    private final String format;
    private final int    quality;

    StreamImageFormat(final String format, final int quality) {

        this.format = format;
        this.quality = quality;

    }

    static {

        for(final StreamImageFormat streamimageformat : values()) {

            mappings.put(streamimageformat.name(), streamimageformat);

        }

    }

    public String getFormat() {

        return format;

    }

    public int getQuality() {

        return quality;

    }

    /**
     * Determine whether this {@code StreamImageFormat} matches the given method value.
     *
     * @param method the method value as a String
     *
     * @return {@code true} if it matches, {@code false} otherwise
     */
    public boolean matches(final String method) {

        return (this == resolve(method));

    }
    /**
     * Resolve the given method value to an {@code StreamImageFormat}.
     *
     * @param method the method value as a String
     *
     * @return the corresponding {@code StreamImageFormat}, or {@code null} if not found
     */
    @Nullable
    public static StreamImageFormat resolve(@Nullable final String method) {

        return (method != null ? mappings.get(method) : null);

    }

}
