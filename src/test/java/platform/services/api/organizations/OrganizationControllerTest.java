package platform.services.api.organizations;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;

import platform.services.api.commons.testing.BaseControllerTestCase;
import platform.services.api.users.UserAuthenticationTestSetup;
import platform.services.api.users.UserCompositeGenerator;

@BaseControllerTestCase
public class OrganizationControllerTest extends UserAuthenticationTestSetup<Organization> {

    @Autowired
    public OrganizationControllerTest(final UserCompositeGenerator userCompositeGenerator) {

        super(Organization::create, Organization.class, OrganizationController.PATH_BASE, userCompositeGenerator);

    }

    @BeforeMethod
    public void beforeEach() {

        beforeUserAuthenticationFixturesEach();

        super.beforeEach();

    }

}
