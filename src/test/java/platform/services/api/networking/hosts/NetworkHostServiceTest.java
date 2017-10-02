package platform.services.api.networking.hosts;

import org.springframework.beans.factory.annotation.Autowired;

import platform.services.api.commons.testing.BaseServiceTest;
import platform.services.api.commons.testing.TestingSpringService;

@TestingSpringService
public class NetworkHostServiceTest extends BaseServiceTest<NetworkHostService, NetworkHostRepository, NetworkHost> {

    private final NetworkHostService service;

    @Autowired
    public NetworkHostServiceTest(final NetworkHostService service) {

        super(service, NetworkHost::create, NetworkHost.class);

        this.service = service;

    }

}
