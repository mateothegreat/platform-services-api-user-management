package platform.services.api.networking.hosts;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import platform.services.api.commons.testing.BaseControllerTest;
import platform.services.api.users.UserAuthIntercept;
import platform.services.api.users.UserFactoryTesting;

@UserFactoryTesting
public class NetworkHostControllerTest extends BaseControllerTest<NetworkHost> {

    @Autowired
    private UserAuthIntercept userAuthIntercept;

    @BeforeClass
    public void beforeClass() {

        setFn(NetworkHost::create);
        setEntityClass(NetworkHost.class);

        getRestTemplateFactory().setBasicAuth(userAuthIntercept.getUserEntity().getUsername(), userAuthIntercept.getUserEntity().getPassword());

        getRestTemplateFactory().getUriBuilder()
                                .pathSegment(NetworkHostController.PATH_BASE, "search", "all")
                                .queryParam("term", "a");

        getRestTemplateFactory().exchange();

    }

    @Test
    public void getNewUserTest() {

    }

}
