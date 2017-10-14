package platform.services.api.monitoring.services;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.mvc.TypeReferences.PagedResourcesType;
import org.testng.annotations.BeforeClass;

import platform.services.api.commons.testing.BaseControllerTest;
import platform.services.api.networking.hosts.NetworkHost;

@SpringBootTest
public class MonitoringServicesControllerTest extends BaseControllerTest<MonitoringService> {

    @BeforeClass
    public void beforeClass() {

        getRest().setTypeReference(new PagedResourcesType<NetworkHost>() {

        });

        super.beforeClass(MonitoringServicesController.PATH_BASE, MonitoringService.class, MonitoringService::create);

    }

}
