package platform.services.api.streams;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.javafaker.Faker;

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
import platform.services.api.streams.recordings.StreamRecording;

@Entity
//@Data
@Table(name = "streams")
public class Stream extends BaseEntity {

    protected String name;
    protected String description;

    //    @OneToOne(optional = false, mappedBy = "stream", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @OneToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OneToOne
    @JoinColumn(name = "hostId")
//    @JsonBackReference
    private NetworkHost host;

    private String path;
    private StreamProtocol protcol;
    private String username;
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "stream", fetch = FetchType.EAGER)
    private Set<StreamRecording> recordings = new HashSet<>(0);

    public static Stream create() {

        final Stream stream = new Stream();

        stream.setName(Randomizers.username());
        stream.setDescription(new Faker().company().catchPhrase());

        stream.setProtcol(StreamProtocol.RTMP);
//        stream.setHost(StreamHost.create());

//        stream.getRecordings().add(StreamRecording.create().setStream(this));

        return stream;

    }

    public Stream addRecording(final StreamRecording recording) {

        recordings.add(recording);

//        recording.setStream(this);

        return this;

    }

    public String getName() {

        return name;
    }

    public Stream setName(final String name) {

        this.name = name;
        return this;
    }

    public String getDescription() {

        return description;
    }

    public Stream setDescription(final String description) {

        this.description = description;
        return this;
    }

    public NetworkHost getHost() {

        return host;
    }

    public Stream setHost(final NetworkHost host) {

        this.host = host;
        return this;
    }

    public String getPath() {

        return path;
    }

    public Stream setPath(final String path) {

        this.path = path;
        return this;
    }

    public StreamProtocol getProtcol() {

        return protcol;
    }

    public Stream setProtcol(final StreamProtocol protcol) {

        this.protcol = protcol;
        return this;
    }

    public String getUsername() {

        return username;
    }

    public Stream setUsername(final String username) {

        this.username = username;
        return this;
    }

    public String getPassword() {

        return password;
    }

    public Stream setPassword(final String password) {

        this.password = password;
        return this;
    }

    public Set<StreamRecording> getRecordings() {

        return recordings;
    }

    public Stream setRecordings(final Set<StreamRecording> recordings) {

        this.recordings = recordings;
        return this;
    }

}
