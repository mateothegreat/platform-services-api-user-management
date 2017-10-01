package platform.services.api.organizations;

import org.junit.jupiter.api.*;

import platform.services.api.commons.testing.BaseEntityTest;
import platform.services.api.commons.testing.TestingSpringEntity;

@TestingSpringEntity
public class OrganizationTest extends BaseEntityTest<Organization> {

    @BeforeEach public void beforeEach() {

        baseEntity = new Organization().create();

        super.beforeEach();

    }

}
