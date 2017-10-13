package platform.services.api.organizations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeClass;

import platform.services.api.commons.jpa.datasources.DataSourceConfig;
import platform.services.api.commons.testing.BaseRepositoryTest;

@SpringBootTest(classes = { DataSourceConfig.class, OrganizationRepository.class })
public class OrganizationRepositoryTest extends BaseRepositoryTest<OrganizationRepository, Organization> {

    @Autowired
    private OrganizationRepository repository;

    @BeforeClass
    public void beforeClass() {

        setFn(Organization::create);
        setBaseRepository(repository);

    }

}
