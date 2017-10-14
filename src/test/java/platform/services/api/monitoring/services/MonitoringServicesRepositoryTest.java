package platform.services.api.monitoring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeClass;

import platform.services.api.commons.jpa.datasources.DataSourceConfig;
import platform.services.api.commons.testing.BaseRepositoryTest;

@SpringBootTest(classes = { DataSourceConfig.class, MonitoringServicesRepository.class })
public class MonitoringServicesRepositoryTest extends BaseRepositoryTest<MonitoringServicesRepository, MonitoringService> {

    @Autowired private MonitoringServicesRepository repository;

    @BeforeClass public void beforeClass() {

        setFn(MonitoringService::create);
        setBaseRepository(repository);

    }

}
