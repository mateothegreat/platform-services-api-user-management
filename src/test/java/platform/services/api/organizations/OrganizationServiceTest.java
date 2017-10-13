package platform.services.api.organizations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeClass;

import platform.services.api.commons.jpa.datasources.DataSourceConfig;
import platform.services.api.commons.testing.BaseServiceTest;

@SpringBootTest(classes = { DataSourceConfig.class, OrganizationService.class, OrganizationRepository.class })
public class OrganizationServiceTest extends BaseServiceTest<OrganizationService, OrganizationRepository, Organization> {

    @Autowired
    private OrganizationService service;

    @BeforeClass
    public void beforeClass() {

        setFn(Organization::create);
        setGenericService(service);

    }

}
