package platform.services.api.streams;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import platform.services.api.networking.hosts.NetworkHostFactory;

import static org.assertj.core.api.Assertions.assertThat;

@Service @Getter @Setter

public class StreamFixtureFactory {

    @Autowired
    private StreamService      service;

    @Autowired
    private NetworkHostFactory networkHostFactory;

    public Stream persist() {

        final Stream stream = service.saveAndGetById(Stream.create()
                                                           .setHost(networkHostFactory.persist()));

        assertThat(stream.getUuid()).isNotNull();
        assertThat(stream.getHost()).isNotNull();

        return stream;

    }

}
