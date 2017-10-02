package platform.services.api.streams.images;

import org.springframework.lang.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yomateod
 */
public enum StreamImageFormats {

    JPG("jpg"),
    PNG("png");

    private static final Map<String, StreamImageFormats> mappings = new HashMap<>(10);

    private final String format;

    StreamImageFormats(final String format) {

        this.format = format;

    }

    static {

        for(final StreamImageFormats streamimageformat : values()) {

            mappings.put(streamimageformat.name(), streamimageformat);

        }

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
    public static StreamImageFormats resolve(@Nullable final String method) {

        return (method != null ? mappings.get(method) : null);

    }

}
