package platform.services.api.networking.hosts;

import org.testng.annotations.BeforeMethod;

import platform.services.api.commons.testing.BaseEntityTest;
import platform.services.api.commons.testing.TestingSpringEntity;

@TestingSpringEntity
public class NetworkHostTest extends BaseEntityTest<NetworkHost> {

    @BeforeMethod public void beforeEach() {

        baseEntity = NetworkHost.create();

        super.beforeEach();

    }

}
