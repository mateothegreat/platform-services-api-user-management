package platform.services.api.organizations;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.mvc.TypeReferences.PagedResourcesType;
import org.testng.annotations.BeforeClass;

import platform.services.api.commons.testing.BaseControllerTest;

@SpringBootTest
public class OrganizationControllerTest extends BaseControllerTest<Organization> {

    @BeforeClass
    public void beforeClass() {

        getRest().setTypeReference(new PagedResourcesType<Organization>() {

        });

        super.beforeClass(OrganizationController.PATH_BASE, Organization.class, Organization::create);

    }

}
