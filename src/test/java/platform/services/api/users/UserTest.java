package platform.services.api.users;

import org.junit.jupiter.api.*;

import platform.services.api.commons.enums.Role;
import platform.services.api.commons.security.SecurityCryptor;
import platform.services.api.commons.testing.BaseEntityTest;
import platform.services.api.commons.testing.TestingSpringEntity;
import platform.services.api.commons.utilities.Randomizers;
import platform.services.api.users.profiles.UserProfile;
import platform.services.api.users.roles.UserRole;

import static org.assertj.core.api.Assertions.assertThat;

@TestingSpringEntity
public class UserTest extends BaseEntityTest<User> {

    @BeforeEach public void beforeEach() {

        baseEntity = UserCompositeGenerator.composedFixtures();

        super.beforeEach();

    }

    @Test public void setUsername() {

        baseEntity.setUsername(Randomizers.username());

        getUsername();

    }

    @Test public void getUsername() {

        assertThat(baseEntity.getUsername()).isNotEmpty();

    }

    @Test public void setPassword() {

        baseEntity.setPassword(Randomizers.password());

        getPassword();

    }

    @Test public void getPassword() {

        assertThat(SecurityCryptor.isEncoded(baseEntity.getPassword())).isTrue();

    }

    @Test public void setEmail() {

        baseEntity.setEmail(Randomizers.email());

        getEmail();

    }

    @Test public void getEmail() {

        assertThat(baseEntity.getEmail()).isNotEmpty();

    }

    @Test public void setRoles() {

        baseEntity.getRoles().add(new UserRole(Role.ROLE_USER));

        getRoles();

    }

    @Test public void getRoles() {

        assertThat(baseEntity.getRoles().size()).isGreaterThanOrEqualTo(1);

    }

    @Test public void setProfiles() {

        baseEntity.getProfiles().add(new UserProfile(Randomizers.avatar()));

        getProfiles();

    }

    @Test public void getProfiles() {

        assertThat(baseEntity.getProfiles().size()).isGreaterThanOrEqualTo(1);

    }

    @Test public void setPasswordNotEncrypted() {

        baseEntity.setPasswordNotEncrypted(Randomizers.password());

        getPasswordNotEncrypted();

    }

    @Test public void getPasswordNotEncrypted() {

        assertThat(baseEntity.getPasswordNotEncrypted()).isNotEmpty();

        assertThat(SecurityCryptor.isEncoded(baseEntity.getPasswordNotEncrypted())).isFalse();

    }

}
