package platform.services.api.users;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import platform.services.api.UsersConfig;
import platform.services.api.commons.jpa.datasources.DataSourceConfig;
import platform.services.api.commons.testing.BaseRestRepositoryTest;
import platform.services.api.commons.testing.ComposedJUnit5BootTest;
import platform.services.api.commons.testing.EntityRandomizer;
import platform.services.api.users.authentication.Authenticate;

@Log4j2
@ComposedJUnit5BootTest
@SpringBootConfiguration
@ContextConfiguration(classes = { UsersConfig.class, DataSourceConfig.class }, loader = AnnotationConfigContextLoader.class)
public class UserServiceTest extends BaseRestRepositoryTest<UserRestRepository, User> {

    @Autowired public UserService userService;

    @Autowired public UserRestRepository userRestRepository;

    @BeforeEach
    public void beforeEach() {

//        super.beforeEach();
//
//        entityClass = User.class;
//        genericService = userService;
        log.trace("beforeEach: Authenticate.assumeAdminProfile(): {}", Authenticate.assumeAdminProfile());

    }

    @Test
    public void create() {

        final User r    = (User) EntityRandomizer.get(User.class);
        final User user = new User();

        user.setUsername(EntityRandomizer.username.getRandomValue());
        user.setPassword(r.getPassword());
        user.setParentId(r.getParentId());
        user.setStatus(r.getStatus());
        user.setEmail(r.getEmail());

//        final UserProfile profile = new UserProfile("testavatar1");
//
//        final User created = userService.saveEntityThenProfile(user, profile);
//
//        assertThat(created.getId()).isGreaterThan(0L);
//        assertThat(created.getUsername()).isEqualTo(user.getUsername());
//        assertThat(created.getEmail()).isEqualTo(user.getEmail());
//        assertThat(created.getStatus()).isEqualTo(user.getStatus());

//        assertThat(created.getProfile()).isNotNull();
//        assertThat(created.getProfile().getAvatar()).isEqualTo(profile.getAvatar());

    }

//    public Optional<User> assignRoles(final User user) {
//
//        user.roles = new HashSet<>(2);
//        user.roles.add(new UserRole(Role.ROLE_ADMIN));
//        user.roles.add(new UserRole(Role.ROLE_USER));
//
//        final User saved = userRestRepository.save(user);
//
//        final Optional<User> result = this.userService.findById(saved.getId());
//
//        assertThat(result.get().getRoles().size()).isEqualTo(2);
//
//        return result;
//
//    }
//
//    Optional<User> assignProfile(final User user) {
//
//        final UserProfile profile = new UserProfile("testavatar1");
//
//        profile.setUser(user);
//
////        log.fatal(userProfileRestRepository.save(profile));
//
////        user.setProfile(profile);
//        final User saved = userRestRepository.save(user);
//
//        Optional<User> result = this.userService.findById(user.getId());
//
////        assertThat(result.get().getProfile().getAvatar()).isEqualTo(profile.getAvatar());
////
////        result.get().getProfile().setAvatar("asdfasdf");
//
//        log.fatal(userRestRepository.save(result.get()));
//
//        result = this.userService.findById(user.getId());
//
//        return result;
//
//    }

    @Test void getById() {

        final User user = this.userService.findById(9L).get();

    }
}
