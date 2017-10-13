package platform.services.api.networking.hosts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import platform.services.api.commons.jpa.datasources.DataSourceConfig;
import platform.services.api.commons.testing.BaseControllerTest;
import platform.services.api.users.UserAuthIntercept;
import platform.services.api.users.UserFactoryTest;

@UserFactoryTest
@NetworkHostFactorySetup

@ContextConfiguration(classes = {

        DataSourceConfig.class,

        NetworkHostFactory.class,
        UserAuthIntercept.class,
        NetworkHostRepository.class,
        NetworkHostService.class,

})
public class NetworkHostControllerTest extends BaseControllerTest<NetworkHost> {

    @Autowired private UserAuthIntercept  userAuthIntercept;
    @Autowired private NetworkHostFactory networkHostFactory;

    @BeforeClass public void beforeClass() {

        super.beforeClass(NetworkHostController.PATH_BASE, NetworkHost.class, NetworkHost::create);

    }

}
