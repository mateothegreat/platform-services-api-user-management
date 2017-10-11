package platform.services.api.networking.hosts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeClass;

import platform.services.api.commons.jpa.datasources.DataSourceConfig;
import platform.services.api.commons.testing.BaseServiceTest;

@SpringBootTest(classes = { DataSourceConfig.class, NetworkHostService.class, NetworkHostRepository.class })
public class NetworkHostServiceTest extends BaseServiceTest<NetworkHostService, NetworkHostRepository, NetworkHost> {

    @Autowired
    private NetworkHostService service;

    @BeforeClass
    public void beforeClass() {

        setFn(NetworkHost::create);
        setGenericService(service);

    }

}
