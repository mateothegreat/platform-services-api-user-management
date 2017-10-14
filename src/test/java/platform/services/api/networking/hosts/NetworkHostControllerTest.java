package platform.services.api.networking.hosts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.mvc.TypeReferences.PagedResourcesType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.BeforeClass;

import platform.services.api.commons.configuration.Profiles.ProfileType;
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
@ActiveProfiles({ ProfileType.TESTING_LEAN })
public class NetworkHostControllerTest extends BaseControllerTest<NetworkHost> {

    @Autowired private UserAuthIntercept  userAuthIntercept;
    @Autowired private NetworkHostFactory networkHostFactory;

    @BeforeClass public void beforeClass() {

        getRest().setTypeReference(new PagedResourcesType<NetworkHost>() {

        });

        super.beforeClass(NetworkHostController.PATH_BASE, NetworkHost.class, NetworkHost::create);

    }

}
