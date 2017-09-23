package platform.services.api.users.roles;

import lombok.extern.log4j.Log4j2;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import platform.services.api.commons.enums.Role;
import platform.services.api.commons.testing.BaseRepositoryTest;
import platform.services.api.commons.testing.TestingSpringService;
import platform.services.api.users.User;
import platform.services.api.users.UserBaseTest;
import platform.services.api.users.profiles.UserProfile;

@Log4j2
@TestingSpringService
class UserRoleRepositoryTest extends BaseRepositoryTest<UserRoleRepository, UserRole, Long> {

    private final UserRoleRepository repository;

    @Autowired
    UserRoleRepositoryTest(final UserRoleRepository repository) {

        super(repository, UserRole.class);

        assertThat(repository).isNotNull();

        this.repository = repository;


    }


    @BeforeEach
    public void beforeEach() {

        assertThat(repository).isNotNull();

        final UserRole saved = repository.save(UserRoleFixture());

    }


    @AfterEach
    public void afterEach() {



    }

    public static UserRole UserRoleFixture() {

        final UserRole role = new UserRole();

        role.setRole(Role.ROLE_USER);

        return role;

    }

}
