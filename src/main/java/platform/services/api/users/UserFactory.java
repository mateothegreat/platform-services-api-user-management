package platform.services.api.users;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import platform.services.api.commons.validation.ValidationError;
import platform.services.api.organizations.Organization;
import platform.services.api.organizations.OrganizationRepository;
import platform.services.api.organizations.OrganizationService;
import platform.services.api.users.profiles.UserProfile;
import platform.services.api.users.profiles.UserProfileRepository;
import platform.services.api.users.profiles.UserProfileService;
import platform.services.api.users.roles.UserRole;
import platform.services.api.users.roles.UserRoleRepository;
import platform.services.api.users.roles.UserRoleService;

import static org.assertj.core.api.Assertions.assertThat;

@Service @Getter @Setter
public class UserFactory {

    @Autowired private OrganizationService organizationService;
    @Autowired private UserService         userService;
    @Autowired private UserRoleService     userRoleService;
    @Autowired private UserProfileService  userProfileService;

    @Autowired private UserRepository         userRepository;
    @Autowired private UserRoleRepository     userRoleRepository;
    @Autowired private UserProfileRepository  userProfileRepository;
    @Autowired private OrganizationRepository organizationRepository;

    private Organization organizationEntity = Organization.create();
    private User         userEntity         = User.create();
    private UserRole     userRole           = UserRole.create();
    private UserProfile  userProfile        = UserProfile.create();

    public User persistNewUser() {

        try {

            organizationEntity = organizationService.save(organizationEntity);

            assertThat(organizationEntity.getId()).isNotZero();

            userEntity = userService.save(userEntity.setOrganization(organizationEntity));

            assertThat(userEntity.getOrganization().getId()).isEqualTo(organizationEntity.getId());

            userRole = userRoleService.save(userRole.setUser(userEntity));

            assertThat(userRole.getUser().getId()).isEqualTo(userEntity.getId());

            userProfile = userProfileService.save(userProfile.setUser(userEntity));

            assertThat(userProfile.getUser().getId()).isEqualTo(userEntity.getId());

        } catch(ValidationError error) {

            error.printStackTrace();

        }

        return userService.getById(userEntity.getId());

    }

}
