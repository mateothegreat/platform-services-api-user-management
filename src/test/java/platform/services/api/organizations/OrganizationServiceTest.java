package platform.services.api.organizations;

import org.springframework.beans.factory.annotation.Autowired;

import platform.services.api.commons.testing.BaseServiceTest;
import platform.services.api.commons.testing.TestingSpringService;

@TestingSpringService
public class OrganizationServiceTest extends BaseServiceTest<OrganizationService, OrganizationRepository, Organization> {

    private final OrganizationService service;

    @Autowired
    public OrganizationServiceTest(final OrganizationService service) {

        super(service, Organization::create, Organization.class);

        this.service = service;

    }

}
