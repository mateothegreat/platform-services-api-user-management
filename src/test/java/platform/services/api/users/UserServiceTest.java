package platform.services.api.users;

import lombok.extern.log4j.Log4j2;
import static org.assertj.core.api.Assertions.assertThat;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;

import java.util.HashSet;
import java.util.Optional;

import platform.services.api.UsersConfig;
import platform.services.api.commons.jpa.enums.Role;
import platform.services.api.commons.testing.BaseRestRepositoryTest;
import platform.services.api.commons.testing.ComposedJUnit5BootTest;
import platform.services.api.commons.testing.EntityRandomizer;
import platform.services.api.users.authentication.AuthenticatedRunAsManager;

@Log4j2
@ComposedJUnit5BootTest
@SpringBootConfiguration
@ContextConfiguration(classes = { UsersConfig.class, DataSourceConfig.class }, loader = AnnotationConfigContextLoader.class)
//public class UserServiceTest extends BaseRestRepositoryTest<UserRestRepository, User> {
public class UserServiceTest {

    //
    @Autowired
    public UserService userService;

    @Autowired public UserRestRepository userRestRepository;

    @Autowired public UserRoleRestRepository userRoleRestRepository;

    @Autowired public DataSource platformDataSource;

    @Autowired public UserProfileRestRepository userProfileRestRepository;
//    @Autowired SessionFactory sessionFactory;
//
//    @Test
//    public void getUserByUsername() throws Exception {
//
//        final User user   = this.userService.saveEntity(this.r.get(User.class));
//        final User result = this.userService.getUserByUsername(user.getUsername());
//
//        baseEntity_isValidAndCompare(user, result);
//
//    }
//
//    @Test
//    public void getUserByEmail() throws Exception {
//
//        final User user   = this.userService.saveEntity(this.r.get(User.class));
//        final User result = this.userService.getUserByEmail(user.getEmail());
//
//        baseEntity_isValidAndCompare(user, result);
//
//    }

    //
    @BeforeEach
    public void beforeEach() {

//        super.beforeEach();
//
//        entityClass = User.class;
//        genericService = userService;
        AuthenticatedRunAsManager.runAs("gibson", Role.ROLE_ADMIN, Role.ROLE_USER, Role.ROLE_POSTS);

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
