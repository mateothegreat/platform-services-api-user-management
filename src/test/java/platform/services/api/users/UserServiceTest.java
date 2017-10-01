package platform.services.api.users;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.jupiter.api.*;

import platform.services.api.commons.enums.Role;
import platform.services.api.commons.testing.BaseServiceTest;
import platform.services.api.commons.testing.Randomizers;
import platform.services.api.commons.testing.TestingSpringService;
import platform.services.api.users.authentication.Authenticate;
import platform.services.api.users.profiles.UserProfile;
import platform.services.api.users.profiles.UserProfileService;
import platform.services.api.users.roles.UserRole;
import platform.services.api.users.roles.UserRoleService;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
@TestingSpringService
public class UserServiceTest extends BaseServiceTest<UserService, UserRepository, User> {

    private final UserService        userService;
    private final UserProfileService userProfileService;
    private final UserRoleService    userRoleService;

    @Autowired
    public UserServiceTest(final UserService userService, final UserProfileService userProfileService, final UserRoleService userRoleService) {

        super(userService, UserCompositeGenerator::userFixture, User.class);

        this.userService = userService;
        this.userProfileService = userProfileService;
        this.userRoleService = userRoleService;

    }

    @BeforeEach
    public void beforeEach() {

        Authenticate.SUDO_INTEGRATION();

        super.beforeEach();

//        getFixture().addRole(new UserRole(Role.ROLE_ADMIN))
//                    .addRole(new UserRole(Role.ROLE_USER))
//                    .addProfile(new UserProfile(Randomizers.avatar()))
//                    .addProfile(new UserProfile(Randomizers.avatar()));
//
//        assertThat(getFixture().getRoles().size()).isNotZero();
//        assertThat(getFixture().getProfiles().size()).isNotZero();

        final User persisted = userService.getById(getFixture().getId());

//        assertThat(persisted.getRoles().size()).isNotZero();

//        persisted.roles.stream().forEach(element -> log.error(element.toString()));
//        log.error(persisted.getRoles().stream().collect(Collectors.groupingBy(UserRole::getParentId)));

//        persisted.getRoles().stream().filter(e -> e.getParentId() < 0L).collect(Collectors.groupingBy(UserRole::getParentId)).forEach((parentId, roles) -> {
//
//            log.trace("parent id: {}", parentId);
//            log.trace("roles: {}", roles);
//
//        });
    }

}
