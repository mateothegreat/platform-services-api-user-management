package platform.services.api.users.roles;

import org.springframework.beans.factory.annotation.Autowired;

import org.junit.jupiter.api.*;

import platform.services.api.commons.testing.BaseServiceTest;
import platform.services.api.commons.testing.TestingSpringService;
import platform.services.api.users.User;
import platform.services.api.users.UserCompositeGenerator;
import platform.services.api.users.UserService;
import platform.services.api.users.authentication.Authenticate;

@TestingSpringService
public class UserRoleServiceTest extends BaseServiceTest<UserRoleService, UserRoleRepository, UserRole> {

    private final UserService     userService;
    private       User            user;
    private       UserRole        userRole;

    private final UserRoleService service;


    @Autowired
    public UserRoleServiceTest(final UserRoleService service, final UserService userService) {

        super(service, UserCompositeGenerator::userRoleFixture, UserRole.class);

        this.userService = userService;

        this.service = service;

    }

    @BeforeEach
    public void beforeEach() {

        Authenticate.SUDO_INTEGRATION();

        super.beforeEach();

    }

}
