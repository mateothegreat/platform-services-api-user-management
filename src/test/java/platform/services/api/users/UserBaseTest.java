package platform.services.api.users;

import lombok.Getter;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import platform.services.api.commons.enums.Role;
import platform.services.api.commons.enums.Status;
import platform.services.api.commons.jpa.entities.BaseEntity;
import platform.services.api.commons.security.SecurityCryptor;
import platform.services.api.commons.testing.BaseControllerTest;
import platform.services.api.commons.testing.EntityRandomizer;
import platform.services.api.commons.testing.TestingSpringService;
import platform.services.api.users.profiles.UserProfile;
import platform.services.api.users.roles.UserRole;

@Getter
public class UserBaseTest<E extends BaseEntity> extends BaseControllerTest<E> {

    @Autowired
    private UserService userService;

    private User   user;
    private String passwordPlainText;

    public UserBaseTest(final Class<E> entityClass, final String pathBase) {

        super(entityClass, pathBase);

    }

    @BeforeEach
    @Override
    public void beforeEach() {

        user = createUser();

        this.setUsername(user.getUsername());
        this.setPassword(passwordPlainText);

        super.beforeEach();

    }

    @AfterEach
    public void afterEach() {

        userService.deleteById(user.getId());

        assertThat(userService.existsById(user.getId())).isFalse();

    }

    public User createUser() {

        final User user = new User();

        passwordPlainText = EntityRandomizer.password.getRandomValue();

        user.setUsername(EntityRandomizer.username.getRandomValue());
        user.setPasswordNotEncrypted(passwordPlainText);
        user.setPassword(passwordPlainText);
        user.setParentId(EntityRandomizer.id.getRandomValue());
        user.setStatus(Status.ACTIVE_TESTING);
        user.setEmail(EntityRandomizer.email.getRandomValue());

        user.getRoles().add(new UserRole(Role.ROLE_ADMIN));
        user.getRoles().add(new UserRole(Role.ROLE_USER_ADMIN));

        user.getProfiles().add(new UserProfile(EntityRandomizer.username.getRandomValue()));
        user.getProfiles().add(new UserProfile(EntityRandomizer.username.getRandomValue()));
        user.getProfiles().add(new UserProfile(EntityRandomizer.username.getRandomValue()));
        user.getProfiles().add(new UserProfile(EntityRandomizer.username.getRandomValue()));
        user.getProfiles().add(new UserProfile(EntityRandomizer.username.getRandomValue()));

        final User created = userService.saveEntity(user);

        created.setPasswordNotEncrypted(passwordPlainText);

        assertThat(SecurityCryptor.isEncoded(created.getPassword())).isTrue();

        assertThat(created.getId()).isGreaterThan(0L);
        assertThat(created.getUsername()).isEqualTo(user.getUsername());
        assertThat(created.getEmail()).isEqualTo(user.getEmail());
        assertThat(created.getStatus()).isEqualTo(user.getStatus());

        assertThat(created.getProfiles().isEmpty()).isFalse();
        assertThat(created.getProfiles().size()).isEqualTo(user.getProfiles().size());

        return created;

    }

    @Test
    void assertUserFixtureExists() {

        final Optional<E> result = userService.findById(user.getId());

        assertThat(result.isPresent()).isTrue();

    }

}
