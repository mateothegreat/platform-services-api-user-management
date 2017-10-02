package platform.services.api.networking.hosts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import platform.services.api.commons.jpa.datasources.DataSourceConfig;
import platform.services.api.commons.testing.BaseRepositoryTest;
import platform.services.api.commons.testing.TestingSpringRepository;

@TestingSpringRepository
@SpringBootTest(classes = { DataSourceConfig.class, NetworkHostRepository.class })
public class NetworkHostRepositoryTest extends BaseRepositoryTest<NetworkHostRepository, NetworkHost> {

    @Autowired NetworkHostRepositoryTest(final NetworkHostRepository repository) {

        super(repository, NetworkHost::create, NetworkHost.class);

    }

}
