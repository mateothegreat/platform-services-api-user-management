package platform.services.api.users;

import lombok.extern.log4j.Log4j2;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import platform.services.api.UsersConfig;
import platform.services.api.commons.enums.Role;
import platform.services.api.commons.enums.Status;
import platform.services.api.commons.security.SecurityCryptor;
import platform.services.api.commons.testing.BaseControllerTest;
import platform.services.api.commons.testing.ComposedJUnit5BootTest;
import platform.services.api.commons.testing.EntityRandomizer;
import platform.services.api.users.profiles.UserProfile;
import platform.services.api.users.roles.UserRole;

@Log4j2
@ComposedJUnit5BootTest
//@Transactional
@EnableAutoConfiguration

@ContextConfiguration(classes = { UsersConfig.class, UserController.class }, loader = AnnotationConfigContextLoader.class)
public class UserControllerTest extends BaseControllerTest<User> {

    private    User        user;
    @Autowired UserService userService;

    String passwordPlainText;

    public static Set<UserRole> UserRoleSet() {

        final HashSet<UserRole> set = new HashSet<>(3);

        set.add(new UserRole(Role.ROLE_ADMIN));
        set.add(new UserRole(Role.ROLE_USER));
        set.add(new UserRole(Role.ROLE_POSTS));

        return Collections.unmodifiableSet(set);

    }

    @BeforeEach
    public void beforeEach() {

        user = create();

    }

    public User create() {

        final User r    = (User) EntityRandomizer.get(User.class);
        final User user = new User();

        passwordPlainText = EntityRandomizer.password.getRandomValue();

        user.setUsername(EntityRandomizer.username.getRandomValue());
        user.setPasswordNotEncrypted(passwordPlainText);
        user.setPassword(passwordPlainText);
        user.setParentId(r.getParentId());
        user.setStatus(Status.ACTIVE_TESTING);
        user.setEmail(r.getEmail());


        user.getRoles().add(new UserRole(Role.ROLE_ADMIN));
        user.getRoles().add(new UserRole(Role.ROLE_USER_ADMIN));

//        user.getRoles().add(new UserRole(Role.ROLE_ADMIN));
//        user.getRoles().add(new UserRole(Role.ROLE_POSTS));
//        user.getRoles().add(new UserRole(Role.ROLE_USER));
//        user.getRoles().add(new UserRole(Role.ROLE_USER_ADMIN));

        user.getProfiles().add(new UserProfile(EntityRandomizer.username.getRandomValue()));
        user.getProfiles().add(new UserProfile(EntityRandomizer.username.getRandomValue()));
        user.getProfiles().add(new UserProfile(EntityRandomizer.username.getRandomValue()));
        user.getProfiles().add(new UserProfile(EntityRandomizer.username.getRandomValue()));
        user.getProfiles().add(new UserProfile(EntityRandomizer.username.getRandomValue()));

        final User created = userService.saveEntity(user);

        created.setPasswordNotEncrypted(passwordPlainText);

        assertThat(created.getId()).isGreaterThan(0L);
        assertThat(created.getUsername()).isEqualTo(user.getUsername());
        assertThat(SecurityCryptor.isEncoded(created.getPassword())).isTrue();
        assertThat(created.getEmail()).isEqualTo(user.getEmail());
        assertThat(created.getStatus()).isEqualTo(user.getStatus());

        assertThat(created.getProfiles().isEmpty()).isFalse();
        assertThat(created.getProfiles().size()).isEqualTo(user.getProfiles().size());

        return created;

    }

    @AfterEach
    public void afterEach() {

//        userService.deleteById(user.getId());
//
//        assertThat(userService.existsById(user.getId())).isFalse();

    }

//    @Test
//    void getAllReturnsPageable200() throws Exception {
//
//        getResponseAssertJSON200OK("/users");
//
//    }

    @Test
    void getUser() {

        Optional<User> result = userService.findById(user.getId());

        assertThat(result.isPresent()).isTrue();

    }
    @Test
    void getByUsernameReturns200() {

//        getResponseAssertJSON200OK(user.getUsername(), passwordPlainText, "/users?username=testing-user1");
        getResponseAssertJSON200OK(user.getUsername(), passwordPlainText, "/users");

    }
//
//    @Test
//    void getByUsernameIs404() {
//
//        getResponseAssertJSONandStatusCode("/users?username=newuser4123123", HttpStatus.NOT_FOUND);
//
//    }
//
//    @Test
//    void escalateReturns200() {
//
//        getResponseAssertJSON200OK("/users/escalate");
//
//    }

}
