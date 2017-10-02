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

    StreamImageFormat(final String s, final int quality) {

    }

    static {

        for(final StreamImageFormat streamimageformat : values()) {

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
    public static StreamImageFormat resolve(@Nullable final String method) {

        return (method != null ? mappings.get(method) : null);

    }

}
