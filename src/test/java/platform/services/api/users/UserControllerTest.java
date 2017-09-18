package platform.services.api.users;

import lombok.extern.log4j.Log4j2;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import platform.services.api.UsersConfig;
import platform.services.api.commons.enums.Role;
import platform.services.api.commons.enums.Status;
import platform.services.api.commons.testing.BaseControllerTest;
import platform.services.api.commons.testing.ComposedJUnit5BootTest;
import platform.services.api.commons.testing.EntityRandomizer;
import platform.services.api.users.roles.UserRole;

@Log4j2
@ComposedJUnit5BootTest
//@Transactional
@EnableAutoConfiguration(exclude = {

    DataSourceAutoConfiguration.class,
    DataSourceTransactionManagerAutoConfiguration.class,
    HibernateJpaAutoConfiguration.class

})
@ContextConfiguration(classes = { UsersConfig.class, UserController.class }, loader = AnnotationConfigContextLoader.class)
public class UserControllerTest extends BaseControllerTest<User> {

    private    User        user;
    @Autowired UserService userService;

    public static Set<UserRole> UserRoleSet() {

        final HashSet<UserRole> set = new HashSet<>(3);

        set.add(new UserRole(Role.ROLE_ADMIN));
        set.add(new UserRole(Role.ROLE_USER));
        set.add(new UserRole(Role.ROLE_POSTS));

        return Collections.unmodifiableSet(set);

    }

    @BeforeEach
    public void beforeEach() {

        final String plaintextPassword ="asdfasdf";
//        final String plaintextPassword = EntityRandomizer.password.getRandomValue();
        final User   u                 = new User();

//        u.setUsername(EntityRandomizer.username.getRandomValue());
        u.setUsername("asdfasdf");
        u.setPassword(plaintextPassword);
        u.setEmail(EntityRandomizer.email.getRandomValue());
        u.setStatus(Status.ACTIVE);

        log.error(u.getUsername());
        log.error(u.getPassword());
        log.error(plaintextPassword);

//        u.setRoles(UserRoleSet());

        user = userService.saveEntity(u);

        assertThat(user.getId()).isGreaterThan(0L);
        log.warn(u);
        log.warn(user);

        this.setUsername(user.getUsername());
        this.setPassword(plaintextPassword);

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
    void getByUsernameReturns200() {

        getResponseAssertJSON200OK("/users?username=testing-user1");

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
