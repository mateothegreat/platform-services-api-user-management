package platform.services.api.organizations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import platform.services.api.commons.validation.ValidationError;

@Service
public class OrganizationFixtureFactory {

    @Autowired
    private OrganizationService organizationService;

    public Organization newOrganization() {

        try {

            return organizationService.getById(organizationService.save(Organization.create()).getId());

        } catch(final ValidationError error) {

            error.printStackTrace();

        }

        return null;

    }

}
