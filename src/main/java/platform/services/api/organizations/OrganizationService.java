package platform.services.api.organizations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import platform.services.api.commons.services.GenericService;

@Service
@Transactional
public class OrganizationService extends GenericService<OrganizationRepository, Organization> {

    private final OrganizationRepository repository;

    @Autowired
    public OrganizationService(final OrganizationRepository repository) {

        super(repository);

        this.repository = repository;

    }

}
