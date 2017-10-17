/**
 * ====
 *     Copyright 2017 Pivotal Software, Inc.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 * ====
 *
 * Copyright 2017 Pivotal Software, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package platform.services.api.streams.images;

import javax.annotation.Nullable;

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
