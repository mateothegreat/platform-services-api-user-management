package platform.services.api.organizations;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.HashSet;

import platform.services.api.commons.testing.BaseEntityTest;
import platform.services.api.users.User;

import static org.assertj.core.api.Assertions.assertThat;

public class OrganizationTest extends BaseEntityTest<Organization> {

    @Test @BeforeMethod public void beforeEach() {

        baseEntity = Organization.create();

        assertThat(baseEntity).isNotNull();

    }

    @Test public void testCreate() {

        assertThat(Organization.create()).isNotNull();

    }
    @Test public void testSetDescription() {

        assertThat(baseEntity.setDescription("test").getDescription()).isNotNull();

    }
    @Test public void testSetName() {

        assertThat(baseEntity.setName("test").getName()).isNotNull();

    }
    @Test public void testSetUsers() {

        assertThat(baseEntity.setUsers(new HashSet<>(Collections.singletonList(User.create()))).getUsers()).isNotNull();

    }

}
