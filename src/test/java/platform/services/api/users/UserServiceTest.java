package platform.services.api.users;

import lombok.extern.log4j.Log4j2;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import platform.services.api.UsersConfig;
import platform.services.api.commons.enums.Role;
import platform.services.api.commons.enums.Status;
import platform.services.api.commons.jpa.datasources.DataSourceConfig;
import platform.services.api.commons.security.SecurityCryptor;
import platform.services.api.commons.testing.BaseRepositoryTest;
import platform.services.api.commons.testing.TestingSpringService;
import platform.services.api.commons.testing.EntityRandomizer;
import platform.services.api.users.authentication.Authenticate;
import platform.services.api.users.profiles.UserProfile;
import platform.services.api.users.roles.UserRole;

@Log4j2

@TestingSpringService
public class UserServiceTest extends BaseRepositoryTest<UserRepository, User> {

    private final UserService<UserRepository, User> userService;
    private       User                              user;
    @Autowired
    public UserServiceTest(final UserService<UserRepository, User> userService) {

        super(userService, User.class);

        this.userService = userService;


    }

    @BeforeEach
    public void beforeEach() {

        log.trace("beforeEach: Authenticate.SUDO_INTEGRATION(): {}", Authenticate.SUDO_INTEGRATION());

        user = create();

        this.setBaseEntityFixture(user);

    }

    @Test
    public void getById() {

        final Optional<User> result = this.userService.findById(user.getId());

        assertThat(result.isPresent()).isTrue();

    }

    public User create() {

        final User rand    = r.get(User.class);
        final User user = new User();

        user.setUsername(EntityRandomizer.username.getRandomValue());
        user.setPassword(rand.getPassword());
        user.setParentId(rand.getParentId());
        user.setStatus(Status.ACTIVE_TESTING);
        user.setEmail(rand.getEmail());

        user.getRoles().add(new UserRole(Role.ROLE_ADMIN));
        user.getRoles().add(new UserRole(Role.ROLE_USER_ADMIN));

        user.getProfiles().add(new UserProfile(EntityRandomizer.username.getRandomValue()));
        user.getProfiles().add(new UserProfile(EntityRandomizer.username.getRandomValue()));
        user.getProfiles().add(new UserProfile(EntityRandomizer.username.getRandomValue()));
        user.getProfiles().add(new UserProfile(EntityRandomizer.username.getRandomValue()));
        user.getProfiles().add(new UserProfile(EntityRandomizer.username.getRandomValue()));

        final User created = userService.saveEntity(user);

        assertThat(created.getId()).isGreaterThan(0L);
        assertThat(created.getUsername()).isEqualTo(user.getUsername());
        assertThat(SecurityCryptor.isEncoded(created.getPassword())).isTrue();
        assertThat(created.getEmail()).isEqualTo(user.getEmail());
        assertThat(created.getStatus()).isEqualTo(user.getStatus());

        assertThat(created.getProfiles().isEmpty()).isFalse();
        assertThat(created.getProfiles().size()).isEqualTo(user.getProfiles().size());

        return created;

    }

}
