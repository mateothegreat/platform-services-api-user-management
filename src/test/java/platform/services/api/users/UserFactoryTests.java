package platform.services.api.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import platform.services.api.UsersConfig;
import platform.services.api.commons.enums.Role;
import platform.services.api.commons.jpa.datasources.DataSourceConfig;
import platform.services.api.commons.security.SecurityCryptor;
import platform.services.api.commons.validation.ValidationError;
import platform.services.api.organizations.OrganizationService;
import platform.services.api.users.profiles.UserProfileService;
import platform.services.api.users.roles.UserRole;
import platform.services.api.users.roles.UserRoleService;

import static org.assertj.core.api.Assertions.assertThat;

@Test
@ContextConfiguration(classes = {

        DataSourceConfig.class,
        OrganizationService.class,
        UserService.class,
        UserRoleService.class,
        UserProfileService.class,
        UserFactory.class

})
public class UserFactoryTests extends AbstractTestNGSpringContextTests {

    @Autowired
    private UserFactory userFactory;

    @BeforeClass
    public void beforeClass() {

    }

    @Test(timeOut = 500, priority = 0)
    public void persistUserEntities() {

        final User userEntity = userFactory.persistNewUser();

        assertThat(userEntity.getOrganization().getId()).isNotZero();
        assertThat(userEntity.getRoles().size()).isNotZero();
        assertThat(userEntity.getProfiles().size()).isNotZero();

        userFactory.getUserRepository().delete(userEntity);

        assertThat(userFactory.getUserService().getById(userEntity.getId())).isNull();

    }

    @Test(timeOut = 500, priority = 1)
    public void createCustomUserAndPass() {

        final User customUser = userFactory.getUserService().getByUsername(UsersConfig.TESTING_USERNAME);

        if(customUser != null) {

            userFactory.getUserRepository().delete(customUser);

            assertThat(userFactory.getUserService().getById(customUser.getId())).isNull();

        }

        userFactory.getUserEntity().setUsername(UsersConfig.TESTING_USERNAME);
        userFactory.getUserEntity().setPasswordNotEncrypted(UsersConfig.TESTING_PASSWORD);

        final User userEntity = userFactory.persistNewUser();

        assertThat(userEntity.getUsername()).isEqualTo(UsersConfig.TESTING_USERNAME);
        assertThat(SecurityCryptor.matches(UsersConfig.TESTING_PASSWORD, userEntity.getPassword()));

        assertThat(userEntity.getOrganization().getId()).isNotZero();
        assertThat(userEntity.getRoles().size()).isNotZero();
        assertThat(userEntity.getProfiles().size()).isNotZero();

        try {

            userFactory.getUserRoleService().save(UserRole.create()
                                                          .setUser(userEntity)
                                                          .setRole(Role.ROLE_ACTUATOR));

        } catch(ValidationError error) {

            error.printStackTrace();

        }

    }

}

