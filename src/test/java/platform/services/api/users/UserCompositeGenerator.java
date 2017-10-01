package platform.services.api.users;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import platform.services.api.commons.enums.Role;
import platform.services.api.commons.enums.Status;
import platform.services.api.commons.testing.BaseTestConfig;
import platform.services.api.commons.testing.Randomizers;
import platform.services.api.commons.validation.ValidationError;
import platform.services.api.organizations.Organization;
import platform.services.api.organizations.OrganizationService;
import platform.services.api.users.profiles.UserProfile;
import platform.services.api.users.profiles.UserProfileService;
import platform.services.api.users.roles.UserRole;
import platform.services.api.users.roles.UserRoleService;

@Service
@Transactional
public class UserCompositeGenerator implements UserComposite {

    private final OrganizationService organizationService;
    private final UserService        userService;
    private final UserRoleService    userRoleService;
    private final UserProfileService userProfileService;
    private final User               userEntity;
    private       Organization        organizationEntity;

    public UserCompositeGenerator(final OrganizationService organizationService, final UserService userService, final UserRoleService userRoleService, final UserProfileService userProfileService) throws ValidationError {

        this.organizationService = organizationService;
        this.userService = userService;
        this.userRoleService = userRoleService;
        this.userProfileService = userProfileService;

        userEntity = persistFixtures();

    }

    public User persistFixtures() throws ValidationError {

        return persistFixtures(Organization.create(), BaseTestConfig.USER_VALID_PARENT_ID, BaseTestConfig.USER_VALID_USERNAME, BaseTestConfig.USER_VALID_PASSWORD);

    }

    @Transactional
    public User persistFixtures(final Organization organization, final Long parentId, final String username, final String password) throws ValidationError {

        final User fixture = userFixture();

        this.organizationEntity = organizationService.save(organization);

        fixture.setUsername(String.format("%s-%d", username, Randomizers.id()));
        fixture.setPasswordNotEncrypted(password);
        fixture.setPassword(password);
        fixture.setOrganization(organizationService.getById(organizationEntity.getId()));

        User persisted = userService.save(fixture);

//        userService.save(persisted.setOrganization(organizationService.getById(organizationEntity.getId())));
        userRoleService.save(new UserRole().setUser(persisted).setRole(Role.ROLE_ADMIN));
        userProfileService.save(new UserProfile().setUser(persisted).setAvatar(Randomizers.avatar()));

        persisted = userService.getById(persisted.getId())
                               .setPasswordNotEncrypted(password);

//        persisted.getRoles().stream().map(userRoleService::save);
//        persisted.getProfiles().stream().map(userProfileService::save);

//        persisted = userService.getById(persisted.getId())
//                               .setPasswordNotEncrypted(password);
//
//        assertThat(persisted.getRoles()
//                            .stream()
//                            .filter(role -> role.getParentId() > 0L)
//                            .count()).isEqualTo(Integer.toUnsignedLong(persisted.getRoles().size()));
//
//        assertThat(persisted.getProfiles()
//                            .stream()
//                            .filter(role -> role.getParentId() > 0L)
//                            .count()).isEqualTo(Integer.toUnsignedLong(persisted.getProfiles().size()));

        return persisted;

    }

//    private Long getTotalTestUsers() {
//
//        final Long total = userService.getByParentId(BaseTestConfig.USER_VALID_PARENT_ID).getTotalElements();
//
//        return total;
//
//    }

    public static User userFixture() {

        return new User().setUsername(Randomizers.username())
                         .setPasswordNotEncrypted(Randomizers.password())
                         .setEmail(Randomizers.email())
//                         .setParentId(Randomizers.id())
                         .setStatus(Status.ACTIVE_TESTING);

    }

    public static User composedFixtures() {

        return userFixture().addRole(userRoleFixture())
                            .addProfile(userProfileFixture());

    }

    public static UserRole userRoleFixture() {

        return new UserRole().setRole(Role.ROLE_USER);

    }

    public static UserProfile userProfileFixture() {

        return new UserProfile().setAvatar(Randomizers.avatar());

    }

}
