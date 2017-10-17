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
package platform.services.api.networking.hosts;

import javax.persistence.Entity;
import javax.persistence.Table;

import platform.services.api.commons.networking.BaseNetworkHost;
import platform.services.api.commons.networking.NetworkProtocol;
import platform.services.api.commons.utilities.Randomizers;

@Entity
//@RequiredArgsConstructor

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
