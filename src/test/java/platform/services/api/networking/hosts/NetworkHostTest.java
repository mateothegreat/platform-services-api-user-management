package platform.services.api.networking.hosts;

import org.junit.jupiter.api.*;

import platform.services.api.commons.testing.BaseEntityTest;
import platform.services.api.commons.testing.TestingSpringEntity;

@TestingSpringEntity
public class NetworkHostTest extends BaseEntityTest<NetworkHost> {

    @BeforeEach public void beforeEach() {

        baseEntity = NetworkHost.create();

        super.beforeEach();

    }

}
