package platform.services.api.networking.hosts;

import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

import platform.services.api.commons.networking.BaseNetworkHost;
import platform.services.api.commons.networking.NetworkProtocol;
import platform.services.api.commons.utilities.Randomizers;

@Entity
@RequiredArgsConstructor

@Table(name = "network_hosts")
public class NetworkHost extends BaseNetworkHost {

//    public Stream getStream() {
//
//        return stream;
//    }

//    @OneToOne(fetch = FetchType.LAZY)
////    @OneToOne(mappedBy = "host", fetch = FetchType.LAZY)
//    @JoinColumn(name = "id")
//    @JsonBackReference @JsonIgnore
////    @MapsId
//    @JsonIgnore

    //    @JsonManagedReference
//    @OneToOne(cascade= CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    private Stream stream;
//
//    public StreamHost setStream(final Stream stream) {
//
//        this.stream = stream;
//        return this;
//    }
//
    public static NetworkHost create() {

        final NetworkHost fixture = new NetworkHost();

        fixture.setAddress("18.220.59.117");
        fixture.setHostname("devops-centos-01.aws.streaming-platform.com");
        fixture.setPort(Randomizers.port());
        fixture.setProtocol(NetworkProtocol.TCP);

        return fixture;

    }

}
