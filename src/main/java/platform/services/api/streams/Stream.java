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
package platform.services.api.streams;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.javafaker.Faker;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.HashSet;
import java.util.Set;

import platform.services.api.commons.jpa.entities.BaseEntity;
import platform.services.api.commons.utilities.Randomizers;
import platform.services.api.networking.hosts.NetworkHost;
import platform.services.api.streams.functions.StreamFunction;
import platform.services.api.streams.recordings.StreamCodec;
import platform.services.api.streams.recordings.StreamFPS;
import platform.services.api.streams.recordings.StreamRecording;

@Entity
//@Data
@Table(name = "streams") @Getter
public class Stream extends BaseEntity {

    protected String name;
    protected String description;

    //    @OneToOne(optional = false, mappedBy = "stream", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @OneToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OneToOne
    @JoinColumn(name = "hostId")
    private NetworkHost host;

    private String         path;
    private StreamProtocol protcol;
    private String         username;
    private String         password;
    private int            resolutionWidth;
    private int            resolutionHeight;
    private int            bitrate;
    private int            bitrateAverage;
    private int            bitrateMax;
    private int            crf;
    private StreamFPS      fps;
    private StreamCodec    codec;

    @JsonIgnore
    @OneToMany(mappedBy = "stream", fetch = FetchType.EAGER)
    private Set<StreamRecording> recordings = new HashSet<>(0);

    @JsonIgnore
    @OneToMany(mappedBy = "stream", fetch = FetchType.EAGER)
    private Set<StreamFunction> functions = new HashSet<>(0);

    public static Stream create() {

        final Stream stream = new Stream();

        stream.setHost(NetworkHost.create());
        stream.setName(Randomizers.username());
        stream.setDescription(new Faker().company().catchPhrase());
        stream.setUsername(Randomizers.username());
        stream.setPassword(Randomizers.password());
        stream.setPath("test");
        stream.setProtcol(StreamProtocol.RTMP);

        stream.getRecordings().add(StreamRecording.create());

        return stream;

    }

    public Stream addRecording(final StreamRecording recording) {

        recordings.add(recording);

//        recording.setStream(this);

        return this;

    }
    public NetworkHost getHost() {

        return host;

    }
    public Stream setDescription(final String description) {

        this.description = description;

        return this;

    }
    public Stream setHost(final NetworkHost host) {

        this.host = host;

        return this;

    }
    public Stream setName(final String name) {

        this.name = name;

        return this;

    }
    public Stream setPassword(final String password) {

        this.password = password;

        return this;

    }
    public Stream setPath(final String path) {

        this.path = path;

        return this;

    }
    public Stream setProtcol(final StreamProtocol protcol) {

        this.protcol = protcol;

        return this;

    }
    public Stream setRecordings(final Set<StreamRecording> recordings) {

        this.recordings = recordings;

        return this;

    }
    public Stream setUsername(final String username) {

        this.username = username;

        return this;

    }

}
