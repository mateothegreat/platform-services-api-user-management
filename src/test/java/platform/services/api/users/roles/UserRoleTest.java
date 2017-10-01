package platform.services.api.users.roles;

import org.junit.jupiter.api.*;

import platform.services.api.commons.enums.Role;
import platform.services.api.commons.testing.BaseEntityTest;
import platform.services.api.commons.testing.TestingSpringEntity;

import static org.assertj.core.api.Assertions.assertThat;

@TestingSpringEntity
public class UserRoleTest extends BaseEntityTest<UserRole> {


    @BeforeEach public void beforeEach() {

        baseEntity = new UserRole();

        super.beforeEach();

        setRole();

    }

    @Test public void setRole() {

        baseEntity.setRole(Role.ROLE_USER);

        getRole();

    }

    @Test public void getRole() {

        assertThat(baseEntity.getRole()).isNotNull();

    }

}
