package platform.services.api.users.roles;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import platform.services.api.commons.enums.Role;
import platform.services.api.commons.testing.BaseEntityTest;
import platform.services.api.users.User;

import static org.assertj.core.api.Assertions.assertThat;

public class UserRoleTest extends BaseEntityTest<UserRole> {

    @BeforeMethod public void beforeEach() {

        baseEntity = new UserRole();

        baseEntity.setUser(User.create());

        setRole();

    }

    @Test public void create() {

        final UserRole role = UserRole.create();

        assertThat(role).isNotNull();

        assertThat(role.getRole()).isNotNull();

    }
    @Test
    public void testToString() {

        assertThat(baseEntity.toString()).isNotEmpty();

    }
    @Test
    public void testGetUser() {

        assertThat(baseEntity.getUser()).isNotNull();

    }
    @Test public void setRole() {

//        assertThat(baseEntity.setRole(Role.ROLE_USER)).isNotNull();

        baseEntity.setRole(Role.ROLE_USER);

        assertThat(baseEntity.getRole()).isNotNull();

        getRole();

    }

    @Test public void getRole() {

        assertThat(baseEntity.getRole()).isNotNull();

    }
    @Test public void setUser() {

        baseEntity.setUser(new User());

        assertThat(baseEntity.getUser()).isNotNull();

    }
}
