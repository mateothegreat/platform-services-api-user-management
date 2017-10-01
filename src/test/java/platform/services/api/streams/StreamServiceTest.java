package platform.services.api.streams;

import org.springframework.beans.factory.annotation.Autowired;

import platform.services.api.commons.testing.BaseServiceTest;
import platform.services.api.commons.testing.TestingSpringService;

@TestingSpringService
public class StreamServiceTest extends BaseServiceTest<StreamService, StreamRepository, Stream> {

    private final StreamService service;

    @Autowired
    public StreamServiceTest(final StreamService service) {

        super(service, Stream::create, Stream.class);

        this.service = service;

    }

}
