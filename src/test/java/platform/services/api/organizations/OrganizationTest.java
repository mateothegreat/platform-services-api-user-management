package platform.services.api.organizations;

import org.testng.annotations.BeforeMethod;

import platform.services.api.commons.testing.BaseEntityTest;
import platform.services.api.commons.testing.TestingSpringEntity;

@TestingSpringEntity
public class OrganizationTest extends BaseEntityTest<Organization> {

    @BeforeMethod public void beforeEach() {

        baseEntity = new Organization().create();

        super.beforeEach();

    }

}
