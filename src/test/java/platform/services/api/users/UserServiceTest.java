package platform.services.api.users;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.jupiter.api.*;

import javax.transaction.Transactional;

import platform.services.api.commons.testing.BaseServiceTest;
import platform.services.api.commons.testing.TestingSpringService;
import platform.services.api.commons.validation.ValidationError;
import platform.services.api.organizations.Organization;
import platform.services.api.organizations.OrganizationFixtureFactory;
import platform.services.api.organizations.OrganizationService;
import platform.services.api.users.authentication.Authenticate;
import platform.services.api.users.profiles.UserProfileService;
import platform.services.api.users.roles.UserRoleFixtureFactory;
import platform.services.api.users.roles.UserRoleService;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
@TestingSpringService
@Transactional
public class UserServiceTest extends BaseServiceTest<UserService, UserRepository, User> {

    private final UserService        userService;
    private final UserProfileService userProfileService;
    private final UserRoleService    userRoleService;

    @Autowired
    private OrganizationFixtureFactory organizationFixtureFactory;

    @Autowired
    private UserRoleFixtureFactory userRoleFixtureFactory;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    public UserServiceTest(final UserService userService, final UserProfileService userProfileService, final UserRoleService userRoleService) {

        super(userService, UserCompositeGenerator::userFixture, User.class);

        this.userService = userService;
        this.userProfileService = userProfileService;
        this.userRoleService = userRoleService;

    }

    @BeforeEach
    @Transactional
    public void beforeEach() {

        Authenticate.SUDO_INTEGRATION();

        try {

            final Organization organizationFixture = Organization.create();
            final Organization organizationEntity  = organizationService.save(organizationFixture);
            final User         userFixture         = UserCompositeGenerator.userFixture().setOrganization(organizationEntity);
            final User         userEntity          = userService.save(userFixture);

            assertThat(userEntity.getOrganization().getId()).isNotZero();

            setFixture(userFixture);

        } catch(final ValidationError error) {

            error.printStackTrace();

        }

    }

}
