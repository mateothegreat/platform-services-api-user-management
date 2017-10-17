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
package platform.services.api.streams.functions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import platform.services.api.commons.jpa.entities.BaseEntity;
import platform.services.api.streams.Stream;

@Entity @Getter
@Table(name = "stream_functions")
public class StreamFunction extends BaseEntity<StreamFunction> {

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "streamId")
    @JsonIgnore
    private Stream stream;


    private StreamFunctions function;

    public static StreamFunction create() {

        final StreamFunction fixture = new StreamFunction();

        fixture.function = StreamFunctions.MONITOR;

        return fixture;

    }

    public StreamFunction setStream(final Stream stream) {

        this.stream = stream;

        return this;

    }
    public StreamFunction setFunction(final StreamFunctions function) {

        this.function = function;

        return this;

    }

}
