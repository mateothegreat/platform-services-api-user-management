package platform.services.api.monitoring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeClass;

import platform.services.api.commons.jpa.datasources.DataSourceConfig;
import platform.services.api.commons.testing.BaseServiceTest;

@SpringBootTest(classes = { DataSourceConfig.class, MonitoringServicesService.class, MonitoringServicesRepository.class })
public class MonitoringServicesServiceTest extends BaseServiceTest<MonitoringServicesService, MonitoringServicesRepository, MonitoringService> {

    @Autowired
    private MonitoringServicesService service;

    @BeforeClass
    public void beforeClass() {

        setFn(MonitoringService::create);
        setGenericService(service);

    }

}
