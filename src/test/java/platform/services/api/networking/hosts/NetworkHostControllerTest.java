package platform.services.api.networking.hosts;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;

import platform.services.api.commons.testing.BaseControllerTestCase;
import platform.services.api.users.UserAuthenticationTestSetup;
import platform.services.api.users.UserCompositeGenerator;

@BaseControllerTestCase
public class NetworkHostControllerTest extends UserAuthenticationTestSetup<NetworkHost> {

    @Autowired
    public NetworkHostControllerTest(final UserCompositeGenerator userCompositeGenerator) {

        super(NetworkHost::create, NetworkHost.class, NetworkHostController.PATH_BASE, userCompositeGenerator);

    }

    @BeforeMethod
    public void beforeEach() {

        beforeUserAuthenticationFixturesEach();

        super.beforeEach();

    }

}
