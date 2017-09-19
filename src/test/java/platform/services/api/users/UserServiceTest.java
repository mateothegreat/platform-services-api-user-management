package platform.services.api.users;

import lombok.extern.log4j.Log4j2;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

import platform.services.api.UsersConfig;
import platform.services.api.commons.enums.Role;
import platform.services.api.commons.enums.Status;
import platform.services.api.commons.security.SecurityCryptor;
import platform.services.api.commons.testing.BaseRestRepositoryTest;
import platform.services.api.commons.testing.ComposedJUnit5BootTest;
import platform.services.api.commons.testing.EntityRandomizer;
import platform.services.api.users.authentication.Authenticate;
import platform.services.api.users.profiles.UserProfile;
import platform.services.api.users.roles.UserRole;

@Log4j2
@SpringBootConfiguration
@ContextConfiguration(classes = {

    UsersConfig.class,
    platform.services.api.users.DataSourceConfig.class

}, loader = AnnotationConfigContextLoader.class)
@ComposedJUnit5BootTest
public class UserServiceTest extends BaseRestRepositoryTest<UserRestRepository, User> {

    private final UserService userService;
    private       User        user;

    @Autowired
    public UserServiceTest(final UserService userService) {

        super(userService, User.class);

        this.userService = userService;

    }

    @BeforeEach
    public void beforeEach() {

        log.trace("beforeEach: Authenticate.SUDO_INTEGRATION(): {}", Authenticate.SUDO_INTEGRATION());

        user = create();

    }

    @Test
    public void getById() {

        final Optional<User> result = this.userService.findById(user.getId());

        assertThat(result.isPresent()).isTrue();

    }

    public User create() {

        final User r    = (User) EntityRandomizer.get(User.class);
        final User user = new User();

        user.setUsername(EntityRandomizer.username.getRandomValue());
        user.setPassword(r.getPassword());
        user.setParentId(r.getParentId());
        user.setStatus(Status.ACTIVE_TESTING);
        user.setEmail(r.getEmail());

        user.getRoles().add(new UserRole(Role.ROLE_ADMIN));
        user.getRoles().add(new UserRole(Role.ROLE_USER_ADMIN));
//        user.getRoles().add(new UserRole(Role.ROLE_POSTS));
//        user.getRoles().add(new UserRole(Role.ROLE_USER));
////
//        user.getRoles().add(new UserRole(Role.ROLE_ADMIN));
//        user.getRoles().add(new UserRole(Role.ROLE_POSTS));
//        user.getRoles().add(new UserRole(Role.ROLE_USER));

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

//    @PersistenceContext
//    private EntityManager entityManager;
//    public UserInfo getActiveUser(String userName) {
//        UserInfo activeUserInfo = new UserInfo();
//        short enabled = 1;
//        List<?> list = entityManager.createQuery("SELECT u FROM UserInfo u WHERE userName=? and enabled=?")
//                                    .setParameter(1, userName).setParameter(2, enabled).getResultList();
//        if(!list.isEmpty()) {
//            activeUserInfo = (UserInfo)list.get(0);
//        }
//        return activeUserInfo;
//    }
}
