package platform.services.api.networking.hosts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeClass;

import platform.services.api.commons.jpa.datasources.DataSourceConfig;
import platform.services.api.commons.testing.BaseRepositoryTest;

@SpringBootTest(classes = { DataSourceConfig.class, NetworkHostRepository.class })
public class NetworkHostRepositoryTest extends BaseRepositoryTest<NetworkHostRepository, NetworkHost> {

    @Autowired
    private NetworkHostRepository repository;

    @BeforeClass
    public void beforeClass() {

        setFn(NetworkHost::create);
        setBaseRepository(repository);

    }

}
