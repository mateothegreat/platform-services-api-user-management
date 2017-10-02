package platform.services.api.networking.hosts;

import org.springframework.beans.factory.annotation.Autowired;

import org.junit.jupiter.api.*;

import platform.services.api.users.UserAuthenticationTestSetup;
import platform.services.api.users.UserCompositeGenerator;

@BaseControllerTestCase
public class NetworkHostControllerTest extends UserAuthenticationTestSetup<NetworkHost> {

    @Autowired
    public NetworkHostControllerTest(final UserCompositeGenerator userCompositeGenerator) {

        super(NetworkHost::create, NetworkHost.class, NetworkHostController.PATH_BASE, userCompositeGenerator);

    }

    @BeforeEach
    public void beforeEach() {

        beforeUserAuthenticationFixturesEach();

        super.beforeEach();

    }

}
