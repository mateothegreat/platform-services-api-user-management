package platform.services.api.networking.hosts;

import org.testng.annotations.BeforeMethod;

import platform.services.api.commons.testing.BaseEntityTest;

public class NetworkHostTest extends BaseEntityTest<NetworkHost> {

    @BeforeMethod public void beforeEach() {

        baseEntity = NetworkHost.create();

    }

}
