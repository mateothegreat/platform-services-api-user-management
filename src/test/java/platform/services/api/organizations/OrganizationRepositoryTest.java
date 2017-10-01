package platform.services.api.organizations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import platform.services.api.commons.jpa.datasources.DataSourceConfig;
import platform.services.api.commons.testing.BaseRepositoryTest;
import platform.services.api.commons.testing.TestingSpringRepository;

@TestingSpringRepository
@SpringBootTest(classes = { DataSourceConfig.class, OrganizationRepository.class })
public class OrganizationRepositoryTest extends BaseRepositoryTest<OrganizationRepository, Organization> {

    @Autowired OrganizationRepositoryTest(final OrganizationRepository repository) {

        super(repository, Organization::create, Organization.class);

    }

}
